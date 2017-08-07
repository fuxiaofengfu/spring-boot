package com.designmodel.data;

/**
 * Created by xiaofengfu on 2017/7/16.
 */
public class XuehaiwuyaPerson {

   private String age;
   private String username;

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "XuehaiwuyaPerson{" +
                "age='" + age + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
