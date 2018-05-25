package com.unia.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.unia.model.ItemTipoTramite;
import com.unia.model.TipoTramite;
import com.unia.service.IItemTipoTramiteService;
import com.unia.service.ITipoTramiteService;

@Named
@ViewScoped
public class TipoTramiteBean implements Serializable {

	@Inject
	private TipoTramite tipotramite;
	private List<TipoTramite> lstTiposTramites;
	
	@Inject
	private ItemTipoTramite itemTipoTramite;
	private List<ItemTipoTramite> lstItemTipoTramite;
	
	@Inject
	private IItemTipoTramiteService serviceItemTipoTramite;

	@Inject
	private ITipoTramiteService servicetipotramite;

	@PostConstruct
	public void init() {
		lstTiposTramites = new ArrayList<>();
		lstItemTipoTramite = new ArrayList<>();
		this.listar();
	}

	public void listar() {

		try {
			lstTiposTramites = servicetipotramite.listar();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void seleccionar(TipoTramite t) {
		
		
		try {
			
			
			this.tipotramite = servicetipotramite.listaPorId(t);
			
			this.lstItemTipoTramite = serviceItemTipoTramite.listarTipoTramite(tipotramite);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void operar() {

		try {
			
			if (tipotramite.getIdTipoTramite() > 0) {
				servicetipotramite.modificar(tipotramite);
			} else {
				servicetipotramite.registrar(tipotramite);

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
		
		}

	}

	public List<TipoTramite> getLstTiposTramites() {
		return lstTiposTramites;
	}

	public void setLstTiposTramites(List<TipoTramite> lstTiposTramites) {
		this.lstTiposTramites = lstTiposTramites;
	}

	public TipoTramite getTipotramite() {
		return tipotramite;
	}

	public void setTipotramite(TipoTramite tipotramite) {
		this.tipotramite = tipotramite;
	}

	public ItemTipoTramite getItemTipoTramite() {
		return itemTipoTramite;
	}

	public void setItemTipoTramite(ItemTipoTramite itemTipoTramite) {
		this.itemTipoTramite = itemTipoTramite;
	}

	public List<ItemTipoTramite> getLstItemTipoTramite() {
		return lstItemTipoTramite;
	}

	public void setLstItemTipoTramite(List<ItemTipoTramite> lstItemTipoTramite) {
		this.lstItemTipoTramite = lstItemTipoTramite;
	}

}
