package com.whirlwin.regex_switch.internal;

import com.whirlwin.regex_switch.RegexSwitch;

public abstract class AbstractApplier<T> {

    protected final RegexSwitch<T> theSwitch;

    protected AbstractApplier(final RegexSwitch<T> theSwitch) {
        this.theSwitch = theSwitch;
    }

    public abstract RegexSwitch<T> then(final T r);
}