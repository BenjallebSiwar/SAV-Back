package com.pfe.demo.service;

import com.pfe.demo.entity.Device;
import org.springframework.stereotype.Service;

import java.util.List;


public interface DeviceService {
    Device createDevice(Device device);
    Device getDeviceById(Long deviceId);

    List<Device> getAllDevices();

    Device updateDevice(Device device);

    void deleteDevice(Long deviceId);

}

