package com.safalifter.jobservice.shop;


import com.safalifter.jobservice.model.Shop;
import com.safalifter.jobservice.repository.ShopRepository;
import com.safalifter.jobservice.service.ShopService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalTime;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class ShopServiceTests {

    @InjectMocks
    private ShopService shopService;

    @Mock
    private ShopRepository shopRepository;

    private Shop shop;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        shop = Shop.builder()
                .shopName("Calico Coffee")
                .location("123 Coffee St.")
                .contactDetails("123-456-7890")
                .numberOfQueues(2)
                .maxQueueSize(10)
                .openingTime(LocalTime.of(8, 0))
                .closingTime(LocalTime.of(20, 0))
                .build();
    }

    @Test
    void shouldSaveShopConfiguration() {
        when(shopRepository.save(shop)).thenReturn(shop);

        Shop savedShop = shopService.createShop(shop);

        assertThat(savedShop).isNotNull();
        assertThat(savedShop.getShopName()).isEqualTo("Calico Coffee");
        verify(shopRepository, times(1)).save(shop);
    }

    @Test
    void shouldFetchShopById() {
        when(shopRepository.findById(anyString())).thenReturn(Optional.of(shop));

        Shop foundShop = shopService.getShopById("1");

        assertThat(foundShop).isNotNull();
        assertThat(foundShop.getShopName()).isEqualTo("Calico Coffee");
        verify(shopRepository, times(1)).findById("1");
    }
}

