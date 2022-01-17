package Monolito6.services.imagen;

import Monolito6.models.DTOs.ImagenDTO;

public interface IImagenServices {

    ImagenDTO obtenerPorId(String id);

    ImagenDTO guardarImagen(ImagenDTO imagen);

    void eliminarImagen(String id);
}
