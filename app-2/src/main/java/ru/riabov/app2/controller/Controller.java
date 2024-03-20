package ru.riabov.app2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@RestController
@RequiredArgsConstructor
public class Controller {

    @RequestMapping("/getClientString")
    public String getClientString() throws InterruptedException {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        Thread.sleep(random.nextInt(10000));
        return "getClientString";
    }

    @RequestMapping("/getServiceString")
    public String getServiceString() throws InterruptedException {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        Thread.sleep(random.nextInt(1000));
        return "serviceString";
    }
}
