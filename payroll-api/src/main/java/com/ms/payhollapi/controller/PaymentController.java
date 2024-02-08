package com.ms.payhollapi.controller;

import com.ms.payhollapi.domain.Payroll;
import com.ms.payhollapi.dtos.UserDTO;
import com.ms.payhollapi.integration.UserIntegrationFeign;
import com.ms.payhollapi.service.PayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private PayrollService service;

    @GetMapping("/{workerId}")
    public ResponseEntity<Payroll> getPayment(@PathVariable Long workerId, @RequestBody Payroll payroll) {
        return ResponseEntity.ok(service.getPayment(workerId, payroll));
    }
}
