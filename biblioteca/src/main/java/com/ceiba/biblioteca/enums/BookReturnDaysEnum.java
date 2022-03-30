package com.ceiba.biblioteca.enums;

import static com.ceiba.biblioteca.constants.GeneralConstants.TIPO_USUARIO_UNO;
import static com.ceiba.biblioteca.constants.GeneralConstants.TIPO_USUARIO_DOS;
import static com.ceiba.biblioteca.constants.GeneralConstants.TIPO_USUARIO_TRES;
import static com.ceiba.biblioteca.constants.GeneralConstants.VALOR_TIPO_USUARIO_UNO;
import static com.ceiba.biblioteca.constants.GeneralConstants.VALOR_TIPO_USUARIO_DOS;
import static com.ceiba.biblioteca.constants.GeneralConstants.VALOR_TIPO_USUARIO_TRES;

import java.util.HashMap;
import java.util.Map;

public enum BookReturnDaysEnum {

    RETURN_DAYS_AFFILIATED(VALOR_TIPO_USUARIO_UNO),
    RETURN_DAYS_EMPLOYEE(VALOR_TIPO_USUARIO_DOS),
    RETURN_DAYS_INVITED(VALOR_TIPO_USUARIO_TRES);

    public final int userType;

    private static final Map<Integer, BookReturnDaysEnum> bookReturnDaysMap = new HashMap<>();

    static {
        bookReturnDaysMap.put(TIPO_USUARIO_UNO, RETURN_DAYS_AFFILIATED);
        bookReturnDaysMap.put(TIPO_USUARIO_DOS, RETURN_DAYS_EMPLOYEE);
        bookReturnDaysMap.put(TIPO_USUARIO_TRES, RETURN_DAYS_INVITED);
    }

    BookReturnDaysEnum(int userType) {
        this.userType = userType;
    }

    public static BookReturnDaysEnum toEnum(Integer userType) {
        BookReturnDaysEnum message = null;
        if (bookReturnDaysMap.get(userType) != null) {
            message = bookReturnDaysMap.get(userType);
        }
        return message;
    }

}
