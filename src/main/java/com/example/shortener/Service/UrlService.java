package com.example.shortener.Service;

import com.example.shortener.Model.Urls;

import java.util.List;

public interface UrlService {

    public boolean create(Urls urls);

    public List<Urls> readAll();

    public Urls read(long id);

    public boolean delete(long id);



}
