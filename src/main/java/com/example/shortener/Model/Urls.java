package com.example.shortener.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Entity
@Table(name = "test_db")
public class Urls {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    @Column(name = "short_url")
    private String shortUrl;

    @Getter
    @Setter
    @Column(name = "long_url")
    private String longUrl;

}
