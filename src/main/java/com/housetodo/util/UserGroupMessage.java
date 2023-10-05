package com.housetodo.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum UserGroupMessage {
    EMPTY("There are no available user groups");

    @Getter
    private final String userGroupMessage;
}


