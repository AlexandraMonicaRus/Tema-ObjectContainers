package com.assignment5.java;

import java.util.Objects;

public class Person {
    private final String cnp;
    private final String name;
    private final int age;


    Person(String name, int age, String cnp) {
        this.name = name;
        this.age = age;
        this.cnp = cnp;

    }

    public String getCnp() {
        return cnp;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", jobStatus='" + getClass().getSimpleName() + '\'' +
                '}' + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return (Objects.equals(cnp, person.cnp) && (person.name.equals(name)));
    }
}
