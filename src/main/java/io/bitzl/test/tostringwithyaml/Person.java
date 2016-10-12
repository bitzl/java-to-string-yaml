package io.bitzl.test.tostringwithyaml;

import org.joda.time.DateTime;

import static io.bitzl.test.tostringwithyaml.ToString.stringRepresentationOf;

public class Person {

    private String name;

    private DateTime birthday;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DateTime getBirthday() {
        return birthday;
    }

    public void setBirthday(DateTime birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return stringRepresentationOf(this);
    }

}
