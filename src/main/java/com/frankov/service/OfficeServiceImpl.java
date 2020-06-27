package com.frankov.service;

import com.frankov.dao.Branch;
import com.frankov.dao.OfficeRepository;
import com.frankov.model.Office;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfficeServiceImpl implements OfficeService {

    private static final double EARTH_RADIUS_IN_METERS = 6_371_000;

    @Autowired
    OfficeRepository officeRepository;

    @Override
    public Office findInfo(int id) {
        Office office = null;
        try {
            Branch branchEntity = officeRepository.getOne(id);
            office =
                    new Office(
                            branchEntity.getId(),
                            branchEntity.getTitle(),
                            branchEntity.getLon(),
                            branchEntity.getLat(),
                            branchEntity.getAddress()
                            );
        } catch (Exception e) {
            System.out.println("Error while getting office info with id = " + id);
            e.printStackTrace();
        }

        return office;
    }

    @Override
    public Office findNearest(double lat, double lon) {
        List<Branch> offices = officeRepository.findAll();
        if (offices.isEmpty()) {
            return null;
        }

        double latRadians = Math.toRadians(lat);
        double lonRadians = Math.toRadians(lon);

        Branch nearestOffice = null;
        Double nearestOfficeDistance = null;
        for (Branch office : offices) {
            double distanceTo = calculateDistanceTo(latRadians, lonRadians, office);
            if (nearestOfficeDistance == null || nearestOfficeDistance > distanceTo) {
                nearestOfficeDistance = distanceTo;
                nearestOffice = office;
            }
        }

        return new Office(
                nearestOffice.getId(),
                nearestOffice.getTitle(),
                nearestOffice.getLon(),
                nearestOffice.getLat(),
                nearestOffice.getAddress(),
                Math.round(nearestOfficeDistance)
        );
    }

    @Override
    public int predict(Office office, int dayOfWeek, int hourOfDay) {

        return 0;
    }

    private double calculateDistanceTo(double latRadians, double lonRadians, Branch office) {
        double officeLatRadians = Math.toRadians(office.getLat());
        double officeLonRadians = Math.toRadians(office.getLon());

        double latSin = Math.sin((officeLatRadians - latRadians) / 2);
        double lonSin = Math.sin((officeLonRadians - lonRadians) / 2);

        double cosLatClient = Math.cos(latRadians);
        double cosLatOffice = Math.cos(officeLatRadians);

        double sqrt = Math.sqrt((latSin * latSin) + (cosLatClient * cosLatOffice * (lonSin * lonSin)));

        return (EARTH_RADIUS_IN_METERS * 2) * sqrt;
    }

}
