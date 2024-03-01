package com.pfe.demo.service;

import com.pfe.demo.entity.Device;
import com.pfe.demo.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeviceServiceImpl implements DeviceService{
    @Autowired
    private DeviceRepository deviceRepository;
    @Override
    public Device createDevice(Device device) {
        return deviceRepository.save(device);
    }

    @Override
    public Device getDeviceById(Long deviceId) {
        Optional<Device> optionalDevice = deviceRepository.findById(deviceId);
        return optionalDevice.get();
    }

    @Override
    public List<Device> getAllDevices() {
        return deviceRepository.findAll();
    }

    @Override
    public Device updateDevice(Device device) {
//        Device existingDevice = deviceRepository.findById(device.getImei()).get()
        return null;
    }

    @Override
    public void deleteDevice(Long deviceId) {

    }
}
