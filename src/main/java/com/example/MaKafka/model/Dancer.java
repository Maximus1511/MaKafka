package com.example.MaKafka.model;


import lombok.ToString;

public class Dancer {
    private int id;
    private String name;
    private boolean fromIridan;

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

    public boolean isFromIridan() {
        return fromIridan;
    }

    public void setFromIridan(boolean fromIridan) {
        this.fromIridan = fromIridan;
    }

    @Override
    public String toString() {
        return "Dancer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", fromIridan=" + fromIridan +
                '}';
    }
}
