package com.ws.service.impl;

import com.ws.mapper.IClienteMapper;
import com.ws.model.ClienteEntity;
import com.ws.model.dto.ClienteDto;
import com.ws.repository.IBDRepository;
import com.ws.service.IClienteService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class ClienteService implements IClienteService {

    @Inject
    private IBDRepository repository;

    @Inject
    private IClienteMapper mapper;

    @Override
    public List<ClienteDto> findAll() throws SQLException {
        return repository.findAll()
                .stream().map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ClienteEntity save(ClienteEntity cliente) throws SQLException {
        return repository.save(cliente);
    }
}
