package Monolito6.controllers;

import Monolito6.models.DTOs.ClienteDTO;
import Monolito6.services.facade.IServicesFacade;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/monolito")
@RequiredArgsConstructor
public class Controlador {

    private final IServicesFacade servicesFacade;

    @GetMapping()
    public List<ClienteDTO> obtener() {
        return this.servicesFacade.obtener();
    }

    @GetMapping(path = "/{id}")
    public ClienteDTO obtenerPorId(@PathVariable("id") int id) {
        return this.servicesFacade.obtenerPorId(id);
    }

    @GetMapping(path = "/findByEdadMayorA")
    public List<ClienteDTO> obtenerPorEdad(@RequestParam("edad") Integer edad) {
        return this.servicesFacade.obtenerPorEdad(edad);
    }

    @GetMapping(path = "/findByDocumentoYTipo")
    public ClienteDTO obtenerPorDocumentoYTipo(@RequestParam("documento") String documento, @RequestParam("tipo") Integer tipo) {
        return this.servicesFacade.obtenerPorDocumentoYTipo(documento, tipo);
    }

    @PostMapping()
    public ResponseEntity<ClienteDTO> guardar(@RequestBody @Valid ClienteDTO cliente) {
        var clienteDTO = this.servicesFacade.agregar(cliente);
        return new ResponseEntity<>(clienteDTO, HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<ClienteDTO> modificar(@RequestBody @Valid ClienteDTO cliente) {
        var clienteDTO = this.servicesFacade.modificar(cliente);
        return new ResponseEntity<>(clienteDTO, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity eliminar(@PathVariable("id") int id) {
        this.servicesFacade.eliminar(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
