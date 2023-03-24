package com.vladimir.app.interfaces;

import java.util.List;
import java.util.Optional;

public interface Crud<T, ID> {
	List<T> listar();

	Optional<T> buscarPorId(ID id);

	void guardar(T entity);

	boolean existePorId(ID id);

	void eliminarPorId(ID id);

	 
}
