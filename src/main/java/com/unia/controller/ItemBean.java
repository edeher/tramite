package com.unia.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.util.Faces;

import com.unia.model.ItemTipoTramite;
import com.unia.service.IItemTipoTramiteService;

//llego a linux y sale

@Named
@ViewScoped
public class ItemBean implements Serializable{
	
	@Inject
	private IItemTipoTramiteService serviceitemtipotramite;
	
	private List<ItemTipoTramite> lstItemTipoTramite;
	
	
	@PostConstruct
	public void init() {
		lstItemTipoTramite=new ArrayList<>();
		this.listar();
	}

	public void listar() {
		
		try {
			this.lstItemTipoTramite=serviceitemtipotramite.listar();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void seleccionar(ItemTipoTramite itemtipotramite) {
		
		
		Faces.setFlashAttribute("itemTipoTramite", itemtipotramite);
		
		
	}
	
	

	public List<ItemTipoTramite> getLstItemTipoTramite() {
		return lstItemTipoTramite;
	}

	public void setLstItemTipoTramite(List<ItemTipoTramite> lstItemTipoTramite) {
		this.lstItemTipoTramite = lstItemTipoTramite;
	}
	
	
}
