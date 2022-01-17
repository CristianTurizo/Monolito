package Monolito6.services.imagen;

import Monolito6.models.DTOs.ImagenDTO;
import Monolito6.repositories.IImagenRepository;
import Monolito6.mappers.IMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ImagenServiceImpl implements IImagenServices {

    private final IMapper mapper;
    private final IImagenRepository imagenRepository;

    @Override
    public ImagenDTO obtenerPorId(String id) {
        return this.mapper.toImagenDto(
                this.imagenRepository.findById(id).orElse(null));
    }

    @Override
    public ImagenDTO guardarImagen(ImagenDTO imagen) {
        return this.mapper.toImagenDto(
                this.imagenRepository.save(
                        this.mapper.toImagenMongo(imagen)));
    }

    @Override
    public void eliminarImagen(String id) {
        try {
            this.imagenRepository.deleteById(id);
        }catch (Exception e){
            System.out.println("No hay Imagen");
        }
    }
}
