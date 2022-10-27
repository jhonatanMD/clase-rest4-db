package com.ws.repository.impl;

import com.ws.model.ClienteEntity;
import com.ws.model.ProductoEntity;
import com.ws.model.dto.ClienteDto;
import com.ws.repository.IBDRepository;
import io.agroal.api.AgroalDataSource;
import io.quarkus.agroal.DataSource;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class BDRepository implements IBDRepository {

    @Inject
    //@DataSource(value = "prueba2")
    AgroalDataSource dataSource;


    @Inject
    @DataSource(value = "bd2")
    AgroalDataSource dataSource2;

    Connection cnn;
    Statement statement;

    @Override
    public List<ClienteEntity> findAll() throws SQLException {

        conexion();

        List<ClienteEntity> clientes = new ArrayList<>();

        ResultSet rs = statement.executeQuery("SELECT * FROM clientes");

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
    public List<ProductoEntity> findAllProducts() throws SQLException {

        conexion2();

        List<ProductoEntity> productos = new ArrayList<>();

        ResultSet rs = statement.executeQuery("SELECT * FROM productos");

        while (rs.next()){
            productos.add(ProductoEntity.builder()
                    .id(rs.getLong(1))
                    .nombre(rs.getString(2))
                    .precio(rs.getInt(3))
                    .build());
        }

        statement.close();
        cnn.close();

        return productos;
    }

    @Override
    public ClienteEntity save(ClienteEntity cliente) throws SQLException {
        conexion();

        String sqlInsert = "INSERT INTO clientes (id,nombre,apellido,edad) values (?,?,?,?);";
        PreparedStatement preparedStatement = dataSource.getConnection().prepareStatement(sqlInsert);
        preparedStatement.setInt(1,cliente.getId().intValue());
        preparedStatement.setString(2,cliente.getNombre());
        preparedStatement.setString(3,cliente.getApellido());
        preparedStatement.setInt(4,cliente.getEdad().intValue());

        preparedStatement.execute();
        preparedStatement.close();
        cnn.close();
        return cliente;
    }

    private void conexion(){
        try {
            cnn = dataSource.getConnection();
            statement = cnn.createStatement();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }


    private void conexion2(){
        try {
            cnn = dataSource2.getConnection();
            statement = cnn.createStatement();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
