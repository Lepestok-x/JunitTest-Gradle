package com.example.configurations.types;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Value {
    // Перечислляем enum значении
    DOUBLE_CLICK("You have done a double click"),
    RIGHT_CLICK("You have done a right click"),
    CLICK_ME("You have done a dynamic click");
    private final String value;
}
