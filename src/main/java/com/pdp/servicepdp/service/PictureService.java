package com.pdp.servicepdp.service;

import com.pdp.servicepdp.exception.GlobalException;
import com.pdp.servicepdp.model.Picture;
import com.pdp.servicepdp.repository.PictureRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class PictureService {
    private final PictureRepository pictureRepository;

    public PictureService(PictureRepository pictureRepository) {
        this.pictureRepository = pictureRepository;
    }

    public Picture create(Picture picture) {
        pictureRepository.save(picture);
        return picture;
    }

    public Picture findById(Integer id) {
        var picture = pictureRepository.findById(id);
        if (picture.isEmpty())
            throw new GlobalException("Picture not found", HttpStatus.NOT_FOUND);
        return picture.get();
    }
}
