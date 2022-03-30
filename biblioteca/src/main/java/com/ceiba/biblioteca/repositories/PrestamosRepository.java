package com.ceiba.biblioteca.repositories;

import com.ceiba.biblioteca.domain.PrestamoDomain;
import com.ceiba.biblioteca.models.Prestamos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PrestamosRepository extends JpaRepository<Prestamos, Integer> {

    boolean existsByIdentificacionUsuario(String usuarioId);

    @Query(
        "SELECT NEW com.ceiba.biblioteca.domain.PrestamoDomain"
            + "( p.id, p.isbn, p.identificacionUsuario"
            + ", p.tipoUsuario, p.fechaDevolucion) FROM Prestamos p"
            + " WHERE p.id = :id")
    PrestamoDomain findById2(@Param("id") Integer id);

}
