package com.unia.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.util.Faces;

import com.unia.model.Usuario;
import com.unia.service.IUsuarioService;

@Named
@ViewScoped
public class UsuarioBean implements Serializable {

	// mio---mitocode
	// usuario-contrato
	// perfil-persona
	// persona-puesto

	@Inject
	private IUsuarioService service;
	private List<Usuario> LstUsuarios;

	@PostConstruct
	public void init() {

		LstUsuarios = new ArrayList<>();
		this.listar();
	}

	public void listar() {
		try {
			this.LstUsuarios = service.listar();
		} catch (Exception e) {

		}
	}

	public void seleccionar(Usuario usuario) {
		Faces.setFlashAttribute("usuario", usuario);
		
	}

	/* getters & setters */
	public List<Usuario> getLstUsuarios() {
		return LstUsuarios;
	}

	public void setLstUsuarios(List<Usuario> lstUsuarios) {
		LstUsuarios = lstUsuarios;
	}

}
