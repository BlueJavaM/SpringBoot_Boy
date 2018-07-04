package com.bluepro.boy.domain;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/*
 *@Author: XieLiang
 *@Date : 2018/7/4
 *@Comment :
 */
@Entity
public class Boy {
    @Id
    @GeneratedValue
    private Integer id;
    private String boyName;
    private int age;
    private String jjSize;

    public Boy() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBoyName() {
        return boyName;
    }

    public void setBoyName(String boyName) {
        this.boyName = boyName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getJjSize() {
        return jjSize;
    }

    public void setJjSize(String jjSize) {
        this.jjSize = jjSize;
    }
}
