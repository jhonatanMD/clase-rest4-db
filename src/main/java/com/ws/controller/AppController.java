package com.ws.controller;

import com.ws.model.ClienteEntity;
import com.ws.model.dto.ClienteDto;
import com.ws.service.IClienteService;
import com.ws.service.IProductoService;
import lombok.RequiredArgsConstructor;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;

@Path("/v1")
public class AppController {

    @Inject
    private IClienteService clienteService;
    @Inject
    private IProductoService productoService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<ClienteDto> findAll() throws SQLException {
        return clienteService.findAll();
    }


    @GET()
    @Path("/productos")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response findAllProducts() throws SQLException {
        return Response.ok().entity(productoService.findAll())
                .build();
    }


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ClienteEntity save(ClienteEntity cliente) throws SQLException {
        return clienteService.save(cliente);
    }
}