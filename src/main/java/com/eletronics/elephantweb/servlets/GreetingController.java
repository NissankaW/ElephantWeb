/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eletronics.elephantweb.servlets;

import com.eletronics.elephantweb.database.tables.daos.ConfigurationDefaultDao;
import com.eletronics.elephantweb.database.tables.pojos.ConfigurationPojo;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

/**
 * @author nissanka
 */
@RestController
@RequiredArgsConstructor
public class GreetingController {

    @NonNull
    private final ConfigurationDefaultDao config;

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    //http://localhost:8080/ElephantWeb/greeting?name=Nissanka

    @RequestMapping("/greeting")
    public String greeting(@RequestParam(defaultValue = "World") String name) {
        return "" + counter.incrementAndGet() + String.format(template, name);
    }

    @RequestMapping("/config")
    public String config(@RequestParam(required = false) String name, @RequestParam(required = false) String value) {
        if (name == null) {
            return String.join(",", config.findAll().stream().map(ConfigurationPojo::toString).collect(Collectors.toList()));
        }
        ConfigurationPojo configurationPojo = config.fetchOneByName(name);
        if (configurationPojo != null) {
            configurationPojo.setValue(value);
            config.update(configurationPojo);
            return configurationPojo.toString();
        }
        return "No such config variable " + name;
    }
}
