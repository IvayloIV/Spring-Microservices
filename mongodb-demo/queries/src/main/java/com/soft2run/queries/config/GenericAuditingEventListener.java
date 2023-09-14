package com.soft2run.queries.config;

import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.AfterDeleteEvent;
import org.springframework.data.mongodb.core.mapping.event.AfterSaveEvent;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class GenericAuditingEventListener extends AbstractMongoEventListener<Object> {

    @Override
    public void onAfterSave(AfterSaveEvent<Object> event) {
        Object source = event.getSource();
        System.out.println(LocalDateTime.now() + " Object saved: " + source.getClass());
    }

    @Override
    public void onAfterDelete(AfterDeleteEvent<Object> event) {
        Object source = event.getSource();
        System.out.println(LocalDateTime.now() + " Object deleted: " + source.getClass());
    }
}
