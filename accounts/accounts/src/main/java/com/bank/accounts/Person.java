package com.bank.accounts;

import lombok.Data;

@Data
public class Person {
    private String name;
    private int age;
}

class TestLombok {

    public static void main(String[] args) {
        Person p = new Person();
        p.setName("Ali");
        p.setAge(30);

        System.out.println(p); // Person(name=Ali, age=30)
    }
}
