package com.whirlwin.regex_switch;

public final class DefaultApplier<T> extends AbstractApplier<T> {

    public DefaultApplier(final RegexSwitch theSwitch) {
        super(theSwitch);
    }

    @Override
    public RegexSwitch then(final NoArgFunction noArgFunction) {
        noArgFunction.apply();
        return theSwitch;
    }

    @Override
    public RegexSwitch then(final T o) {
        theSwitch.getCaze().setReturnValue(o);
        return theSwitch;
    }
}
