package com.pdp.servicepdp.rest;

import com.pdp.servicepdp.model.Picture;
import com.pdp.servicepdp.service.PictureService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/picture")
public class PictureRest {

    private final PictureService pictureService;

    public PictureRest(PictureService pictureService) {
        this.pictureService = pictureService;
    }

    @PostMapping
    public ResponseEntity<Picture> createClient(@RequestBody Picture picture) {
        return ResponseEntity.status(HttpStatus.CREATED).body(pictureService.create(picture));
    }
}
