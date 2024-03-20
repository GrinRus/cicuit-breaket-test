package ru.riabov.app1.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "app-2", url = "app2:8080")
public interface Client {

    @GetMapping(path = "/getClientString")
    String getString();
}
