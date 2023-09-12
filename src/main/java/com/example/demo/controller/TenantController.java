package com.example.demo.controller;

import com.example.demo.configuration.TenantContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TenantController {

    @GetMapping("/tenant")
    public ResponseEntity<String> getTenant() {
        String tenant = TenantContext.getCurrentTenant();
        return ResponseEntity.ok("Current Tenant: " + tenant);
    }

    @PostMapping("/tenant/{tenant}")
    public ResponseEntity<Void> setTenant(@PathVariable String tenant) {
        System.out.println("Initial Tenant: " + TenantContext.getCurrentTenant());
        TenantContext.setCurrentTenant(tenant);
        System.out.println("Current Tenant: " + TenantContext.getCurrentTenant());
        return ResponseEntity.ok().build();
    }
}

