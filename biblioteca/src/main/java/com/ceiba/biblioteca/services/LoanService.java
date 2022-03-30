package com.ceiba.biblioteca.services;

import com.ceiba.biblioteca.domain.PrestamoDomain;
import com.ceiba.biblioteca.exceptions.BusinessRuleException;
import com.ceiba.biblioteca.models.Prestamos;
import java.text.ParseException;

public interface LoanService {

    PrestamoDomain loan(Integer id);

    Prestamos create(Prestamos Prestamo) throws BusinessRuleException, ParseException;

}
