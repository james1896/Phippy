package com.tiffany.phippy.food;

/**
 * Created by moses on 25/07/2017.
 */

public class FoodModel {

    public int store_id;
    public  int store_type;
    public String name;
    public  String img_url;
    public  String phone_number;
    public String wechat;
    public String deliver_time;
    public  String qisong_condition;
    public  String adress;
    public String rank;

    @Override
    public String toString() {
        return "FoodModel{" +
                "store_id=" + store_id +
                ", store_type=" + store_type +
                ", name='" + name + '\'' +
                ", img_url='" + img_url + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", wechat='" + wechat + '\'' +
                ", deliver_time='" + deliver_time + '\'' +
                ", qisong_condition='" + qisong_condition + '\'' +
                ", adress='" + adress + '\'' +
                ", rank='" + rank + '\'' +
                '}';
    }

    public int getStore_id() {
        return store_id;
    }

    public void setStore_id(int store_id) {
        this.store_id = store_id;
    }

    public int getStore_type() {
        return store_type;
    }

    public void setStore_type(int store_type) {
        this.store_type = store_type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public String getDeliver_time() {
        return deliver_time;
    }

    public void setDeliver_time(String deliver_time) {
        this.deliver_time = deliver_time;
    }

    public String getQisong_condition() {
        return qisong_condition;
    }

    public void setQisong_condition(String qisong_condition) {
        this.qisong_condition = qisong_condition;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }
}
