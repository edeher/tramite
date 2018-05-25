package com.unia.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.util.Faces;

import com.unia.model.Perfil;
import com.unia.service.IPerfilService;

@Named
@ViewScoped
public class PerfilFormBean implements Serializable {

	@Inject
	private Perfil perfil;

	@Inject
	IPerfilService perfilservice;

	@PostConstruct
	public void init() {
		Integer idPerfil = Faces.getFlashAttribute("idPerfil");

		if (idPerfil != null && idPerfil > 0) {
			perfil.setIdPerfil(idPerfil);
			this.leer(perfil);
		}

	}

	public void leer(Perfil per) {

		try {

			perfil = perfilservice.listaPorId(per);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void operar() {

		try {
			if (perfil.getIdPerfil() > 0) {

				perfilservice.modificar(perfil);
			} else {
				perfilservice.registrar(perfil);
			}
		} catch (Exception e) {
			
		}

	}
	
	public void agregar(){
		
	}
	
	public void remover() {
		
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}
	
	
}
