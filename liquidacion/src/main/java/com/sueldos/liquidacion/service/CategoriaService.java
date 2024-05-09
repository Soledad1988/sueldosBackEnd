package com.sueldos.liquidacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sueldos.liquidacion.model.Categoria;
import com.sueldos.liquidacion.repository.CategoriaRepository;

@Service
public class CategoriaService implements ICategoriaService{
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	@Override
	public void crear(Categoria categoria) {
		categoriaRepository.save(categoria);
	}

	@Override
	public List<Categoria> listar() {
		return categoriaRepository.findAll();
	}

	@Override
	public void borrar(Integer idCategoria) {
		categoriaRepository.deleteById(idCategoria);
	}

	@Override
	public Categoria buscar(Integer idCategoria) {
		return categoriaRepository.findById(idCategoria).orElse(null);
	}

	@Override
	public void actualizar(Categoria categoria) {
		categoriaRepository.save(categoria);	
	}

	@Override
	  public List<Categoria> getCategoriasPorConvenio(Integer idConvenio) {
        return categoriaRepository.findByConvenioIdConvenio(idConvenio);
    }
	

    // Método para obtener los detalles completos de una categoría, incluido el convenio asociado
    @Override
    public Categoria getCategoriaDetalles(Integer idCategoria) {
        return categoriaRepository.findCategoriaWithDetails(idCategoria);
    }

}
