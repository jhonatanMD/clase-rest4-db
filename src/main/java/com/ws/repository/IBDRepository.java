package com.ws.repository;

import com.ws.model.ClienteEntity;

import java.util.List;

public interface IBDRepository {

    List<ClienteEntity> findAll();
    ClienteEntity save();

}
