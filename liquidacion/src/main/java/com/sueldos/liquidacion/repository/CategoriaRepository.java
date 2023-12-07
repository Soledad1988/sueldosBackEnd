package com.sueldos.liquidacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sueldos.liquidacion.model.Categoria;


@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{

}
