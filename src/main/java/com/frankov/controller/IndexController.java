package com.frankov.controller;

import com.frankov.model.Office;
import com.frankov.service.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @Autowired
    private OfficeService officeService;

    @RequestMapping("/branches/{id}")
    public ResponseEntity<Response> getOfficeInfo(@PathVariable String id) {
        if (id == null || id.trim().isEmpty()) {
            return new ResponseEntity<>(new ErrorResponse("branch not found"), HttpStatus.NOT_FOUND);
        }

        int officeId = Integer.valueOf(id);
        Office office = officeService.findInfo(officeId);
        if (office == null) {
            return new ResponseEntity<>(new ErrorResponse("branch not found"), HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(new OkResponse1(office), HttpStatus.OK);
        }
    }

    @RequestMapping("/branches")
    public ResponseEntity<Response> getNearestOffice(@RequestParam String lat, @RequestParam String lon) {
        if (lat == null || lat.trim().isEmpty() || lon == null || lon.trim().isEmpty()) {
            return new ResponseEntity<>(new ErrorResponse("branch not found"), HttpStatus.NOT_FOUND);
        }

        double latDouble = Double.valueOf(lat);
        double lonDouble = Double.valueOf(lon);
        Office office = officeService.findNearest(latDouble, lonDouble);
        if (office == null) {
            return new ResponseEntity<>(new ErrorResponse("branch not found"), HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(new OkResponse2(office), HttpStatus.OK);
        }
    }

    @RequestMapping("branches/{id}/predict")
    public ResponseEntity<Response> getOfficeInfo(@PathVariable String id,
                                                  @RequestParam String dayOfWeek,
                                                  @RequestParam String hourOfDay) {
        if (id == null || id.trim().isEmpty()
        || dayOfWeek == null || dayOfWeek.trim().isEmpty()
        || hourOfDay == null || hourOfDay.trim().isEmpty()) {
            return new ResponseEntity<>(new ErrorResponse("branch not found"), HttpStatus.NOT_FOUND);
        }



        int officeId = Integer.valueOf(id);
        Office office = officeService.findInfo(officeId);
        if (office == null) {
            return new ResponseEntity<>(new ErrorResponse("branch not found"), HttpStatus.NOT_FOUND);
        } else {
            int predict = officeService.predict(office, Integer.valueOf(dayOfWeek), Integer.valueOf(hourOfDay));
            return new ResponseEntity<>(new OkResponse3(office, predict), HttpStatus.OK);
        }
    }

}
