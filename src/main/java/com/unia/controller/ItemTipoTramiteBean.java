package com.unia.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.unia.model.Area;
import com.unia.model.ItemTipoTramite;
import com.unia.model.TipoTramite;
import com.unia.service.IAreaService;
import com.unia.service.IItemTipoTramiteService;
import com.unia.service.ITipoTramiteService;

//problema de combos en modales resuelto



@Named
@ViewScoped
public class ItemTipoTramiteBean implements Serializable{
	

	
	@Inject
	private ItemTipoTramite itemtipotramite;
	@Inject
	private Area area;
	@Inject
	private TipoTramite tipotramite;
	
	@Inject 
	private IItemTipoTramiteService serviceitemtipotramite;
	@Inject
	private IAreaService servicearea;
	@Inject
	private ITipoTramiteService servicetipotramite;
		
	private List<ItemTipoTramite> lstItemsTiposTramite;
	private List<Area> lstArea;
	private List<TipoTramite> lstTiposTramite;
	
	
	@PostConstruct
	public void init() {
		
		lstItemsTiposTramite=new ArrayList<>();
		lstArea=new ArrayList<>();
		lstTiposTramite=new ArrayList<>();
		this.listar();
		this.listarAreas();
		this.listarTiposTramites();
		
	}
	
	public void listar() {
		try {
			this.lstItemsTiposTramite=serviceitemtipotramite.listar();
		} catch (Exception e) {
			// TODO Auto-generated catch block
		
		}
		
	}
	public void listarAreas() {
		try {
			this.lstArea=servicearea.listar();
		} catch (Exception e) {
			// TODO Auto-generated catch block
		
		}
		
	}
	public void listarTiposTramites() {
		try {
			lstTiposTramite=servicetipotramite.listar();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void seleccionar(ItemTipoTramite i) {
		
		try {
			this.itemtipotramite=serviceitemtipotramite.listaPorId(i);
			this.area=itemtipotramite.getArea();
			this.tipotramite=itemtipotramite.getTipotramite();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}	
	public void operar() {
		
		try {
			if (itemtipotramite.getIdItemTipoTramite() > 0) {
				
				
				itemtipotramite.setArea(area);
				itemtipotramite.setTipotramite(tipotramite);
				serviceitemtipotramite.modificar(itemtipotramite);
			} else {
				
				itemtipotramite.setArea(area);
				itemtipotramite.setTipotramite(tipotramite);
				serviceitemtipotramite.registrar(itemtipotramite);
			}
		} catch (Exception e) {
			
		}
	}
	
	public ItemTipoTramite getItemtipotramite() {
		return itemtipotramite;
	}
	public void setItemtipotramite(ItemTipoTramite itemtipotramite) {
		this.itemtipotramite = itemtipotramite;
	}
	public Area getArea() {
		return area;
	}
	public void setArea(Area area) {
		this.area = area;
	}
	public TipoTramite getTipotramite() {
		return tipotramite;
	}
	public void setTipotramite(TipoTramite tipotramite) {
		this.tipotramite = tipotramite;
	}
	public List<ItemTipoTramite> getLstItemsTiposTramite() {
		return lstItemsTiposTramite;
	}
	public void setLstItemsTiposTramite(List<ItemTipoTramite> lstItemsTiposTramite) {
		this.lstItemsTiposTramite = lstItemsTiposTramite;
	}
	public List<Area> getLstArea() {
		return lstArea;
	}
	public void setLstArea(List<Area> lstArea) {
		this.lstArea = lstArea;
	}
	public List<TipoTramite> getLstTiposTramite() {
		return lstTiposTramite;
	}
	public void setLstTiposTramite(List<TipoTramite> lstTiposTramite) {
		this.lstTiposTramite = lstTiposTramite;
	}
	
	
	
	
	
	
	
	

}
