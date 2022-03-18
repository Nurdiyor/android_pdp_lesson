package uz.micro.star.lesson_13.model;

public class ImageData extends BaseData  {
    private String title;
    private int imgUrl;

    public ImageData(String title, int imgUrl) {
        this.title = title;
        this.imgUrl = imgUrl;
    }

    public String getTitle() {
        return title;
    }

    public int getImgUrl() {
        return imgUrl;
    }
}
