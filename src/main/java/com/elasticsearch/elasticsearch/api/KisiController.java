package com.elasticsearch.elasticsearch.api;


import com.elasticsearch.elasticsearch.entity.Kisi;
import com.elasticsearch.elasticsearch.kisiRepository.KisiRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("kisi")
public class KisiController {

    private final KisiRepository kisiRepository;

    @PostConstruct
    public void init(){
        Kisi kisi=new Kisi();
        kisi.setAd("kadir");
        kisi.setSoyad("oncel");
        kisi.setAdres("bursa");
        kisi.setDogumTarihi(new Date());
        kisi.setId("1");
        kisiRepository.save(kisi);
    }

    @GetMapping("/{search}")
    public ResponseEntity<List<Kisi>> getKisi(@PathVariable String search){
       List<Kisi> kisiler= kisiRepository.getByCustomQuery(search);
       return ResponseEntity.ok(kisiler);
    }
}
