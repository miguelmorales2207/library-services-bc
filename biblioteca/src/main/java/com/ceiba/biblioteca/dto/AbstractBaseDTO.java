package com.ceiba.biblioteca.dto;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class AbstractBaseDTO implements Serializable {

    private static final long serialVersionUID = 3311027123877852284L;

    private Integer id;

}
