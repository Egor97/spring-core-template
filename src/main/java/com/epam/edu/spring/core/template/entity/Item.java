package com.epam.edu.spring.core.template.entity;

public class Item {

    private long id;
    private String name;
    private double price;
    private Color color;

    public Item(long id, String name, double price, Color color) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.color = color;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", color=" + color +
                '}';
    }
}
