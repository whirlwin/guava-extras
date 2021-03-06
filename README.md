guava-extras
------------

#### Guava's missing sidekick

---

### Usage

- ##### RegexSwitch
A regex matcher implemented in a switch-style

    `````Java
RegexSwitch.<String>test("foo@bar.com")
        .matches("args!").then("first case")
        .matches("bar").then("second case")
        .matches("foo.+").then("third case")
        .otherwise("fourth case");
// Returns "third case"
    `````
    
    `````Java
RegexSwitch.<String>test("foo@bar.com")
        .matches("args!").then("first case")
        .matches("bar").then("second case")
        .otherwise(new Exception("value not found"));
// Throws new Exception
    `````
    `````Java
RegexSwitch.<String>test("foo@bar.com")
        .matches("args!").then("first case")
        .matches("bar").then("second case")
        .matches("foo.+").then("third case")
        .done();
// Returns Optional with value "third case"
    `````

