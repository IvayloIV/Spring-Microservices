package com.soft2run.queries.config;

import com.soft2run.queries.entity.Purchase;
import org.springframework.core.convert.converter.Converter;

public class PurchaseToStringConverter implements Converter<Purchase, String> {

    @Override
    public String convert(Purchase source) {
        return source.getName() + " | " + source.getDescription();
    }
}
