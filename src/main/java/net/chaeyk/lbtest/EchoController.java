package net.chaeyk.lbtest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/echo")
@Slf4j
public class EchoController {

    @GetMapping("/{message}")
    public String echo(@PathVariable String message) {
        log.info("{}: {}", Util.getHostname(), message);
        return Util.getHostname() + ": " + message;
    }
}
