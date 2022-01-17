package Monolito6.mappers;

import Monolito6.models.DTOs.*;
import Monolito6.models.entities.*;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;

@Mapper(componentModel = "spring")
public interface IMapper {
    IMapper INSTANCE = Mappers.getMapper(IMapper.class);

    ArrayList<ClienteDTO> toClientesDto(ArrayList<ClienteEntidad> clientesEntidad);
    ClienteDTO toClienteDto(ClienteEntidad clienteEntidad);
    ClienteEntidad toClienteEntidad(ClienteDTO clienteDTO);

    ImagenDTO toImagenDto(ImagenMongo imagenEntidad);
    ImagenMongo toImagenMongo(ImagenDTO imagenDTO);

    CiudadDTO toCiudadDto(CiudadEntidad ciudadEntidad);
    CiudadEntidad toCiudadEntidad(CiudadDTO ciudadDTO);

    TipoDocumentoDTO toTipoDocumentoDto(TipoDocumentoEntidad tipoDocumentoEntidad);
    TipoDocumentoEntidad toTipoDocumentoEntidad(TipoDocumentoDTO tipoDocumentoDTO);
}
