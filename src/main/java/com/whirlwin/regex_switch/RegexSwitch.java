package com.whirlwin.regex_switch;

public final class RegexSwitch {

    private final String value;
    private boolean hasMatch;

    public RegexSwitch(final String value) {
        this.value = value;
    }

    public static RegexSwitch test(final String value) {
        return new RegexSwitch(value);
    }

    public AbstractApplier matches(final String regex) {
        AbstractApplier applier;
        if (value.matches(regex) && !hasMatch) {
            hasMatch = true;
            applier = new DefaultApplier(this);
        } else {
            applier = new NoopApplier(this);
        }
        return applier;
    }

    public void otherwise(final NoArgFunction noArgFunction) {
        if (!hasMatch) {
            noArgFunction.apply();
        }
    }
}
