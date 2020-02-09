package net.chaeyk.lbtest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ping")
@Slf4j
public class PingController {

    private int statusCode = HttpStatus.OK.value();

    @GetMapping
    public ResponseEntity<String> ping() {
        log.info("ping");
        return ResponseEntity.status(statusCode).body("OK - " + statusCode);
    }

    @PostMapping("/code/{statusCode}")
    public String setStatusCode(@PathVariable int statusCode) {
        this.statusCode = statusCode;
        return "OK - " + statusCode;
    }
}
