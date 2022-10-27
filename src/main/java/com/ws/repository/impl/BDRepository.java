package com.ws.repository.impl;

import com.ws.model.ClienteEntity;
import com.ws.repository.IBDRepository;
import io.agroal.api.AgroalDataSource;
import io.quarkus.agroal.DataSource;
import lombok.RequiredArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class BDRepository implements IBDRepository {

    @Inject
    @DataSource("prueba")
    private AgroalDataSource cnn;

    @Override
    public List<ClienteEntity> findAll() {
        return null;
    }

    @Override
    public ClienteEntity save() {
        return null;
    }
}
