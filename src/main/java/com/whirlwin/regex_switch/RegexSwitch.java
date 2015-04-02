package com.whirlwin.regex_switch;

import java.util.Optional;

import com.whirlwin.regex_switch.internal.AbstractApplier;
import com.whirlwin.regex_switch.internal.Case;
import com.whirlwin.regex_switch.internal.DefaultApplier;
import com.whirlwin.regex_switch.internal.NoopApplier;

public final class RegexSwitch<T> {

    private final Case<T> caze;
    
    private boolean hasMatch;
    
    private RegexSwitch(final String testValue) {
        caze = new Case<>(testValue);
    }

    public static <T> RegexSwitch<T> test(final String testValue) {
        return new RegexSwitch<>(testValue);
    }
    
    public AbstractApplier<T> matches(final String regex) {
        if (caze.getTestValue().matches(regex) && !hasMatch) {
            hasMatch = true;
            return new DefaultApplier<>(this);
        } else {
            return new NoopApplier<>(this);
        }
    }
    
    public T otherwise(final T value) {
        return hasMatch ? caze.getReturnValue() : value;
    }
    
    public T otherwise(final Exception e) throws Exception {
        if (hasMatch) {
            return caze.getReturnValue();
        } else {
            throw e;
        }
    }
    
    public Optional<T> done() {
        return Optional.ofNullable(caze.getReturnValue());
    }
    
    public Case<T> getCaze() {
        return caze;
    }
}
