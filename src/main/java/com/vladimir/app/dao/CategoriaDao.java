package com.vladimir.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vladimir.app.model.Categoria;

public interface  CategoriaDao extends JpaRepository<Categoria, Integer>  {

}
