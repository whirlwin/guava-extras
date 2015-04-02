import java.util.Optional;

import com.whirlwin.regex_switch.RegexSwitch;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public final class RegexSwitchTest {

    @Test
    public void test_case() {
        final String res = RegexSwitch.<String>test("foo@bar.com")
                .matches("args!").then("args")
                .matches("foo.+").then("foo")
                .otherwise("bar");
        assertEquals(res, "foo");
    }

    @Test
    public void test_otherwise() {
        final String res = RegexSwitch.<String>test("foo@bar.com")
                .matches("args!").then("args")
                .matches("foobar.+").then("foo")
                .otherwise("bar");
        assertEquals(res, "bar");
    }
    
    @Test(expected = Exception.class)
    public void test_otherwise_exception() throws Exception {
        RegexSwitch.<String>test("foo@bar.com")
                .matches("args!").then("args")
                .matches("foobar.+").then("foo")
                .otherwise(new Exception("Successfully threw exception in test"));
    }

    @Test
    public void test_done_present() {
        final Optional<String> res = RegexSwitch.<String>test("foo@bar.com")
                .matches("args!").then("args")
                .matches("foo.+").then("foo")
                .matches("foobar.+").then("foobar")
                .done();
        assertTrue(res.isPresent());
        assertEquals(res.get(), "foo");
    }

    @Test
    public void test_done_absent() {
        final Optional<String> res = RegexSwitch.<String>test("foo@bar.com")
                .matches("args!").then("args")
                .matches("foobar.+").then("foobar")
                .done();
        assertFalse(res.isPresent());
    }
}
