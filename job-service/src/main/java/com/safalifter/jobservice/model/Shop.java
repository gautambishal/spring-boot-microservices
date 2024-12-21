package com.safalifter.jobservice.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.List;

@Entity(name = "shop")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Shop extends BaseEntity{

    @Column(name = "shop_name", nullable = false)
    private String shopName;

    @Column(name = "location", nullable = false)
    private String location;

    @Column(name = "contact_details", nullable = false)
    private String contactDetails;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "shop_configuration_id")
    private List<MenuItem> menuItems;

    @Column(name = "number_of_queues", nullable = false)
    private int numberOfQueues;

    @Column(name = "max_queue_size", nullable = false)
    private int maxQueueSize;

    @Column(name = "opening_time", nullable = false)
    private LocalTime openingTime;

    @Column(name = "closing_time", nullable = false)
    private LocalTime closingTime;
     //todo add geometry location here and changelog as well
    // @Column(name = "location", columnDefinition = "geometry(Point,4326)", nullable = false)
    // private Point location;

}
