package net.chaeyk.lbtest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/long")
public class LongController {

    @GetMapping("/{delay}")
    public String longApi(@PathVariable("delay") String delayStr) throws InterruptedException {
        Util.sleep(delayStr);
        return Util.getHostname() + ": " + Util.now() + ": OK";
    }
}
