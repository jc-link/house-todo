package com.housetodo.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum TaskScheduleMessage {
    NOT_FOUND("The task schedule was not found"),
    DELETED("The task schedule was deleted"),
    EMPTY("There are no available task schedules");

    @Getter
    private final String taskScheduleMessage;
}
