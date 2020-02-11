package net.chaeyk.lbtest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/echo")
@Slf4j
public class EchoController {

    @GetMapping("/{message}")
    public String echo(@PathVariable String message, @RequestParam(name = "delay", required = false) String delayStr) throws InterruptedException {
        log.info("{}: {}", Util.getHostname(), message);
        if (!StringUtils.isEmpty(delayStr)) {
            Util.sleep(delayStr);
        }
        return Util.getHostname() + ": " + Util.now() + ": " + message;
    }
}
