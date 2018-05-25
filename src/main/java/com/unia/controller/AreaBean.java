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
import com.unia.service.IAreaService;
import com.unia.service.IItemTipoTramiteService;

@Named
@ViewScoped
public class AreaBean implements Serializable {

	@Inject
	private Area area;
	@Inject
	private ItemTipoTramite itemTipoTramite;
	private List<Area> lstAreas;

	private List<ItemTipoTramite> lstItemTipoTramite;

	@Inject
	private IAreaService serviceArea;

	@Inject
	private IItemTipoTramiteService serviceItemTipoTramite;

	@PostConstruct
	public void init() {

		lstAreas = new ArrayList<>();
		lstItemTipoTramite = new ArrayList<>();
		this.listar();
	}

	public void listar() {

		try {
			lstAreas = serviceArea.listar();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void seleccionar(Area A) {

		try {
			this.area = serviceArea.listaPorId(A);
			
			this.lstItemTipoTramite = serviceItemTipoTramite.listarPorArea(area);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void agregar() {

		ItemTipoTramite itetitr = new ItemTipoTramite();
		itetitr.setPlazo(itemTipoTramite.getPlazo());
		itetitr.setItem(itemTipoTramite.getItem());
		itetitr.setArea(area);
		this.getLstItemTipoTramite().add(itetitr);
	}

	public void remover(ItemTipoTramite itetitr) {

		this.lstItemTipoTramite.remove(itetitr);
	}

	public void operar() {
		try {
		area.setItemTipoTramite(this.lstItemTipoTramite);
		if (area.getIdArea() > 0) {
			serviceArea.modificar(area);
		} else {
			serviceArea.registrar(area);
		}
		this.listar();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public Area getArea() {
		return area;

	}

	public void setArea(Area area) {
		this.area = area;
	}

	public List<Area> getLstAreas() {
		return lstAreas;
	}

	public void setLstAreas(List<Area> lstAreas) {
		this.lstAreas = lstAreas;
	}

	public List<ItemTipoTramite> getLstItemTipoTramite() {
		return lstItemTipoTramite;
	}

	public void setLstItemTipoTramite(List<ItemTipoTramite> lstItemTipoTramite) {
		this.lstItemTipoTramite = lstItemTipoTramite;
	}

	public ItemTipoTramite getItemTipoTramite() {
		return itemTipoTramite;
	}

	public void setItemTipoTramite(ItemTipoTramite itemTipoTramite) {
		this.itemTipoTramite = itemTipoTramite;
	}

}
