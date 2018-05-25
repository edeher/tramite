package com.unia.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.util.Faces;

import com.unia.model.Perfil;
import com.unia.model.Usuario;
import com.unia.service.IPerfilService;

@Named
@ViewScoped
public class PerfilBean implements Serializable{
	
	@Inject
	private IPerfilService perfilservice;
	
	private List<Perfil> lstPerfiles;
	
	@PostConstruct
	public void init() {

		lstPerfiles = new ArrayList<>();
		this.listar();
	}

	public void listar() {
		try {
			this.lstPerfiles = perfilservice.listar();
		} catch (Exception e) {

		}
	}

	public void seleccionar(Perfil perfil) {
		Faces.setFlashAttribute("idPerfil", perfil.getIdPerfil());
		
	}

	public List<Perfil> getLstPerfiles() {
		return lstPerfiles;
	}

	public void setLstPerfiles(List<Perfil> lstPerfiles) {
		this.lstPerfiles = lstPerfiles;
	}

	
	
}
