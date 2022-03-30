package com.ceiba.biblioteca.dto.response;

import com.ceiba.biblioteca.dto.AbstractBaseDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import lombok.Data;

@Data
public class ResponsePostLoanDTO extends AbstractBaseDTO implements Serializable {

    @JsonProperty(value = "id")
    private Integer id;

    @JsonProperty(value = "fechaMaximaDevolucion")
    private String fechaDevolucion;

    public ResponsePostLoanDTO(Integer id, String fechaDevolucion) {
        this.id = id;
        this.fechaDevolucion = fechaDevolucion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(String fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }
}
