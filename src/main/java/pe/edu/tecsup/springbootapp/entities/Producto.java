package pe.edu.tecsup.springbootapp.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class Producto {

    private Long id;
    private Long categorias_id;
    private Categoria categoria;
    private String nombre;
    private String descripcion;
    private Double precio;
    private Integer stock;
    private String imagen_nombre;
    private String imagen_tipo;
    private Long imagen_tamanio;
    private Integer estado;
}
