guava-extras
------------

#### Guava's missing sidekick

---

### Usage

- ##### RegexSwitch
A regex matcher implemented in a switch-style

    `````Java
RegexSwitch.test("foo@bar.com")
        .matches("args!").then("first case")
        .matches("bar").then("second case")
        .matches("foo.+").then("third case")
        .otherwise("fourth case");
// Prints "third case"
    `````

