package pe.edu.tecsup.springbootapp.entities;

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

    // Crear getters and setter methodos


    public void setId(Long id) {
        this.id = id;
    }

    public void setCategorias_id(Long categorias_id) {
        this.categorias_id = categorias_id;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public void setImagen_nombre(String imagen_nombre) {
        this.imagen_nombre = imagen_nombre;
    }

    public void setImagen_tipo(String imagen_tipo) {
        this.imagen_tipo = imagen_tipo;
    }

    public void setImagen_tamanio(Long imagen_tamanio) {
        this.imagen_tamanio = imagen_tamanio;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public Long getCategorias_id() {
        return categorias_id;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public Integer getStock() {
        return stock;
    }

    public String getImagen_nombre() {
        return imagen_nombre;
    }

    public String getImagen_tipo() {
        return imagen_tipo;
    }

    public Long getImagen_tamanio() {
        return imagen_tamanio;
    }

    public Integer getEstado() {
        return estado;
    }
}
