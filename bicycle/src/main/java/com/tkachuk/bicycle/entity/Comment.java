package com.tkachuk.bicycle.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "comments")
public class Comment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "comment_id",nullable = false, updatable = false)
    private Long id;
    @Column
    private Long userId;
    @Column
    private Long bicycleId;
    @Column
    private String text;
    @Column
    private Integer mark;
}
