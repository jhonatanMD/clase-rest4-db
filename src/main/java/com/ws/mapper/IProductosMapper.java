package com.ws.mapper;

import com.ws.model.ProductoEntity;
import com.ws.model.dto.ProductoDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface IProductosMapper {

    ProductoEntity toEntity(ProductoDto productoDto);
    ProductoDto toDto(ProductoEntity productoEntity);

}
