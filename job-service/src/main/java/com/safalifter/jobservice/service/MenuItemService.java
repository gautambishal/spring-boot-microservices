package com.safalifter.jobservice.service;

import com.safalifter.jobservice.model.MenuItem;

import java.util.List;

public interface MenuItemService {
    List<MenuItem> getAllMenuItems();
    MenuItem getMenuItemById(Long id);
    MenuItem createMenuItem(MenuItem menuItem);
    MenuItem updateMenuItem(Long id, MenuItem updatedMenuItem);
    void deleteMenuItem(Long id);
}
