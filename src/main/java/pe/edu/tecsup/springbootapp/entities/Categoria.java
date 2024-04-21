package pe.edu.tecsup.springbootapp.entities;

public class Categoria {

    private Long id;
    private String nombre;
    private Integer orden;

    // Crear getters and setter methodos

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getOrden() {
        return orden;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", orden=" + orden +
                '}';
    }
}
