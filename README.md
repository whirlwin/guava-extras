guava-extras
------------

#### Guava's missing sidekick

---

### Usage

- ##### RegexSwitch
A regex matcher implemented in a switch-style

    `````Java
RegexSwitch.test("foo@bar.com")
        .matches("args!").then(() -> System.out.println("first option"))
        .matches("bar").then(() -> System.out.println("second option"))
        .matches("foo.+").then(() -> System.out.println("third option"))
        .otherwise(() -> System.out.println("fourth option"));
// Prints "third option"
    `````

