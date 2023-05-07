package com.example.personsservice.domain;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Note {

    private String userName;
    private String body;
}

