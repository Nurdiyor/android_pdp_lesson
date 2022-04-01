package uz.micro.star.lesson_17.models;

/**
 * Created by Microstar on 21.05.2019.
 */

public class Student {
    private int id;
    private String name;
    private String number;
    private int groupId;

    public Student(int id, String name, String number, int groupId) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.groupId = groupId;
    }

    public Student(String name, String number, int groupId) {
        this.name = name;
        this.number = number;
        this.groupId = groupId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }
}
