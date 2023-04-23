package com.filiaiev.userdetailsservice.repository.user;

import jakarta.persistence.AttributeConverter;

public class UserGenderDOConverter implements AttributeConverter<GenderDO, String> {

    @Override
    public String convertToDatabaseColumn(GenderDO attribute) {
        return attribute.value;
    }

    @Override
    public GenderDO convertToEntityAttribute(String value) {
        return GenderDO.forValue(value);
    }
}
