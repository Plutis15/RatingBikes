package com.tkachuk.bicycle.entity.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentDTO {
    private String imageURL;
    private String text;
    private String firstName;
    private String lastName;
    private Integer mark;

    public CommentDTO(String imageURL, String text, String firstName, String lastName, Integer mark) {
        this.imageURL = imageURL;
        this.text = text;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mark = mark;
    }
}
