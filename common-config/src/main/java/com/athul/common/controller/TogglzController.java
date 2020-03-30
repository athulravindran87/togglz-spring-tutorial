package com.athul.common.controller;

import com.athul.common.toggles.MyToggles;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/")
public class TogglzController
{

    @GetMapping(value = "/togglz-state")
    public String getData(@RequestParam String key)
    {
        return "State of "+key +" is "+MyToggles.valueOf(key).isActive();
    }
}
