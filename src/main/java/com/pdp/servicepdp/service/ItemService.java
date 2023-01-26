package com.pdp.servicepdp.service;

import com.pdp.servicepdp.exception.GlobalException;
import com.pdp.servicepdp.model.Item;
import com.pdp.servicepdp.model.ItemPictures;
import com.pdp.servicepdp.model.Picture;
import com.pdp.servicepdp.model.dto.ItemDTO;
import com.pdp.servicepdp.model.dto.ItemResponseDTO;
import com.pdp.servicepdp.repository.ItemRepository;
import com.pdp.servicepdp.repository.ItemPicturesRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ItemService {
    private final ItemRepository itemRepository;
    private final ItemPicturesRepository itemPicturesRepository;
    private final PictureService pictureService;
    private final CategoryService categoryService;

    public ItemService(ItemRepository itemRepository, ItemPicturesRepository itemPicturesRepository, PictureService pictureService, CategoryService categoryService) {
        this.itemRepository = itemRepository;
        this.itemPicturesRepository = itemPicturesRepository;
        this.pictureService = pictureService;
        this.categoryService = categoryService;
    }

    public ItemResponseDTO create(ItemDTO itemDTO) {
        var category = categoryService.findById(itemDTO.getCategoryId());
        var pictures = itemDTO.getPicturesId().stream().map(pictureService::findById).toList();

        var item = new Item(itemDTO, category);
        itemRepository.save(item);

        item.setPictures(createItemPictures(pictures, item));

        return new ItemResponseDTO(item);
    }

    private Set<ItemPictures> createItemPictures(List<Picture> pictures, Item item) {
        return pictures.stream().map(picture -> {
            var itemPicture = new ItemPictures(0, item, picture);
            itemPicturesRepository.save(itemPicture);
            return itemPicture;
        }).collect(Collectors.toSet());
    }

    public Item findById(Integer id) {
        var item = itemRepository.findById(id);
        if (item.isEmpty())
            throw new GlobalException("Item not found", HttpStatus.NOT_FOUND);
        return item.get();
    }

    public void updateStatus(Integer id) {
        var item = this.findById(id);
        item.setActive(!item.getActive());
        itemRepository.save(item);
    }
}
