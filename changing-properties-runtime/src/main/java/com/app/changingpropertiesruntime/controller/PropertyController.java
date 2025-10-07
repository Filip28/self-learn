package com.app.changingpropertiesruntime.controller;

import com.app.changingpropertiesruntime.ExampleBean;
import com.app.changingpropertiesruntime.service.PropertyUpdateService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/properties")
public class PropertyController {

    private final PropertyUpdateService propertyUpdaterService;

    private final ExampleBean exampleBean;

    public PropertyController(PropertyUpdateService propertyUpdaterService, ExampleBean exampleBean) {
        this.propertyUpdaterService = propertyUpdaterService;
        this.exampleBean = exampleBean;
    }

    @PostMapping("/update")
    public String updateProperty(@RequestParam String key, @RequestParam String value) {
        propertyUpdaterService.updateProperty(key, value);
        return "Property updated. Remember to call the actuator /actuator/refresh";
    }

    @GetMapping("/customProperty")
    public String getCustomProperty() {
        return exampleBean.getCustomProperty();
    }
}
