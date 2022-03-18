package uz.micro.star.lesson_13.model;

public class TextData extends BaseData {
    private final String title;
    private final String content;

    public TextData(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

}
