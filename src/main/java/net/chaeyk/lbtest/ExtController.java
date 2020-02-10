package net.chaeyk.lbtest;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.convert.DurationStyle;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;

@RestController
@RequestMapping("/ext")
@RequiredArgsConstructor
public class ExtController {
    private final ExtApiFeignClient feignClient;

    @GetMapping({"", "/home"})
    public String home() {
        return feignClient.home();
    }

    @GetMapping("/home/{delay}")
    public String delayHome(@PathVariable("delay") String delayStr) throws InterruptedException {
        Duration delay = DurationStyle.detectAndParse(delayStr);
        Thread.sleep(delay.toMillis());
        return feignClient.home();
    }
}
