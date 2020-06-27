package com.frankov.service;

import com.frankov.model.Office;

public interface OfficeService {

    Office findInfo(int id);

    Office findNearest(double lat, double lon);

    int predict(Office office, int dayOfWeek, int hourOfDay);

}
