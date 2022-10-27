package com.ws.repository;

import com.ws.model.ClienteEntity;

import java.sql.SQLException;
import java.util.List;

public interface IBDRepository {

    List<ClienteEntity> findAll() throws SQLException;
    ClienteEntity save();

}
