package com.housetodo.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum AppUserMessage {
    NOT_FOUND("The App user was not found"),
    SAVED("The App user was saved successfully"),
    UPDATED("The App user was updated"),
    DELETED("The App user was deleted"),
    EMPTY("There are no available App users"),
    BAD_REQUEST("Bad request");

    @Getter
    private final String appUserMessage;
}
