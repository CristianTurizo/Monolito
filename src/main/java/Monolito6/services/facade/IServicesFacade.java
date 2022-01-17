package Monolito6.services.facade;


import Monolito6.models.DTOs.ClienteDTO;

import java.util.List;

public interface IServicesFacade {

    List<ClienteDTO> obtener();

    ClienteDTO obtenerPorId(Integer id);

    List<ClienteDTO> obtenerPorEdad(Integer edad);

    ClienteDTO obtenerPorDocumentoYTipo(String documento, Integer tipo);

    ClienteDTO agregar(ClienteDTO cliente);

    ClienteDTO modificar(ClienteDTO cliente);

    void eliminar(Integer id);

}
