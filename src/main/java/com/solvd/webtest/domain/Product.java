package com.solvd.webtest.domain;

import java.util.Objects;

public class Product {

    private String model;
    private double cost;
    private String information;

    public Product() {
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public double getCost() {
        return cost;
    }
    public void setCost(double cost) {
        this.cost = cost;
    }
    public String getInformation() {
        return information;
    }
    public void setInformation(String information) {
        this.information = information;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return Double.compare(product.getCost(), getCost()) == 0 &&
                getModel().equals(product.getModel()) &&
                getInformation().equals(product.getInformation());
    }
    @Override
    public int hashCode() {
        return Objects.hash(getModel(), getCost(), getInformation());
    }

    @Override
    public String toString() {
        return "Product{" +
                "model='" + model + '\'' +
                ", cost=" + cost +
                ", information='" + information + '\'' +
                '}';
    }
}
