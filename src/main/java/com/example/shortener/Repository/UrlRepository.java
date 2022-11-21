package com.example.shortener.Repository;

import com.example.shortener.Model.Urls;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;



@Repository
public interface UrlRepository extends JpaRepository<Urls, Long> {
    public List<Urls> findByShortUrl(String shortUrl);

}
