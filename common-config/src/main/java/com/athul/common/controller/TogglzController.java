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
    public boolean getData(@RequestParam String key)
    {
        return MyToggles.valueOf(key).isActive();
    }

    @GetMapping(value = "/togglz-state-criteria")
    public boolean isActiveForCriteria(@RequestParam String criteria) {
        return MyToggles.TEST_LABEL_1.isActiveForCriteria(criteria);
    }
}
