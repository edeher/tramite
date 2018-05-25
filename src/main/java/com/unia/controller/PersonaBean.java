package com.unia.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.unia.model.Menu;
import com.unia.model.MenuItem;
import com.unia.model.Persona;
import com.unia.service.IPersonaService;

@Named
@ViewScoped
public class PersonaBean implements Serializable{
	
	@Inject
	private Persona persona;
	private List<Persona> lstPersonas;
	
	@Inject
	private IPersonaService service;
	
	private String titulo;
	
	@PostConstruct
	public void init() {
		titulo="Nuevo";
		lstPersonas= new ArrayList<>();
		this.listar();
	}
	
	public void listar() {
		try {
			lstPersonas=service.listar();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void operar() {
		try {
			
			if(persona.getIdPersona()>0) {
				service.modificar(persona);
			}else {
				service.registrar(persona);
			}
			
			this.listar();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void seleccionar(Persona per) {
		try {
			this.persona=service.listaPorId(per);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.titulo="Modificar";
		}
		
	}
	
	public void limpiarControles() {
		this.lstPersonas.clear();
		this.lstPersonas=new ArrayList<>();
		this.persona.setApellidos(null);
		this.persona.setCorreo(null);
		this.persona.setDireccion(null);
		this.persona.setDni(null);
		this.persona.setIdPersona((int)0);
		this.persona.setNombres(null);
		this.persona.setSexo(null);
		this.persona.setTelefono(null);
	}
	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public List<Persona> getLstPersonas() {
		return lstPersonas;
	}

	public void setLstPersonas(List<Persona> lstPersonas) {
		this.lstPersonas = lstPersonas;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	
	
	
}
