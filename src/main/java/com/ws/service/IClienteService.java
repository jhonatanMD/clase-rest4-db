package com.ws.service;

import com.ws.model.ClienteEntity;
import com.ws.model.dto.ClienteDto;

import java.sql.SQLException;
import java.util.List;

public interface IClienteService {

    List<ClienteDto> findAll() throws SQLException;
    ClienteEntity save(ClienteEntity cliente) throws SQLException;
}
