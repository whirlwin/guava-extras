package com.whirlwin.regex_switch.internal;

import com.whirlwin.regex_switch.RegexSwitch;

public final class DefaultApplier<T> extends AbstractApplier<T> {

    public DefaultApplier(final RegexSwitch<T> theSwitch) {
        super(theSwitch);
    }

    @Override
    public RegexSwitch<T> then(final T o) {
        theSwitch.getCaze().setReturnValue(o);
        return theSwitch;
    }
}
