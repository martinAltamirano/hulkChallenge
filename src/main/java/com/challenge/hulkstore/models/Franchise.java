package com.challenge.hulkstore.models;

import javax.persistence.*;

@Entity
@Table(name = "franchises")
public class Franchise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String description;

    public Franchise() {
    }

    public Franchise(long id, String description) {
        this.id = id;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Franchise{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
