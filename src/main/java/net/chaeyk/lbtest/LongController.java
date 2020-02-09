package net.chaeyk.lbtest;

import org.springframework.boot.convert.DurationStyle;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;

@RestController
@RequestMapping("/long")
public class LongController {

    @GetMapping("/{delay}")
    public String longApi(@PathVariable("delay") String delayStr) throws InterruptedException {
        Duration delay = DurationStyle.detectAndParse(delayStr);
        Thread.sleep(delay.toMillis());
        return Util.getHostname() + ": " + Util.now() + ": OK";
    }
}
