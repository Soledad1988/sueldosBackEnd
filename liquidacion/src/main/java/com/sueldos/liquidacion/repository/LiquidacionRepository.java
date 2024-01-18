package com.sueldos.liquidacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sueldos.liquidacion.model.Liquidacion;


@Repository
public interface LiquidacionRepository extends JpaRepository<Liquidacion, Integer>{

}
