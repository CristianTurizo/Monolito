package Monolito6.services.cliente;

import Monolito6.exceptionsHandling.exceptions.RegisterNotFoundException;
import Monolito6.mappers.IMapper;
import Monolito6.models.DTOs.ClienteDTO;
import Monolito6.models.entities.ClienteEntidad;
import Monolito6.repositories.IClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements IClienteServices {

    private final IMapper mapper;
    private final IClienteRepository clienteRepository;

    @Override
    public List<ClienteDTO> obtenerClientes() {
        var clienteDtos = this.mapper.toClientesDto(
                (ArrayList<ClienteEntidad>) this.clienteRepository.findAll());

        if (clienteDtos.isEmpty()) {
            throw new RegisterNotFoundException();
        } else {
            return clienteDtos;
        }
    }

    @Override
    @Transactional(readOnly = true)
    public ClienteDTO obtenerPorId(Integer id) {
        return this.mapper.toClienteDto(
                this.clienteRepository.findById(id).orElseThrow(
                        RegisterNotFoundException::new));
    }

    @Override
    @Transactional(readOnly = true)
    public List<ClienteDTO> obtenerPorEdadMayorA(Integer edad) {
        var clienteDtos = this.mapper.toClientesDto(
                this.clienteRepository.findByEdadGreaterThanEqual(edad));

        if (clienteDtos.isEmpty()) {
            throw new RegisterNotFoundException();
        } else {
            return clienteDtos;
        }
    }

    @Override
    @Transactional(readOnly = true)
    public ClienteDTO obtenerPorDocumentoYTipo(String documento, Integer tipo) {
        return this.mapper.toClienteDto(
                this.clienteRepository.findByDocumentoAndTipoDocumento_idTipoDocumento(documento, tipo)
                        .orElseThrow(RegisterNotFoundException::new));
    }

    @Override
    @Transactional()
    public ClienteDTO guardarCliente(ClienteDTO cliente) {
        return this.mapper.toClienteDto(
                this.clienteRepository.save(
                        this.mapper.toClienteEntidad(cliente)));
    }

    @Override
    @Transactional()
    public void eliminarCliente(Integer id) {
        try {
            this.clienteRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new RegisterNotFoundException();
        }
    }

    @Override
    @Transactional(readOnly = true)
    public ClienteDTO validarDocumento(String documento, Integer tipo) {
        return this.mapper.toClienteDto(
                this.clienteRepository.findByDocumentoAndTipoDocumento_idTipoDocumento(documento, tipo)
                        .orElse(null));
    }

}
