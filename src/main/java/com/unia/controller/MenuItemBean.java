package com.unia.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.unia.model.Menu;
import com.unia.model.MenuItem;
import com.unia.service.IMenuItemService;

@Named
@ViewScoped
public class MenuItemBean implements Serializable{
	
	@Inject
	private MenuItem menuItem;
	private List<MenuItem> lstMenuItems;
	
	@Inject
	private IMenuItemService service;
	
	private String titulo;
	
	@PostConstruct
	private void init() {
		this.listar();
	}

	public void listar() {
		
		try {
			lstMenuItems=service.listar();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void seleccionar(MenuItem menuitem) {
		try {
			this.menuItem=service.listaPorId(menuitem);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.titulo="Modificar";
		}
		
	}

	public MenuItem getMenuItem() {
		return menuItem;
	}

	public void setMenuItem(MenuItem menuItem) {
		this.menuItem = menuItem;
	}

	public List<MenuItem> getLstMenuItems() {
		return lstMenuItems;
	}

	public void setLstMenuItems(List<MenuItem> lstMenuItems) {
		this.lstMenuItems = lstMenuItems;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	
	
	
}
