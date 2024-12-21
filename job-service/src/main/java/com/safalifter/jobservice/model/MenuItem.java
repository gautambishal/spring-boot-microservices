package com.safalifter.jobservice.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "menu_items")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MenuItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "item_name", nullable = false)
    private String itemName;

    @Column(name = "price", nullable = false)
    private Double price;

}