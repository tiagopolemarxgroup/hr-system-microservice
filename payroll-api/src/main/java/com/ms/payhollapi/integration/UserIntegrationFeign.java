package com.ms.payhollapi.integration;

import com.ms.payhollapi.dtos.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "user-api", url = "http://localhost:8000/api/users")
public interface UserIntegrationFeign {
    @GetMapping("/{id}")
    ResponseEntity<UserDTO> findById(@PathVariable Long id);

    @GetMapping
    ResponseEntity<List<UserDTO>> findAll();



}
