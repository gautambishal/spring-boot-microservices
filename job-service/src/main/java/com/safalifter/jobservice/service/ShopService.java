package com.safalifter.jobservice.service;

import com.safalifter.jobservice.model.Shop;

import java.util.List;

public interface ShopService {
    List<Shop> getAllShops();
    Shop getShopById(String id);
    Shop createShop(Shop shop);
    Shop updateShop(String id, Shop updatedShop);
    void deleteShop(String id);
}
