package com.pfe.demo.controller;

import com.pfe.demo.entity.Device;
import com.pfe.demo.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/device")
public class DeviceController {
    @Autowired
    private DeviceService deviceService;

    @PostMapping("/addDevice")
    public ResponseEntity<Device> createDevice(@RequestBody Device device){
        Device savedDevice = deviceService.createDevice(device);
        return new ResponseEntity<>(savedDevice, HttpStatus.CREATED);
    }
}
