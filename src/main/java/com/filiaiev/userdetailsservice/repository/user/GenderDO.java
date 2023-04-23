package com.filiaiev.userdetailsservice.repository.user;

import lombok.AllArgsConstructor;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@AllArgsConstructor
public enum GenderDO {

    MALE("male"),
    FEMALE("female");

    public final String value;

    private static final Map<String, GenderDO> gendersMap = Stream.of(GenderDO.values())
            .collect(Collectors.toMap(role -> role.value, Function.identity()));

    public static GenderDO forValue(String id) {
        return gendersMap.get(id);
    }
}
