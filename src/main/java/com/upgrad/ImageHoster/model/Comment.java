package com.upgrad.ImageHoster.model;


import org.springframework.beans.factory.annotation.Autowired;


import javax.persistence.*;

import java.io.Serializable;

import java.time.LocalDate;


@Entity

@Table(name = "comment")

public class Comment implements Serializable {

    @Id
    @Column(columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(columnDefinition = "TEXT")
    private String description;


    @Column
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Image_id")

    private Image image;

    public Comment(){}

    public Comment(String description) { this.description = description; }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public Image getImage() { return image; }


    public void setImage(Image image) { this.image = image; }

}

