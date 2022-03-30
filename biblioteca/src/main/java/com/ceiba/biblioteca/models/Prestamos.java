package com.ceiba.biblioteca.models;

import com.ceiba.biblioteca.serializers.LoanSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@Entity
@Table(name = "prestamos", schema="public")
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
@JsonSerialize(using = LoanSerializer.class)
public class Prestamos extends AbstractBaseEntity {

    private static final long serialVersionUID = -4098609919121444302L;

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "isbn", nullable = false)
    private String isbn;

    @Column(name = "identificacion_usuario", nullable = false)
    private String identificacionUsuario;

    @Column(name = "tipo_usuario", nullable = false)
    private Integer tipoUsuario;

    @Column(name = "fecha_devolucion", nullable = false)
    private LocalDate fechaDevolucion;

    public Prestamos(Integer id) {
        super(id);
    }

    public Prestamos(Integer id, String isbn, String identificacionUsuario,
        Integer tipoUsuario, LocalDate fechaDevolucion) {
        this.id = id;
        this.isbn = isbn;
        this.identificacionUsuario = identificacionUsuario;
        this.tipoUsuario = tipoUsuario;
        this.fechaDevolucion = fechaDevolucion;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
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

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

}
