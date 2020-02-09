package net.chaeyk.lbtest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ping")
public class PingController {

    private int statusCode = HttpStatus.OK.value();

    @GetMapping
    public ResponseEntity<String> ping() {
        return ResponseEntity.status(statusCode).body("OK - " + statusCode);
    }

    @PostMapping("/code/{statusCode}")
    public String setStatusCode(@PathVariable int statusCode) {
        this.statusCode = statusCode;
        return "OK - " + statusCode;
    }
}
