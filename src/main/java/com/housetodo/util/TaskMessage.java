package com.housetodo.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum TaskMessage {
    TASK_NOT_FOUND("The task was not found"),
    TASK_SAVED("The task was saved successfully"),
    TASK_UPDATED("The task was updated"),
    TASK_DELETED("The task was deleted"),
    EMPTY("There are no available tasks"),
    BAD_REQUEST("Bad request");

    @Getter
    private final String taskMessage;
}
