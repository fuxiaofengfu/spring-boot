package com.test.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by xiaofengfu on 2017/7/7.
 */
@Entity
@Table(name = "spring_boot_idcard")
public class SpringBootIdCard implements Serializable{

    private Integer id;
    private String cardNo;
    private Integer personId;
    private Date expire;
    private String transPropagation;
    @GeneratedValue
    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public Date getExpire() {
        return expire;
    }

    public void setExpire(Date expire) {
        this.expire = expire;
    }

    public String getTransPropagation() {
        return transPropagation;
    }

    public void setTransPropagation(String transPropagation) {
        this.transPropagation = transPropagation;
    }
}
