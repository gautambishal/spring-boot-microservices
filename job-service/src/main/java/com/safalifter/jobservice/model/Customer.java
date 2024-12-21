package com.safalifter.jobservice.model;


import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "queue_id", nullable = false)
    private Queue queue;  // Queue this customer belongs to

    @Column(name = "served_count")
    private int servedCount;  // Number of times the customer has been served
}

