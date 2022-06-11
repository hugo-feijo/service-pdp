package com.pdp.servicepdp.service;

import com.pdp.servicepdp.exception.GlobalException;
import com.pdp.servicepdp.model.Item;
import com.pdp.servicepdp.model.ItemPictures;
import com.pdp.servicepdp.model.Picture;
import com.pdp.servicepdp.model.dto.ItemDTO;
import com.pdp.servicepdp.model.dto.ItemResponseDTO;
import com.pdp.servicepdp.repository.ItemDAO;
import com.pdp.servicepdp.repository.ItemPicturesDAO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ItemService {
    private final ItemDAO itemDAO;
    private final ItemPicturesDAO itemPicturesDAO;
    private final PictureService pictureService;
    private final CategoryService categoryService;

    public ItemService(ItemDAO itemDAO, ItemPicturesDAO itemPicturesDAO, PictureService pictureService, CategoryService categoryService) {
        this.itemDAO = itemDAO;
        this.itemPicturesDAO = itemPicturesDAO;
        this.pictureService = pictureService;
        this.categoryService = categoryService;
    }

    public ItemResponseDTO create(ItemDTO itemDTO) {
        var category = categoryService.findById(itemDTO.getCategoryId());
        var pictures = itemDTO.getPicturesId().stream().map(pictureService::findById).toList();

        var item = new Item(itemDTO, category);
        itemDAO.create(item);

        item.setPictures(createItemPictures(pictures, item));

        return new ItemResponseDTO(item);
    }

    private Set<ItemPictures> createItemPictures(List<Picture> pictures, Item item) {
        return pictures.stream().map(picture -> {
            var itemPicture = new ItemPictures(0, item, picture);
            itemPicturesDAO.create(itemPicture);
            return itemPicture;
        }).collect(Collectors.toSet());
    }

    public Item findById(Integer id) {
        var item = itemDAO.read(Item.class, id);
        if (item == null)
            throw new GlobalException("Item not found", HttpStatus.NOT_FOUND);
        return item;
    }
}
