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
import com.unia.model.Persona;
import com.unia.model.Usuario;

import com.unia.service.IPerfilService;
import com.unia.service.IPersonaService;
import com.unia.service.IUsuarioService;

@Named
@ViewScoped
public class UsuarioFormBean implements Serializable{
	
	

	@Inject 
	private Usuario usuario;
	@Inject 
	private Persona persona;
	@Inject 
	private Perfil perfil;
	@Inject 
	private IPersonaService personaService;
	@Inject 
	private IPerfilService perfilService;
	@Inject
	private IUsuarioService usuarioService;
	
	
	private List<Persona> lstPersonas;
	private List<Perfil> lstPerfiles;
	
	
	@PostConstruct
	public void init() {
		lstPersonas= new ArrayList<>();
		lstPerfiles=new ArrayList<>();
		this.listarPersonas();
		this.listarPerfiles();
		
		Usuario usu=(Usuario)Faces.getFlashAttribute("usuario");
		
		if(usu!=null) {
			this.leer(usu);
		}else {
			
		}
		
	}
	public void leer(Usuario usu) {
		try {
			usuario=usuarioService.listaPorId(usu);
			this.persona=usuario.getPersona();
			this.perfil=usuario.getPerfil();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void listarPersonas() {
		try {
			lstPersonas=personaService.listar();
		} catch (Exception e) {
			
		}
	}
	public void listarPerfiles() {
		try {
			lstPerfiles=perfilService.listar();
		} catch (Exception e) {
			
		}
	}
	
public void registrar() {
	
	try {
		
		usuario.setIdUsuario(usuarioService.getSiguientePK(persona));
		usuario.setPersona(persona);
		usuario.setPerfil(perfil);
		usuarioService.registrar(usuario);
	} catch (Exception e) {
		
	}
	
	
}

	
//	 getters & setters
	 
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public List<Persona> getLstPersonas() {
		return lstPersonas;
	}

	public void setLstPersonas(List<Persona> lstPersonas) {
		this.lstPersonas = lstPersonas;
	}

	public List<Perfil> getLstPerfiles() {
		return lstPerfiles;
	}

	public void setLstPerfiles(List<Perfil> lstPerfiles) {
		this.lstPerfiles = lstPerfiles;
	}

	

	
	
	
	
	
}
