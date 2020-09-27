package com.spr.event;

import com.spr.entity.SprUser;

public class SprComplexEvent4UpdateBill extends SprComplexEvent {
    public SprComplexEvent4UpdateBill(Object source, SprUser sprUser) {
        super(source, sprUser);
    }
        
    public SprComplexEvent4UpdateBill(Object source) {
        super(source);
    }
}
