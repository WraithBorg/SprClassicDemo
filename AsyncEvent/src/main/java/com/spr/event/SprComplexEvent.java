package com.spr.event;

import com.spr.entity.SprUser;
import org.springframework.context.ApplicationEvent;

public class SprComplexEvent extends ApplicationEvent {
    private SprUser sprUser;

    /************************************* Constructor *************************************/
    protected SprComplexEvent(Object source) {
        super(source);
    }

    public SprComplexEvent(Object source, SprUser sprUser) {
        super(source);
        this.sprUser = sprUser;
    }

    /************************************ Getter Setter ************************************/
    public SprUser getSprUser() {
        return sprUser;
    }

    public void setSprUser(SprUser sprUser) {
        this.sprUser = sprUser;
    }


}
