package com.whirlwin.regex_switch;

public final class DefaultApplier extends AbstractApplier {

    public DefaultApplier(final RegexSwitch theSwitch) {
        super(theSwitch);
    }

    @Override
    public RegexSwitch then(final NoArgFunction noArgFunction) {
        noArgFunction.apply();
        return theSwitch;
    }
}
