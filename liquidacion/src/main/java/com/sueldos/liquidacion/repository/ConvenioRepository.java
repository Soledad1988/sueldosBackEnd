package com.sueldos.liquidacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sueldos.liquidacion.model.Convenio;

@Repository
public interface ConvenioRepository extends JpaRepository<Convenio, Integer>{

}
