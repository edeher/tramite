package com.unia.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="menu")
public class Menu implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idMenu;
	
	@Column(name="nombre", length=30, nullable=false)
	private String nombre;
	
	@OneToMany(mappedBy = "menu", cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REMOVE }, fetch = FetchType.EAGER, orphanRemoval = true)
	private List<MenuItem> menuitems;
//	
//	@ManyToMany(fetch = FetchType.LAZY, mappedBy ="menus")
//	private List<Perfil> perfiles;
	

	public int getIdMenu() {
		return idMenu;
	}

	public void setIdMenu(int idMenu) {
		this.idMenu = idMenu;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<MenuItem> getMenuitems() {
		return menuitems;
	}

	public void setMenuitems(List<MenuItem> menuitems) {
		this.menuitems = menuitems;
	}
	
	
}
