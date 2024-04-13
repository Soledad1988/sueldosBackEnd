package com.sueldos.liquidacion.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sueldos.liquidacion.model.Novedad;


public interface NovedadRepository extends JpaRepository<Novedad, Integer>{
	 List<Novedad> findByPeriodoBetween(LocalDate startDate, LocalDate endDate);
}
