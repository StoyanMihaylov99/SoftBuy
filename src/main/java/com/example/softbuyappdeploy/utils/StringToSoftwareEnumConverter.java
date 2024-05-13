package com.example.softbuyappdeploy.utils;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.convert.converter.Converter;
@ComponentScan
public class StringToSoftwareEnumConverter implements Converter<String,SoftWareType> {

    @Override
    public SoftWareType convert(String source) {
        try {
            return SoftWareType.valueOf(source.toUpperCase());
        } catch (IllegalArgumentException e) {
            // Handle the case where the provided string doesn't match any enum constant
            throw new IllegalArgumentException("Invalid Software type: " + source);
        }
    }
}
