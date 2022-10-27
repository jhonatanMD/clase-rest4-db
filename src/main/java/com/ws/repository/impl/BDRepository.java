package com.ws.repository.impl;

import com.ws.model.ClienteEntity;
import com.ws.repository.IBDRepository;
import io.agroal.api.AgroalDataSource;
import io.quarkus.agroal.DataSource;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class BDRepository implements IBDRepository {

    @Inject
    @DataSource("prueba")
    private AgroalDataSource dataSource;


    @Override
    public List<ClienteEntity> findAll() throws SQLException {

        List<ClienteEntity> clientes = new ArrayList<>();

        Connection cnn = dataSource.getConnection();
        Statement statement = cnn.createStatement();

        ResultSet rs = statement.executeQuery("SELECT * FROM cliente");

        while (rs.next()){
            clientes.add(ClienteEntity.builder()
                            .id(rs.getLong(1))
                            .nombre(rs.getString(2))
                            .apellido(rs.getString(3))
                            .edad(rs.getLong(4))
                    .build());
        }

        statement.close();
        cnn.close();

        return clientes;
    }

    @Override
    public ClienteEntity save() {
        return null;
    }
}
