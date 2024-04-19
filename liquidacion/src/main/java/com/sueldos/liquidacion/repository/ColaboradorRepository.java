package com.sueldos.liquidacion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sueldos.liquidacion.model.Colaborador;

@Repository
public interface ColaboradorRepository extends JpaRepository<Colaborador, Integer>{
	 List<Colaborador> findByActivo(boolean activo);
}
