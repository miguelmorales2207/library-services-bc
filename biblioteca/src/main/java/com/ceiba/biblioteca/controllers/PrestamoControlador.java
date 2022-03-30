package com.ceiba.biblioteca.controllers;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import com.ceiba.biblioteca.domain.PrestamoDomain;
import com.ceiba.biblioteca.dto.create.CreateLoanDTO;
import com.ceiba.biblioteca.dto.model.PrestamoDTO;
import com.ceiba.biblioteca.dto.response.ResponsePostLoanDTO;
import com.ceiba.biblioteca.exceptions.BusinessRuleException;
import com.ceiba.biblioteca.models.Prestamos;
import com.ceiba.biblioteca.services.LoanService;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("prestamo")
public class PrestamoControlador {

    private final LoanService loanService;
    private final ModelMapper modelMapper;

    public PrestamoControlador(LoanService loanService, ModelMapper modelMapper) {
        this.loanService = loanService;
        this.modelMapper = modelMapper;
    }

    @GetMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<PrestamoDTO> loan(
        @PathVariable Integer id) throws ParseException {

        System.out.println("Start get method - Controller");
        PrestamoDomain prestamo = loanService.loan(id);

        PrestamoDTO prestamoDTO = generateResponseGetLoadDTO(prestamo);

        return ResponseEntity.ok()
            .body(prestamoDTO);
    }

    @PostMapping(value = "", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ResponsePostLoanDTO> create(
        @Valid @RequestBody CreateLoanDTO createLoanDTO)
        throws BusinessRuleException, ParseException {

        System.out.println("Start post method - Controller");
        Prestamos prestamoObject = generateLoanFromCreateDto(createLoanDTO);

        Prestamos prestamo = loanService.create(prestamoObject);

        ResponsePostLoanDTO mappedPrestamo = generateResponsePostLoanDTO(prestamo);

        return ResponseEntity
            .status(HttpStatus.OK)
            .body(mappedPrestamo);
    }

    private ResponsePostLoanDTO generateResponsePostLoanDTO(Prestamos prestamo)
        throws ParseException {
        ResponsePostLoanDTO prestamoDTO = new ResponsePostLoanDTO(null,null);
        prestamoDTO.setId(prestamo.getId());
        prestamoDTO.setFechaDevolucion(formatDate(prestamo.getFechaDevolucion()));

        return prestamoDTO;
    }

    private static Prestamos generateLoanFromCreateDto(CreateLoanDTO prestamoDTO) {
        Prestamos prestamo = new Prestamos(null, prestamoDTO.getIsbn(),
            prestamoDTO.getIdentificacionUsuario(), prestamoDTO.getTipoUsuario(), null);
        return prestamo;
    }

    private PrestamoDTO generateResponseGetLoadDTO(PrestamoDomain prestamo) throws ParseException {
        PrestamoDTO prestamoDTO = new PrestamoDTO(null, null, null,
            null, null);
        prestamoDTO.setId(prestamo.getId());
        prestamoDTO.setIsbn(prestamo.getIsbn());
        prestamoDTO.setIdentificacionUsuario(prestamo.getIdentificacionUsuario());
        prestamoDTO.setTipoUsuario(prestamo.getTipoUsuario());
        prestamoDTO.setFechaDevolucion(formatDate(prestamo.getFechaDevolucion()));

        return prestamoDTO;
    }

    private String formatDate(LocalDate date) throws ParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formatedFinalDate = formatter.format(date);

        return formatedFinalDate;
    }

}
