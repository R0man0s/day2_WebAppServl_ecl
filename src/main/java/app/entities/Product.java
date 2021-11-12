package app.entities;

import app.enums.Products_status;

import java.util.Objects;

public class Product {
    private int id;
    private String name;
    private int price;
    private Products_status status;
    private String created;

    public Product() {

    }

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public Product(int id, String name, int price, Products_status status, String created) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.status = status;
        this.created = created;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Products_status getStatus() {
        return status;
    }

    public void setStatus(Products_status status) {
        this.status = status;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", status='" + status + '\'' +
                ", created='" + created + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id && price == product.price && name.equals(product.name) && Objects.equals(created, product.created);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, created);
    }
}
