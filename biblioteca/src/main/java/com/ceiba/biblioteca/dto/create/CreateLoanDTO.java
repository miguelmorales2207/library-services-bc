package com.ceiba.biblioteca.dto.create;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateLoanDTO implements Serializable {

    @NotBlank
    @Size(min = 1, max = 10)
    @JsonProperty(value = "isbn")
    private String isbn;

    @NotBlank
    @Size(min = 1, max = 10)
    @JsonProperty(value = "identificacionUsuario")
    private String identificacionUsuario;

    @NotNull
    @Min(value = 1, message = "Tipo usuario usuario must be greater than zero")
    @JsonProperty(value = "tipoUsuario")
    private Integer tipoUsuario;

    public CreateLoanDTO(String isbn, String identificacionUsuario, Integer tipoUsuario) {
        this.isbn = isbn;
        this.identificacionUsuario = identificacionUsuario;
        this.tipoUsuario = tipoUsuario;
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
}
