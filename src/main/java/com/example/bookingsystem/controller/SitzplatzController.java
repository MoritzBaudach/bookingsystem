package com.example.bookingsystem.controller;

import com.example.bookingsystem.controller.request.SitzplatzCreationRequest;
import com.example.bookingsystem.controller.request.SitzplatzUpdateRequest;
import com.example.bookingsystem.model.Sitzplatz;
import com.example.bookingsystem.service.SitzplatzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SitzplatzController {

    @Autowired
    public SitzplatzController(SitzplatzService sitzplatzService) {
        this.sitzplatzService = sitzplatzService;
    }

    private final SitzplatzService sitzplatzService;

    @PostMapping(value = "/sitzplatz",consumes = MediaType.APPLICATION_JSON_VALUE)
    public Sitzplatz createSitzplatz(@RequestBody SitzplatzCreationRequest sitzplatzCreationRequest){
        return sitzplatzService.createSitzplatz(sitzplatzCreationRequest.getPrice());
    }

    @GetMapping(value = "/sitzplaetze", produces = "application/json")
    public List<Sitzplatz> getAllSitzplaetze(){
        return sitzplatzService.getAlleSitzplaetze();
    }



    @PatchMapping(value = "/sitzplatz",consumes = MediaType.APPLICATION_JSON_VALUE)
    public Sitzplatz updateSitzplatz(@RequestBody SitzplatzUpdateRequest sitzplatzUpdateRequest){
        return sitzplatzService.updateSitzplatz(sitzplatzUpdateRequest.getId(), sitzplatzUpdateRequest.getPrice());
    }

    @DeleteMapping(value = "sitzplatz/{id}")
    public boolean deleteSitzplatz(@PathVariable("id") Integer id){
        return sitzplatzService.deleteSitzplatz(id);
    }

}
