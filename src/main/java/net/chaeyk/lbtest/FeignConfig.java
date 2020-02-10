package net.chaeyk.lbtest;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackageClasses = ExtApiFeignClient.class)
public class FeignConfig {
}
