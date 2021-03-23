package com.sda.shop.events;

import org.springframework.context.ApplicationEvent;

public class EditCategoryEvent extends ApplicationEvent {
    private  String categoryDescription;
    public EditCategoryEvent(Object source, String categoryDescription) {
        super(source);
        this.categoryDescription= categoryDescription;
    }

    @Override
    public String toString() {
        return "EditCategoryEvent{" +
                "categoryDescription='" + categoryDescription + '\'' +
                '}';
    }
}
