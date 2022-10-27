package com.ws.service.impl;

import com.ws.mapper.IProductosMapper;
import com.ws.model.dto.ProductoDto;
import com.ws.repository.IBDRepository;
import com.ws.service.IProductoService;
import lombok.RequiredArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
@RequiredArgsConstructor
public class ProductoService implements IProductoService {

    private final IBDRepository repository;
    private final IProductosMapper mapper;

    @Override
    public List<ProductoDto> findAll() throws SQLException {
        return repository.findAllProducts()
                .stream().map(mapper::toDto)
                .collect(Collectors.toList());
    }
}
