package com.vladimir.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vladimir.app.model.Categoria;
import com.vladimir.app.service.CategoriaService;
import com.vladimir.app.util.BodyResponse;
import com.vladimir.app.util.ValidationException;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
	@Autowired
	private CategoriaService categoriaService;

	@GetMapping("/listar")
	public ResponseEntity<?> obtenerLista() {
		try {
			List<Categoria> lista = categoriaService.listar();
			if (lista.isEmpty()) {
				return ResponseEntity.noContent().build();
			}
			return ResponseEntity.ok(lista);

		} catch (ValidationException ex) {
			BodyResponse response = new BodyResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
			return ResponseEntity.badRequest().body(response);
		}

	}

	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Integer id) {
	 //   try {
	        boolean existe = categoriaService.existePorId(id);
	        if (existe) {
	            categoriaService.eliminarPorId(id);
	            return ResponseEntity.noContent().build();
	        } else {
	            BodyResponse response = new BodyResponse(HttpStatus.NOT_FOUND.value(), "El ID no existe");
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	        }
	/*
	} catch (ValidationException ex) {
	        BodyResponse response = new BodyResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage());
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	    }
	    */
	}

}
