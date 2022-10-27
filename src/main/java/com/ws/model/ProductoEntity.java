package com.ws.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.json.bind.annotation.JsonbPropertyOrder;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductoEntity {
    private Long id;
    private String nombre;
    private Integer precio;
}
