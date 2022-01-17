package Monolito6.services.facade;

import Monolito6.models.DTOs.*;
import Monolito6.services.cliente.IClienteServices;
import Monolito6.services.imagen.IImagenServices;
import Monolito6.validator.ClienteValidator;
import org.junit.jupiter.api.*;
import org.mockito.*;
import org.mockito.MockitoAnnotations;

import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ServicesFacadeImplTest {

    @Mock
    private IClienteServices clienteServices;

    @Mock
    private IImagenServices imagenServices;

    @Mock
    private ClienteValidator clienteValidator;

    @InjectMocks
    private ServicesFacadeImpl servicesFacade;

    private ClienteDTO cliente;
    private TipoDocumentoDTO tipo;
    private CiudadDTO ciudad;
    private ImagenDTO imagen;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        // this.tipo = new TipoDocumentoDTO();
        // this.tipo.setIdTipoDocumento(1);
        // this.tipo.setTipoDocumento("CC");
        //
        // this.ciudad = new CiudadDTO();
        // this.ciudad.setIdCiudad(2);
        // this.ciudad.setCiudad("Sincelejo");

        this.ciudad = new CiudadDTO();
        this.tipo = new TipoDocumentoDTO();
        this.imagen = new ImagenDTO();

        this.cliente = new ClienteDTO();
        this.cliente.setNombre("Cristian");
        this.cliente.setApellido("Turizo");
        this.cliente.setTipoDocumento(this.tipo);
        this.cliente.setDocumento("1010122424");
        this.cliente.setEdad(21);
        this.cliente.setCiudadNacimiento(this.ciudad);
        this.cliente.setIdImagen("");
        this.cliente.setImagenMongo(this.imagen);

    }

    @Test
    void obtener() {
        when(clienteServices.obtenerClientes()).thenReturn(List.of(cliente));
        assertNotNull(servicesFacade.obtener());
    }
}