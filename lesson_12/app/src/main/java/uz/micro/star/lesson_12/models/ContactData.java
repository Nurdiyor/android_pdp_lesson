package uz.micro.star.lesson_12.models;

public class ContactData {
    private final String name;
    private final String number;
    private final int image;

    public ContactData(String name, String number, int image) {
        this.name = name;
        this.number = number;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public int getImage() {
        return image;
    }
}
