package com.sdpd;

public class Data {

    private String description;
    private String title;
    private int image;

    public Data(String description1, String title1, int image1)
    {
        this.description = description1;
        this.title = title1;
        this.image = image1;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
