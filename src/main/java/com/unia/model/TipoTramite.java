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
@Table(name="tipotramite")
public class TipoTramite implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTipoTramite;
	
	@Column(name="descripcion", length=100, nullable=false)
	private String descripcion;
	
	@Column(name="cantMovimientos", nullable=false)
	private int cantMovimiento;
	
	@OneToMany(mappedBy = "tipotramite", cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REMOVE }, fetch = FetchType.LAZY, orphanRemoval = true)
	private List<ItemTipoTramite> itemTipoTramite;

	public int getIdTipoTramite() {
		return idTipoTramite;
	}

	public void setIdTipoTramite(int idTipoTramite) {
		this.idTipoTramite = idTipoTramite;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getCantMovimiento() {
		return cantMovimiento;
	}

	public void setCantMovimiento(int cantMovimiento) {
		this.cantMovimiento = cantMovimiento;
	}

	public List<ItemTipoTramite> getItemTipoTramite() {
		return itemTipoTramite;
	}

	public void setItemTipoTramite(List<ItemTipoTramite> itemTipoTramite) {
		this.itemTipoTramite = itemTipoTramite;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idTipoTramite;
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
		TipoTramite other = (TipoTramite) obj;
		if (idTipoTramite != other.idTipoTramite)
			return false;
		return true;
	}
	
	
	
	

}
