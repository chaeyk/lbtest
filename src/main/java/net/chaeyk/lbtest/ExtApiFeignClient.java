package net.chaeyk.lbtest;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "extApi", url = "${ext-api:no-server}")
public interface ExtApiFeignClient {
    @GetMapping
    String home();
}
