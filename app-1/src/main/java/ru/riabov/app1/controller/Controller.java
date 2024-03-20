package ru.riabov.app1.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import ru.riabov.app1.client.Client;

import java.util.concurrent.ThreadLocalRandom;

@RestController
@RequiredArgsConstructor
public class Controller {

    private final Client client;
    private final RestTemplate rest;

    @RequestMapping("/getClientString")
    public String getClientString() throws InterruptedException {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        Thread.sleep(random.nextInt(1000));
        return client.getString();
    }

    @RequestMapping("getServiceString")
    public String getServiceString() throws InterruptedException {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        Thread.sleep(random.nextInt(1000));
        return "serviceString";
    }
}
