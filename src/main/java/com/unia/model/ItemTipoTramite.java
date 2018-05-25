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
@Table(name="itemtipotramite")
public class ItemTipoTramite implements Serializable{

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idItemTipoTramite;
	
	@ManyToOne
	@JoinColumn(name = "idArea", nullable = false)
	private Area area;
	
	@ManyToOne
	@JoinColumn(name = "idTipoTramite", nullable = false)
	private TipoTramite tipotramite;
	
	@Column(name="item", nullable=false)
	private int item;
	
	@Column(name="plazo", nullable=false)
	private int plazo;

	public int getIdItemTipoTramite() {
		return idItemTipoTramite;
	}

	public void setIdItemTipoTramite(int idItemTipoTramite) {
		this.idItemTipoTramite = idItemTipoTramite;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public int getItem() {
		return item;
	}

	public void setItem(int item) {
		this.item = item;
	}

	public int getPlazo() {
		return plazo;
	}

	public void setPlazo(int plazo) {
		this.plazo = plazo;
	}
	

	

	public TipoTramite getTipotramite() {
		return tipotramite;
	}

	public void setTipotramite(TipoTramite tipotramite) {
		this.tipotramite = tipotramite;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idItemTipoTramite;
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
		ItemTipoTramite other = (ItemTipoTramite) obj;
		if (idItemTipoTramite != other.idItemTipoTramite)
			return false;
		return true;
	}
	
	
}
