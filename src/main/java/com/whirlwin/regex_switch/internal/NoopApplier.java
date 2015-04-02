package com.whirlwin.regex_switch.internal;

import com.whirlwin.regex_switch.RegexSwitch;

public final class NoopApplier<T> extends AbstractApplier<T> {

    public NoopApplier(final RegexSwitch<T> theSwitch) {
        super(theSwitch);
    }

    @Override
    public RegexSwitch<T> then(final T o) {
        return theSwitch;
    }
}