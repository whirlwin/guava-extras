public final class RegexSwitch {

    private final String value;

    public RegexSwitch(final String value) {
        this.value = value;
    }

    public static RegexSwitch test(final String value) {
        return new RegexSwitch(value);
    }

    public Applier matches(final String regex) {
        return value.matches(regex) ? new DefaultApplier(this) : new NoopApplier(this);
    }

    public static abstract class Applier {

        protected final RegexSwitch theSwitch;

        public Applier(final RegexSwitch theSwitch) {
            this.theSwitch = theSwitch;
        }

        abstract RegexSwitch then(final NoArgFunction noArgFunction);
    }

    public static final class DefaultApplier extends Applier {

        public DefaultApplier(final RegexSwitch theSwitch) {
            super(theSwitch);
        }

        @Override
        public RegexSwitch then(final NoArgFunction noArgFunction) {
            noArgFunction.apply();
            return theSwitch;
        }
    }

    public static final class NoopApplier extends Applier {

        public NoopApplier(final RegexSwitch theSwitch) {
            super(theSwitch);
        }

        @Override
        public RegexSwitch then(final NoArgFunction noArgFunction) {
            return theSwitch;
        }
    }
}
