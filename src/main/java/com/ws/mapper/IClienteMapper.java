package com.ws.mapper;

import com.ws.model.ClienteEntity;
import com.ws.model.dto.ClienteDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface IClienteMapper {

    ClienteEntity toEntity(ClienteDto clienteDto);
    ClienteDto toDto(ClienteEntity clienteEntity);

}
