package com.unia.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.unia.model.Area;
import com.unia.model.Cargo;
import com.unia.service.IAreaService;
import com.unia.service.ICargoService;

@Named
@ViewScoped
public class CargoBean implements Serializable {

	@Inject
	private Cargo cargo;
	@Inject
	private Area area;

	@Inject
	private ICargoService servicecargo;
	@Inject
	private IAreaService servicearea;

	private List<Cargo> lstCargo;
	private List<Area> lstArea;

	@PostConstruct
	public void init() {

		lstArea = new ArrayList<>();
		lstCargo = new ArrayList<>();
		this.listarcargo();
		this.listararea();

	}

	public void listarcargo() {
		try {
			lstCargo = servicecargo.listar();
		} catch (Exception e) {

		}
	}

	public void listararea() {
		try {
			lstArea = servicearea.listar();
		} catch (Exception e) {

		}
	}

	public void seleccionar(Cargo car) {
		try {
			this.cargo = servicecargo.listaPorId(car);
			this.area= cargo.getArea();
		} catch (Exception e) {

		}
	}

	public void operar() {

		try {

			if (cargo.getIdCargo() > 0) {
				
				cargo.setArea(area);
				servicecargo.modificar(cargo);
				
			} else {
				cargo.setArea(area);
				servicecargo.registrar(cargo);
			}
		} catch (Exception e) {
			
		}

	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public List<Cargo> getLstCargo() {
		return lstCargo;
	}

	public void setLstCargo(List<Cargo> lstCargo) {
		this.lstCargo = lstCargo;
	}

	public List<Area> getLstArea() {
		return lstArea;
	}

	public void setLstArea(List<Area> lstArea) {
		this.lstArea = lstArea;
	}

}
