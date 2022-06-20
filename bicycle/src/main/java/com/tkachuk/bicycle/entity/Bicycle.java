package com.tkachuk.bicycle.entity;

import com.tkachuk.bicycle.entity.DTO.BicycleDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "bicycles")
public class Bicycle implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "bicycle_id",nullable = false, updatable = false)
    private Long id;

    @Column(nullable = false)
    private String brand;
    @Column(nullable = false)
    private String model;
    @Column(nullable = false)
    private Integer year;
    @Column(length = 1000)
    private String imageUrl;
    @Column(nullable = false)
    private Integer price;
    @Column(precision = 5, scale = 4)
    private Double mark;
    @Column
    private Integer commentCount;
    @Column
    private Integer markCount;
}
