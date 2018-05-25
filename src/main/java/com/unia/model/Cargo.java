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
@Table(name="cargo")
public class Cargo implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCargo;
	
	@Column(name="nombre", length=30, nullable=false)
	private String nombre;
	
	@ManyToOne
	@JoinColumn(name = "idArea", nullable = false)
	private Area area;
	
		
	@Column(name="jefearea",columnDefinition="char(1)", nullable=false)
	private String jefearea;


	public int getIdCargo() {
		return idCargo;
	}


	public void setIdCargo(int idCargo) {
		this.idCargo = idCargo;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Area getArea() {
		return area;
	}


	public void setArea(Area area) {
		this.area = area;
	}


	public String getJefearea() {
		return jefearea;
	}


	public void setJefearea(String jefearea) {
		this.jefearea = jefearea;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idCargo;
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
		Cargo other = (Cargo) obj;
		if (idCargo != other.idCargo)
			return false;
		return true;
	}
	
	
	
	
}
