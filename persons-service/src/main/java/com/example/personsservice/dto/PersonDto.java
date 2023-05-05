package com.example.personsservice.dto;

import java.util.List;

public record PersonDto(String userName, List<String> notes) {
}
