package com.example.shortener.Utils;

import com.example.shortener.Model.Urls;
import org.springframework.stereotype.Component;

@Component
public class UrlUtils {
    Urls urls = new Urls();
    public String convertToShortUrl(String longUrl) {
        if (longUrl.substring(0, 7).equals("http://")) {
    return longUrl.substring(6);
} else if (longUrl.substring(0, 8).equals("https://")) {
    return longUrl.substring(7);
}

        // Take long url
        // Parse long url
        // Generate short url
        return (longUrl.substring(0,1) + (int) Math.abs((Math.random() * 10) - 9) + longUrl.substring(1,2) + (int) Math.abs((Math.random() * 10) - 9));
    }
}
