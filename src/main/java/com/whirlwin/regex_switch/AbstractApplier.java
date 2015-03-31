package com.whirlwin.regex_switch;

public abstract class AbstractApplier<T> {

    protected final RegexSwitch theSwitch;

    protected AbstractApplier(final RegexSwitch theSwitch) {
        this.theSwitch = theSwitch;
    }

    public abstract RegexSwitch then(final NoArgFunction noArgFunction);
    
    public abstract RegexSwitch then(T t);
}