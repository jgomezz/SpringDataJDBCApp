package pe.edu.tecsup.springbootapp.entities;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Categoria {

    private Long id;
    private String nombre;
    private Integer orden;

}
