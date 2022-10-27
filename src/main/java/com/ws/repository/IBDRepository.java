package com.ws.repository;

import com.ws.model.ClienteEntity;
import com.ws.model.ProductoEntity;
import com.ws.model.dto.ClienteDto;

import java.sql.SQLException;
import java.util.List;

public interface IBDRepository {

    List<ClienteEntity> findAll() throws SQLException;
    List<ProductoEntity> findAllProducts() throws SQLException;
    ClienteEntity save(ClienteEntity cliente) throws SQLException;

}
