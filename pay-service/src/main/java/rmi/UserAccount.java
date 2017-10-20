package rmi;

import java.io.Serializable;

/**
 * Created by xiaofengfu on 2017/10/20.
 */
public class UserAccount implements Serializable{

    private String username;
    private String gender;
    private String age;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
