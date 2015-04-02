package com.whirlwin.regex_switch.internal;

public final class Case<T> {
    
    private String testValue;
    private T returnValue;

    public Case(final String testValue) {
        this.testValue = testValue;
    }

    public String getTestValue() {
        return testValue;
    }

    public void setTestValue(final String testValue) {
        this.testValue = testValue;
    }

    public T getReturnValue() {
        return returnValue;
    }

    public void setReturnValue(final T returnValue) {
        this.returnValue = returnValue;
    }

    @Override
    public String toString() {
        return "Case{" +
                "testValue='" + testValue + '\'' +
                ", returnValue=" + returnValue +
                '}';
    }
}
