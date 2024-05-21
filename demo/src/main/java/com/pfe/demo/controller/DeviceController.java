package com.pfe.demo.controller;

import com.pfe.demo.entity.Device;
import com.pfe.demo.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000") // Allow requests from specific origin
@RequestMapping("/device")
public class DeviceController {
    @Autowired
    private DeviceService deviceService;

    @PostMapping("/addDevice")
    public ResponseEntity<Device> createDevice(@RequestBody Device device){
        Device savedDevice = deviceService.createDevice(device);
        return new ResponseEntity<>(savedDevice, HttpStatus.CREATED);
    }
    @GetMapping("getDeviceById/{id}")
    public ResponseEntity<Device> getDeviceById(@PathVariable("id") Long DeviceId){
        Device device = deviceService.getDeviceById(DeviceId);
        return new ResponseEntity<>(device, HttpStatus.OK);
    }

    @GetMapping("/getAllDevices")
    public ResponseEntity<List<Device>> getAllDevices(){
        List<Device> devices = deviceService.getAllDevices();
        return new ResponseEntity<>(devices, HttpStatus.OK);
    }
    @PutMapping("/updateDeviceById/{id}")
    public ResponseEntity<Device> updateDevice(@PathVariable("id") Long deviceId,
                                           @RequestBody Device device){
        device.setImei(deviceId);
        Device updatedDevice = deviceService.updateDevice(device);
        return new ResponseEntity<>(updatedDevice, HttpStatus.OK);
    }

    @DeleteMapping("/deleteDevice/{id}")
    public ResponseEntity<String> deleteDevice(@PathVariable("id") Long deviceId){
        deviceService.deleteDevice(deviceId);
        return new ResponseEntity<>("Device successfully deleted!", HttpStatus.OK);
    }
}
