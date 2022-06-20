package com.tkachuk.bicycle.entity.DTO;

import lombok.*;

import javax.persistence.Column;

@AllArgsConstructor
@Getter
@Setter
public class BicycleDTO {
    private Long id;
    private String brand;
    private String model;
    private Integer year;
    private String imageUrl;
    private Integer price;
    private Double mark;
}
