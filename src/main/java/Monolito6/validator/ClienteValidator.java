package Monolito6.validator;


import Monolito6.exceptionsHandling.exceptions.*;
import Monolito6.models.DTOs.ClienteDTO;
import Monolito6.services.cliente.IClienteServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ClienteValidator {

    private final IClienteServices clienteServices;

    // Validacion para que la edad corresponda con el dtipo de documento
    public void validarEdad(ClienteDTO cliente) {
        if (((cliente.getEdad() >= 18) && (cliente.getTipoDocumento().getIdTipoDocumento() == 2))
                || ((cliente.getEdad() < 18) && (cliente.getTipoDocumento().getIdTipoDocumento() == 1))) {
            throw new AgeIncompatibilityExeption();
        }
    }

    // Validacion de docuemnto existente
    public void validarDocumento(ClienteDTO cliente) {
        ClienteDTO clienteConIgualDocumento = this.clienteServices.validarDocumento(
                cliente.getDocumento(), cliente.getTipoDocumento().getIdTipoDocumento());

        if ((clienteConIgualDocumento != null)) {
            if ((clienteConIgualDocumento.getIdClientes() != cliente.getIdClientes())) {
                throw new DocumentAlreadyExistException();
            }
        }
    }
}
