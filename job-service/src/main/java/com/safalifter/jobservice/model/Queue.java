package com.safalifter.jobservice.model;


import lombok.*;
import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Queue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "shop_id", nullable = false)
    private Shop shop;

    @OneToMany(mappedBy = "queue", cascade = CascadeType.ALL)
    private List<Customer> customers;  // Customers in the queue

    @Column(name = "queue_size")
    private int queueSize;  // Size of the queue

    @Column(name = "served_count")
    private int servedCount;  // Number of customers served from the queue
}

