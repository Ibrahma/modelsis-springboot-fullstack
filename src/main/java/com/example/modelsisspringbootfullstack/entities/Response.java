package com.example.modelsisspringbootfullstack.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Response {
    private Object data;
    private String description;
    private Integer statut;
}