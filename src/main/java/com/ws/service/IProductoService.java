package com.ws.service;

import com.ws.model.dto.ProductoDto;

import java.sql.SQLException;
import java.util.List;

public interface IProductoService {

    List<ProductoDto> findAll() throws SQLException;
}
