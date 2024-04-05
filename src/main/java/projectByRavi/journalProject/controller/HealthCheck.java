package projectByRavi.journalProject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class HealthCheck {
    @GetMapping(value = "/health-check")
    String healthCheck()
    {
        return "OK";
    }
}
