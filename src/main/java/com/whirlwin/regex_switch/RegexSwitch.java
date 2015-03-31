package com.whirlwin.regex_switch;

public final class RegexSwitch<T> {

    private final Case<T> caze;
    
    private boolean hasMatch;
    
    private RegexSwitch(final String testValue) {
        caze = new Case<>(testValue);
    }

    public static <T> RegexSwitch test(final String testValue) {
        return new RegexSwitch<T>(testValue);
    }
    
    public AbstractApplier matches(final String regex) {
        AbstractApplier applier;
        if (caze.getTestValue().matches(regex) && !hasMatch) {
            hasMatch = true;
            applier = new DefaultApplier(this);
        } else {
            applier = new NoopApplier(this);
        }
        return applier;
    }
    
    public T otherwise(final T value) {
        return hasMatch ? caze.getReturnValue() : value;
    }
    
    public T otherwise(final NoArgFunction noArgFunction) {
        if (hasMatch) {
           return caze.getReturnValue();
        } else {
            noArgFunction.apply();
            return null;
        }
    }

    public Case<T> getCaze() {
        return caze;
    }
}
