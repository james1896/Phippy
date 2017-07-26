package com.tiffany.phippy.food.detail;

/**
 * Created by moses on 25/07/2017.
 */

public class FoodDetailModel {
    public int goods_id;
    public int store_id;
    public String name;
    public String rank;
    public String img_url;
    public String price;
    public String publish_time;
    public String publisher;
    public String remark;
    public String describe;

    @Override
    public String toString() {
        return "FoodDetailModel{" +
                "goods_id=" + goods_id +
                ", store_id=" + store_id +
                ", name='" + name + '\'' +
                ", rank='" + rank + '\'' +
                ", img_url='" + img_url + '\'' +
                ", price='" + price + '\'' +
                ", publish_time='" + publish_time + '\'' +
                ", publisher='" + publisher + '\'' +
                ", remark='" + remark + '\'' +
                ", describe='" + describe + '\'' +
                '}';
    }

    public int getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(int goods_id) {
        this.goods_id = goods_id;
    }

    public int getStore_id() {
        return store_id;
    }

    public void setStore_id(int store_id) {
        this.store_id = store_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPublish_time() {
        return publish_time;
    }

    public void setPublish_time(String publish_time) {
        this.publish_time = publish_time;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}
