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
import com.unia.service.IMenuService;

@Named
@ViewScoped
public class MenuBean implements Serializable {

	@Inject
	private Menu menu;
	@Inject
	private MenuItem menuItem;
	private List<Menu> lstMenus;
	//private Set<MenuItem> lstMenuItems;
	private List<MenuItem> lstMenuItems;
	
	private String titulo;
	
	

	@Inject
	private IMenuService service;

	@PostConstruct
	public void init() {
		titulo="Nuevo";
		lstMenus=new ArrayList<>();
		//lstMenuItems=new TreeSet<>(); 
		lstMenuItems=new ArrayList<>();
	 
		this.listar();
	}

	public void listar() {
		try {
			
			lstMenus=service.listar();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void seleccionar(Menu menu) {
		try {
			
			this.menu=service.listaPorId(menu);
			this.lstMenuItems=this.getLstMenuItems();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.titulo="Modificar";
		}
		
	}
	public void agregar() {
		MenuItem me= new MenuItem();
		me.setNombre(menuItem.getNombre());
		me.setUrl(menuItem.getUrl());
		me.setMenu(menu);
		this.lstMenuItems.add(me);
	}
	public void remover(MenuItem menuitem) {
		this.lstMenuItems.remove(menuitem);
	}
	
	public void operar() {

		try {
			menu.setMenuitems(this.lstMenuItems);
			if(menu.getIdMenu()>0) {
				service.modificar(menu);
			}else {
				service.registrar(menu);
			}
			
			this.listar();

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	
	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public List<Menu> getLstMenus() {
		return lstMenus;
	}

	public void setLstMenus(List<Menu> lstMenus) {
		this.lstMenus = lstMenus;
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
