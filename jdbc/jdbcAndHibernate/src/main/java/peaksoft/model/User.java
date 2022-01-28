package peaksoft.model;

import javax.persistence.*;

@Table
public class User {
    @Id
    private Long id;

    @Column
    private String name;

    @Column
    private String last_Name;

    @Column
    private Byte age;

    public User() {
    }

    public User(String name, String last_Name, Byte age) {
        this.name = name;
        this.last_Name = last_Name;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_Name() {
        return last_Name;
    }

    public void setLast_Name(String last_Name) {
        this.last_Name = last_Name;
    }

    public Byte getAge() {
        return age;
    }

    public void setAge(Byte age) {
        this.age = age;
    }

}