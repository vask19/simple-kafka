package com.example.micro1.mq;

public class TacoOrder {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TacoOrder{" +
                "name='" + name + '\'' +
                '}';
    }
}
