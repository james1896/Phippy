package com.tiffany.phippy.tour;

/**
 * Created by moses on 25/07/2017.
 */

public class TourModel {

    public String store_id;
    public String title;
    public String content;
    public String time;
    public String img_url;
    public String rank;

    @Override
    public String toString() {
        return "TourModel{" +
                "store_id='" + store_id + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", time='" + time + '\'' +
                ", img_url='" + img_url + '\'' +
                ", rank='" + rank + '\'' +
                '}';
    }

    public String getStore_id() {
        return store_id;
    }

    public void setStore_id(String store_id) {
        this.store_id = store_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }
}
