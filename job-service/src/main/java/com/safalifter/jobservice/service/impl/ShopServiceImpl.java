package com.safalifter.jobservice.service.impl;


import com.safalifter.jobservice.model.Shop;
import com.safalifter.jobservice.repository.ShopRepository;
import com.safalifter.jobservice.service.ShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ShopServiceImpl implements ShopService {

    private final ShopRepository shopRepository;

    public List<Shop> getAllShops() {
        return this.shopRepository.findAll();
    }

    public Shop getShopById(String id) {
        return this.shopRepository.findById(id).orElseThrow(() -> new RuntimeException("Shop not found with ID: " + id));
    }

    public Shop createShop(Shop shop) {
        return this.shopRepository.save(shop);
    }

    public Shop updateShop(String id, Shop updatedShop) {
        Shop existingShop = getShopById(id);
        existingShop.setShopName(updatedShop.getShopName());
        existingShop.setLocation(updatedShop.getLocation());
        existingShop.setContactDetails(updatedShop.getContactDetails());
        existingShop.setMenuItems(updatedShop.getMenuItems());
        existingShop.setNumberOfQueues(updatedShop.getNumberOfQueues());
        existingShop.setMaxQueueSize(updatedShop.getMaxQueueSize());
        existingShop.setOpeningTime(updatedShop.getOpeningTime());
        existingShop.setClosingTime(updatedShop.getClosingTime());
        return this.shopRepository.save(existingShop);
    }

    public void deleteShop(String id) {
        this.shopRepository.deleteById(id);
    }
}
