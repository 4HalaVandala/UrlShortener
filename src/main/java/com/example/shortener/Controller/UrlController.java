package com.example.shortener.Controller;

import com.example.shortener.Model.Urls;
import com.example.shortener.Repository.UrlRepository;
import com.example.shortener.Service.UrlService;
import com.example.shortener.Utils.UrlUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class UrlController {

    @Autowired
    private final UrlRepository urlRepository;
    @Autowired
private final UrlService urlService;
    @Autowired

private final UrlUtils urlUtils;
    @Autowired
 private final HttpServletResponse response;



    public UrlController(UrlService urlService, UrlUtils urlUtils, UrlRepository urlRepository,HttpServletResponse response) {
    this.urlService = urlService;
    this.urlUtils = urlUtils;
    this.urlRepository = urlRepository;
    this.response = response;

}
    @GetMapping("/{shortUrl}")
    public ResponseEntity<?> handleRedirect(@PathVariable String shortUrl) throws IOException {
        List<Urls> redirectUrl = urlRepository.findByShortUrl(shortUrl);

        String url =  redirectUrl.get(0).getLongUrl();
        System.out.println(url);
        response.sendRedirect(url);

        return new ResponseEntity<>(HttpStatus.MOVED_PERMANENTLY);
    }

    @PostMapping(value = "/urls")
    public ResponseEntity<Urls> create(@RequestBody Urls urls) {
        final  String longTransform = urlUtils.convertToShortUrl(String.valueOf(urls));

        urls.setShortUrl(longTransform);
        urlService.create(urls);

        return new ResponseEntity<Urls>(urls, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/urls/{id}")
    public ResponseEntity<Urls> delete(@PathVariable(name = "id") long id) {
    final boolean deleted = urlService.delete(id);

        return deleted
                ? new ResponseEntity<Urls>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping(value = "/urls/{id}")
    public ResponseEntity<Urls> read(@PathVariable(name = "id") long id) {
        final Urls urls = urlService.read(id);

        return urls != null
                ? new ResponseEntity<>(urls, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
 }
    @GetMapping(value = "/urls")
    public  List<Urls> readAll() {
        return urlService.readAll();
    }

}

