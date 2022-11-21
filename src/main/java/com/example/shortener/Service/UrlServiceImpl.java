package com.example.shortener.Service;

import com.example.shortener.Model.Urls;
import com.example.shortener.Repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UrlServiceImpl implements UrlService {

    @Autowired
    private final UrlRepository urlRepository;

    public UrlServiceImpl(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }
@Override
    public boolean create(Urls urls) {
   urlRepository.save(urls);
    return true;
}
@Override
    public List<Urls> readAll() {
    return urlRepository.findAll();
    }
@Override
    public Urls read(long id) {
   return urlRepository.getOne(id);
    }


@Override
    public boolean delete(long id) {
        if (urlRepository.existsById(id)) {
            urlRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
