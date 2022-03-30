package com.ceiba.biblioteca.dto.model;

import com.ceiba.biblioteca.dto.AbstractBaseDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class PrestamoDTO extends AbstractBaseDTO implements Serializable {

    private static final long serialVersionUID = 8258471579889975752L;

    @JsonProperty(value = "id")
    private Integer id;

    @JsonProperty(value = "isbn")
    private String isbn;

    @JsonProperty(value = "identificacionUsuario")
    private String identificacionUsuario;

    @JsonProperty(value = "tipoUsuario")
    private Integer tipoUsuario;

    @JsonProperty(value = "fechaMaximaDevolucion")
    private String fechaDevolucion;

    public PrestamoDTO(Integer id, String isbn, String identificacionUsuario,
        Integer tipoUsuario, String fechaDevolucion) {
        this.id = id;
        this.isbn = isbn;
        this.identificacionUsuario = identificacionUsuario;
        this.tipoUsuario = tipoUsuario;
        this.fechaDevolucion = fechaDevolucion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getIdentificacionUsuario() {
        return identificacionUsuario;
    }

    public void setIdentificacionUsuario(String identificacionUsuario) {
        this.identificacionUsuario = identificacionUsuario;
    }

    public Integer getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(Integer tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(String fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

}
