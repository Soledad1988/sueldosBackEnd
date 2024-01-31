package com.sueldos.liquidacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sueldos.liquidacion.model.ObraSocial;

@Repository
public interface ObraSocialRepository extends JpaRepository<ObraSocial, Integer>{

}
