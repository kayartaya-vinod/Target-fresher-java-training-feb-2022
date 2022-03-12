package com.targetindia.model;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Cat extends Animal{

    @Override
    public void whoAmI() {
        log.trace("I am a cat");
    }

    @Override
    public void talk() {
        log.trace("Meow...");
    }
}
