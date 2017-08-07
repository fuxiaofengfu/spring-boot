package com.hashmap;

/**
 * Created by xiaofengfu on 2017/7/24.
 */
public class Person {

    private String id;
    private String name;
    private String age;

    public Person(String id, String name, String age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        if (id != null ? !id.equals(person.id) : person.id != null) return false;
        return true;
    }*/

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
