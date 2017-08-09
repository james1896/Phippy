package com.tiffany.phippy.food.detail;

import java.io.Serializable;

/**
 * Created by moses on 26/07/2017.
 */

// GridItem.java


public class GridItem implements Serializable {
    private String image;
    private String title;
    private Boolean isCheck;
    private float price;
    private String food_id;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    private int count;

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getFood_id() {
        return food_id;
    }

    public void setFood_id(String food_id) {
        this.food_id = food_id;
    }

    public Boolean getCheck() {
        return isCheck;
    }

    public void setCheck(Boolean check) {
        isCheck = check;
    }

    public GridItem() {
        super();
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "GridItem{" +
                "image='" + image + '\'' +
                ", title='" + title + '\'' +
                ", isCheck=" + isCheck +
                ", price=" + price +
                ", food_id='" + food_id + '\'' +
                '}';
    }
}

