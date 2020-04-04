package com.athul.common.controller;

import com.athul.common.toggles.MyToggles;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/")
public class TogglzController
{

    @GetMapping(value = "/togglz-state")
    public String getData(@RequestParam String key) {
        if (MyToggles.valueOf(key).isActive()) {
            return "Toggle: " + key + " is active ";
        } else {
            return "Toggle: " + key + " IS NOT active";
        }

    }

    @GetMapping(value = "/togglz-state-criteria")
    public String isActiveForCriteria(@RequestParam String key, @RequestParam String criteria) {

        if (MyToggles.valueOf(key).isActiveForCriteria(criteria)) {
            return "Toggle: " + key + " is active for criteria: " + criteria;
        } else {
            return "Toggle: " + key + " is NOT ACTIVE for criteria: " + criteria;
        }
    }
}
