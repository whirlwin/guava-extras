package com.whirlwin.regex_switch;

public final class NoopApplier extends AbstractApplier {

    public NoopApplier(final RegexSwitch theSwitch) {
        super(theSwitch);
    }

    @Override
    public RegexSwitch then(final NoArgFunction noArgFunction) {
        return theSwitch;
    }
}