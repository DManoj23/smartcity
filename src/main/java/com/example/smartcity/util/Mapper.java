package com.example.smartcity.util;

import com.example.smartcity.entity.Sensor;
import com.example.smartcity.dto.SensorDto;
import java.time.Instant;

public class Mapper {
    public static SensorDto toDto(Sensor s) {
        if (s == null) return null;
        SensorDto d = new SensorDto();
        d.setId(s.getId());
        d.setName(s.getName());
        d.setType(s.getType());
        d.setLocation(s.getLocation());
        d.setLastValue(s.getLastValue());
        d.setLastSeen(s.getLastSeen());
        return d;
    }
}
