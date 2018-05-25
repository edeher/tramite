package com.unia.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.util.Faces;

import com.unia.model.Area;
import com.unia.model.ItemTipoTramite;
import com.unia.model.TipoTramite;

import com.unia.service.IAreaService;
import com.unia.service.IItemTipoTramiteService;
import com.unia.service.ITipoTramiteService;



//combos en paginas diferentes

@Named
@ViewScoped
public class ItemBeanForm implements Serializable {

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

	private List<Area> lstArea;
	private List<TipoTramite> lstTipoTramite;

	@PostConstruct
	public void init() {
		lstArea = new ArrayList<>();
		lstTipoTramite = new ArrayList<>();
		this.listaarea();
		this.listatipotramite();

		ItemTipoTramite item = Faces.getFlashAttribute("itemTipoTramite");

		if (item != null) {

			this.leer(item);
		}

	}

	public void listaarea() {
		try {
			lstArea = servicearea.listar();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void listatipotramite() {
		try {
			lstTipoTramite = servicetipotramite.listar();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void leer(ItemTipoTramite t) {
		try {
			itemtipotramite = serviceitemtipotramite.listaPorId(t);
			this.area = t.getArea();
			
			this.tipotramite = t.getTipotramite();
			
		} catch (Exception e) {

		}
	}

	public void registrar() {
		
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
			// TODO Auto-generated catch block
			e.printStackTrace();
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

	public List<Area> getLstArea() {
		return lstArea;
	}

	public void setLstArea(List<Area> lstArea) {
		this.lstArea = lstArea;
	}

	public List<TipoTramite> getLstTipoTramite() {
		return lstTipoTramite;
	}

	public void setLstTipoTramite(List<TipoTramite> lstTipoTramite) {
		this.lstTipoTramite = lstTipoTramite;
	}

}
