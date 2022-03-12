package com.targetindia.model;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Dog extends Animal{

    @Override
    public void whoAmI() {
        log.trace("I am a dog");
    }

    @Override
    public void talk() {
        log.trace("Bow bow..");
    }
}
