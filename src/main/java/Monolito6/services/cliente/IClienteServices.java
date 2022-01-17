package Monolito6.services.cliente;

import Monolito6.models.DTOs.ClienteDTO;

import java.util.List;

public interface IClienteServices {
    List<ClienteDTO> obtenerClientes();

    ClienteDTO obtenerPorId(Integer id);

    List<ClienteDTO> obtenerPorEdadMayorA(Integer edad);

    ClienteDTO obtenerPorDocumentoYTipo(String documento, Integer tipo);

    ClienteDTO guardarCliente(ClienteDTO cliente);

    void eliminarCliente(Integer id);

    ClienteDTO validarDocumento(String documento, Integer tipo);
}
