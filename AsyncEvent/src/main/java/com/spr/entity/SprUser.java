package com.spr.entity;

public class SprUser {
    private Long id;
    private Integer age;
    private String name;

   

    /************************************* Constructor *************************************/
    private SprUser() {
    }

    private SprUser(Long id, Integer age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }
    public static SprUser builder (Long id, Integer age, String name){
        return new SprUser(id, age, name);
    }
    @Override
    public String toString() {
        return "SprUser{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    /************************************ Getter Setter ************************************/
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
