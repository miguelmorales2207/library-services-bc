package com.ceiba.biblioteca.services.impl;

import static com.ceiba.biblioteca.constants.GeneralConstants.TIPO_USUARIO_DOS;
import static com.ceiba.biblioteca.constants.GeneralConstants.TIPO_USUARIO_TRES;
import static com.ceiba.biblioteca.constants.GeneralConstants.TIPO_USUARIO_UNO;

import com.ceiba.biblioteca.domain.PrestamoDomain;
import com.ceiba.biblioteca.enums.BookReturnDaysEnum;
import com.ceiba.biblioteca.exceptions.BusinessRuleException;
import com.ceiba.biblioteca.models.Prestamos;
import com.ceiba.biblioteca.repositories.PrestamosRepository;
import com.ceiba.biblioteca.services.LoanService;
import java.text.ParseException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Arrays;
import javax.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class LoanServiceImpl implements LoanService {

    private final PrestamosRepository prestamosRepository;

    public LoanServiceImpl(PrestamosRepository prestamosRepository) {
        this.prestamosRepository = prestamosRepository;
    }

    @Override
    public PrestamoDomain loan(Integer id) {
        PrestamoDomain prestamoObject = prestamosRepository.findById2(id);
        if (prestamoObject == null) {
            throw new EntityNotFoundException(
                String.format("Prestamo con ID %1$s no se encuentra.", id));
        }
        return prestamoObject;
    }

    @Override
    public Prestamos create(Prestamos prestamo) throws BusinessRuleException, ParseException {

        Integer[] userInvited = {TIPO_USUARIO_TRES};
        Boolean userIvited = Arrays.asList(userInvited).contains(prestamo.getTipoUsuario());
        if (userIvited) {
            Boolean prestamoAlreadyExist = prestamosRepository
                .existsByIdentificacionUsuario(prestamo.getIdentificacionUsuario());
            if (prestamoAlreadyExist) {
                String message = String.format("El usuario con identificación %s ya tiene"
                        + " un libro prestado por lo cual no se le puede realizar otro préstamo",
                    prestamo.getIdentificacionUsuario());
                throw new BusinessRuleException(message);
            }
        }

        Integer[] userTypesAllow = {TIPO_USUARIO_UNO, TIPO_USUARIO_DOS, TIPO_USUARIO_TRES};
        Boolean userTypeValid = Arrays.asList(userTypesAllow).contains(prestamo.getTipoUsuario());
        if (!userTypeValid) {
            String message = String.format("Tipo de usuario no permitido en la biblioteca",
                prestamo.getIdentificacionUsuario());
            throw new BusinessRuleException(message);
        }

        LocalDate finalDate = calculateDate(prestamo.getTipoUsuario());
        prestamo.setFechaDevolucion(finalDate);
        Prestamos loanCreated = prestamosRepository.save(prestamo);
        return loanCreated;
    }

    private LocalDate calculateDate(Integer userType) throws ParseException {
        LocalDate now = LocalDate.now();
        int returnDays = BookReturnDaysEnum.toEnum(userType).userType;
        LocalDate calculatedLocalDate = addDaysSkippingWeekends(now, returnDays);

        return calculatedLocalDate;
    }

    public LocalDate addDaysSkippingWeekends(LocalDate date, int days) {
        LocalDate result = date;
        int addedDays = 0;
        while (addedDays < days) {
            result = result.plusDays(1);
            if (!(result.getDayOfWeek() == DayOfWeek.SATURDAY
                || result.getDayOfWeek() == DayOfWeek.SUNDAY)) {
                ++addedDays;
            }
        }
        return result;
    }

}
