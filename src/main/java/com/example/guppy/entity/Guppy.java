package com.example.guppy.entity;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "guppy")
@Data
public class Guppy implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String image;
    private float price;
    private float sale;
    private boolean status;
    private String _describe;



    public Guppy() {};
    public Guppy(int id, String name, String image, float price, float sale, List<String> images, String describe, boolean status, String _describe) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.price = price;
        this.sale = sale;
        this.status = status;
        this._describe = _describe;
    }
    public Guppy(String name, String image, float price, float sale, List<String> images, String describe, boolean status, String _describe) {
        this.name = name;
        this.image = image;
        this.price = price;
        this.sale = sale;
        this.status = status;
        this._describe = _describe;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setSale(float sale) {
        this.sale = sale;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public float getPrice() {
        return price;
    }

    public float getSale() {
        return sale;
    }

    public boolean getStatus() {
        return status;
    }

    public String get_describe() {
        return _describe;
    }

    public void set_describe(String _describe) {
        this._describe = _describe;
    }
}
