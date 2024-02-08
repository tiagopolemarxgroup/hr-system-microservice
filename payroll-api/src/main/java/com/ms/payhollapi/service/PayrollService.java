package com.ms.payhollapi.service;

import com.ms.payhollapi.domain.Payroll;
import com.ms.payhollapi.exceptions.ObjectNotFoundException;
import com.ms.payhollapi.integration.UserIntegrationFeign;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.Objects;

@RequiredArgsConstructor
@Slf4j
@Service
public class PayrollService {
    private final Environment env;
    private final UserIntegrationFeign integrationFeign;

    public Payroll getPayment(Long id, Payroll payroll) {
        log.info("PAYROLL_SERVICE !!! Get request em " + env.getProperty("local.server.port") + "port");

        try {
            var user = integrationFeign.findById(id).getBody();
            if (Objects.nonNull(user)) {
                return new Payroll(user.getName(),
                        payroll.getDescription(),
                        user.getHourPrice(),
                        payroll.getWorkerHours(),
                        payroll.getWorkerHours() * user.getHourPrice());
            }

        } catch (FeignException ex) {
            throw new ObjectNotFoundException("Object not found");
        } catch (Exception ex) {
            throw new IllegalArgumentException("Error illegal argument exception");
        }
        return null;
    }
}
