package com.example.bookingsystem.model;

public class Sitzplatz {
    private Integer id;
    private Double price;


    public Sitzplatz() {
    }

    public Sitzplatz(Integer id, Double price) {
        this.id = id;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
