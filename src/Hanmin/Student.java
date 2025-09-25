package Hanmin;

import java.time.LocalDate;

public class Student {
    private String name;
    private int age;
    private String part;
    private LocalDate birthday;

    public Student(String name, int age, String part, String birthday) {
        this.name = name;
        this.age = age;
        this.part = part;
        this.birthday = LocalDate.parse(birthday);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "이름: " + name + ", 나이: " + age + ", 파트: " + part + ", 생일: " + birthday;
    }
}
