package com.unia.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="menuitem")
public class MenuItem implements Serializable, Comparable<MenuItem>{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idMenuItem;
	
	@ManyToOne
	@JoinColumn(name = "idMenu", nullable = false)
	private Menu menu;
	
	
	@Column(name="nombre", length=30, nullable=false)
	private String nombre;
	
	@Column(name="url", length=30, nullable=false)
	private String url;
	
	
	public int getIdMenuItem() {
		return idMenuItem;
	}
	public void setIdMenuItem(int idMenuItem) {
		this.idMenuItem = idMenuItem;
	}
	public Menu getMenu() {
		return menu;
	}
	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idMenuItem;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MenuItem other = (MenuItem) obj;
		if (idMenuItem != other.idMenuItem)
			return false;
		return true;
	}
	
	@Override
	public int compareTo(MenuItem o) {
		
		return this.getNombre().compareTo(o.getNombre());
	}

}
