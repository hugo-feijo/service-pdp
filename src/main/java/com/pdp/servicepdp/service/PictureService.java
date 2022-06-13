package com.pdp.servicepdp.service;

import com.pdp.servicepdp.exception.GlobalException;
import com.pdp.servicepdp.model.Picture;
import com.pdp.servicepdp.repository.PictureDAO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class PictureService {
    private final PictureDAO pictureDAO;

    public PictureService(PictureDAO pictureDAO) {
        this.pictureDAO = pictureDAO;
    }

    public Picture create(Picture picture) {
        pictureDAO.save(picture);
        return picture;
    }

    public Picture findById(Integer id) {
        var picture = pictureDAO.findById(id);
        if (picture.isEmpty())
            throw new GlobalException("Picture not found", HttpStatus.NOT_FOUND);
        return picture.get();
    }
}
