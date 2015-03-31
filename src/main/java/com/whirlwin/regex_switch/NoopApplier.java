package com.whirlwin.regex_switch;

public final class NoopApplier<T> extends AbstractApplier<T> {

    public NoopApplier(final RegexSwitch theSwitch) {
        super(theSwitch);
    }

    @Override
    public RegexSwitch then(final NoArgFunction noArgFunction) {
        return theSwitch;
    }

    @Override
    public RegexSwitch then(final T o) {
        return theSwitch;
    }
}