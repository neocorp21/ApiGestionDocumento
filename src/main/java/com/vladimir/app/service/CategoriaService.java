package com.vladimir.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vladimir.app.dao.CategoriaDao;
import com.vladimir.app.interfaces.Crud;
import com.vladimir.app.model.Categoria;

@Service

public class CategoriaService implements Crud<Categoria, Integer> {
	@Autowired
	private CategoriaDao categoriaDao;

	@Override
	public List<Categoria> listar() {
		return (List<Categoria>) categoriaDao.findAll();
	}

	@Override
	public Optional<Categoria> buscarPorId(Integer id) {
		return categoriaDao.findById(id);

	}

	@Override
	public void guardar(Categoria obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean existePorId(Integer id) {
		return categoriaDao.existsById(id);
	}

	@Override
	public void eliminarPorId(Integer id) {
		categoriaDao.deleteById(id);

	}

}
