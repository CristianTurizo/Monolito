package Monolito6.services.facade;

import Monolito6.models.DTOs.ClienteDTO;
import Monolito6.validator.ClienteValidator;
import Monolito6.services.cliente.IClienteServices;
import Monolito6.services.imagen.IImagenServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServicesFacadeImpl implements IServicesFacade {

    private final IClienteServices clienteServices;
    private final IImagenServices imagenServices;
    private final ClienteValidator validator;

    @Override
    public List<ClienteDTO> obtener() {
        var listaClientes = this.clienteServices.obtenerClientes();
        listaClientes.forEach(cliente ->
                cliente.setImagenMongo(
                        this.imagenServices.obtenerPorId(
                                cliente.getIdImagen())));
        return listaClientes;
    }

    @Override
    public ClienteDTO obtenerPorId(Integer id) {
        var cliente = this.clienteServices.obtenerPorId(id);
        cliente.setImagenMongo(
                this.imagenServices.obtenerPorId(
                        cliente.getIdImagen()));
        return cliente;
    }

    @Override
    public List<ClienteDTO> obtenerPorEdad(Integer edad) {
        var listaClientes = this.clienteServices.obtenerPorEdadMayorA(edad);
        listaClientes.forEach(cliente ->
                cliente.setImagenMongo(
                        this.imagenServices.obtenerPorId(
                                cliente.getIdImagen())));
        return listaClientes;
    }

    @Override
    public ClienteDTO obtenerPorDocumentoYTipo(String documento, Integer tipo) {
        var cliente = this.clienteServices.obtenerPorDocumentoYTipo(documento, tipo);
        cliente.setImagenMongo(
                this.imagenServices.obtenerPorId(
                        cliente.getIdImagen()));
        return cliente;
    }

    @Override
    public ClienteDTO agregar(ClienteDTO cliente) {
        validator.validarEdad(cliente);
        validator.validarDocumento(cliente);

        // Guardado de objetos
        var imagen = this.imagenServices.guardarImagen(cliente.getImagenMongo());
        cliente.setIdImagen(imagen.getId());
        cliente.setImagenMongo(imagen);

        return this.clienteServices.guardarCliente(cliente);
    }

    @Override
    public ClienteDTO modificar(ClienteDTO cliente) {
        validator.validarEdad(cliente);
        validator.validarDocumento(cliente);

        // Modificar la imagen correcta
        var imagenAntiguaCliente = this.obtenerPorId(
                cliente.getIdClientes()).getImagenMongo();
        cliente.setIdImagen(imagenAntiguaCliente.getId());
        cliente.getImagenMongo().setId(imagenAntiguaCliente.getId());

        // Guardar Objetos
        var imagen = this.imagenServices.guardarImagen(cliente.getImagenMongo());
        cliente.setImagenMongo(imagen);

        return this.clienteServices.guardarCliente(cliente);
    }

    @Override
    public void eliminar(Integer id) {
        var cliente = this.clienteServices.obtenerPorId(id);
        this.imagenServices.eliminarImagen(cliente.getIdImagen());
        this.clienteServices.eliminarCliente(id);
    }

}
