package com.ws.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.json.bind.annotation.JsonbPropertyOrder;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonbPropertyOrder({"id","nombre","precio"})
public class ProductoDto {
    private Long id;
    private String nombre;
    private Integer precio;
}
