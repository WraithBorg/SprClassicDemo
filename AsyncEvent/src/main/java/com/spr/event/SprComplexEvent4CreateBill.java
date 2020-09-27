package com.spr.event;

import com.spr.entity.SprUser;

public class SprComplexEvent4CreateBill extends SprComplexEvent {
    public SprComplexEvent4CreateBill(Object source, SprUser sprUser) {
        super(source, sprUser);
    }

    public SprComplexEvent4CreateBill(Object source) {
        super(source);
    }
}
