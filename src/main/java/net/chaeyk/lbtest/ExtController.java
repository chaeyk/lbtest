package net.chaeyk.lbtest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ext")
@RequiredArgsConstructor
@Slf4j
public class ExtController {
    private final ExtApiFeignClient feignClient;

    @GetMapping({"", "/home"})
    public String home(
            @RequestParam(required = false) String message,
            @RequestParam(name = "delay", required = false) String delayStr) throws InterruptedException {
        if (!StringUtils.isEmpty(log)) {
            log.info("{}: {}", Util.getHostname(), message);
        }
        if (!StringUtils.isEmpty(delayStr)) {
            Util.sleep(delayStr);
        }
        return feignClient.home();
    }

    @GetMapping("/home/{delay}")
    public String delayHome(@PathVariable("delay") String delayStr) throws InterruptedException {
        Util.sleep(delayStr);
        return feignClient.home();
    }
}
