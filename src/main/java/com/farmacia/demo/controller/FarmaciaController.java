package com.farmacia.demo.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.farmacia.demo.model.FarmaciaProperties;
@RestController
public class FarmaciaController {

    private final FarmaciaProperties farmaciaProperties;

    public FarmaciaController(FarmaciaProperties farmaciaProperties) {
        this.farmaciaProperties = farmaciaProperties;
    }

    @GetMapping("/farmacia/info")
    public FarmaciaProperties getInfo() {
        return farmaciaProperties;
    }
}

