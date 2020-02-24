package com.hud.model;

import org.springframework.web.multipart.MultipartFile;

public class ProductVo {
    
    private int product_id;
    private String product_name;
    private int price;
    private String description;
    private String picture_url;
    private MultipartFile file1; //첨부파일은 MultipartFile타입으로 저장한다.
    
    
    public int getProduct_id() {
        return product_id;
    }
    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }
    public String getProduct_name() {
        return product_name;
    }
    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getPicture_url() {
        return picture_url;
    }
    public void setPrcture_url(String picture_url) {
        this.picture_url = picture_url;
    }
    public MultipartFile getFile1() {
        return file1;
    }
    public void setFile1(MultipartFile file1) {
        this.file1 = file1;
    }
    
   
}
