package com.safalifter.jobservice.service.impl;



import com.safalifter.jobservice.model.MenuItem;
import com.safalifter.jobservice.repository.MenuItemRepository;
import com.safalifter.jobservice.service.MenuItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MenuItemServiceImpl implements MenuItemService {

    private final MenuItemRepository menuItemRepository;

    public List<MenuItem> getAllMenuItems() {
        return this.menuItemRepository.findAll();
    }

    public MenuItem getMenuItemById(Long id) {
        return this.menuItemRepository.findById(id).orElseThrow(() -> new RuntimeException("Menu item not found with ID: " + id));
    }

    public MenuItem createMenuItem(MenuItem menuItem) {
        return this.menuItemRepository.save(menuItem);
    }

    public MenuItem updateMenuItem(Long id, MenuItem updatedMenuItem) {
        MenuItem existingMenuItem = getMenuItemById(id);
        existingMenuItem.setItemName(updatedMenuItem.getItemName());
        existingMenuItem.setPrice(updatedMenuItem.getPrice());
        return this.menuItemRepository.save(existingMenuItem);
    }

    public void deleteMenuItem(Long id) {
        this.menuItemRepository.deleteById(id);
    }
}
