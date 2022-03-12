package com.targetindia.model;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Tiger extends Animal{

    @Override
    public void whoAmI() {
        log.trace("I am a tiger");
    }

    public void talk(){
        log.trace("Grrr....");
    }

    public void dance(){
        log.trace("Tiger dancing...");
    }
}
