package com.targetindia.model;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class Animal {


    public void whoAmI(){
        log.trace("I am an animal");
    }

    // this method is inherited to all the subclasses, but an abstract function may exist only in an abstract class
    // this means the subclasses also must be marked as "abstract" or they should override this inherited
    // abstract method.
    public abstract void talk();
}
