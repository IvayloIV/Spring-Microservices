package com.soft2run.queries.config;

import com.soft2run.queries.entity.Purchase;
import org.springframework.core.convert.converter.Converter;

public class StringToPurchaseConverter implements Converter<String, Purchase> {

    @Override
    public Purchase convert(String source) {
        String[] split = source.split(" \\| ");
        return Purchase.builder()
                .name(split[0])
                .description(split[1])
                .build();
    }
}
