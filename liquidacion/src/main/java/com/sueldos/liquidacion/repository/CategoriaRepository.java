package com.sueldos.liquidacion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sueldos.liquidacion.model.Categoria;


@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{

	List<Categoria> findByConvenioIdConvenio(Integer idConvenio);
	
	 @Query("SELECT c FROM Categoria c LEFT JOIN FETCH c.convenio WHERE c.idCategoria = :idCategoria")
	    Categoria findCategoriaWithDetails(Integer idCategoria);
}
