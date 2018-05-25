package com.unia.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Embeddable
public class UsuarioPK implements Serializable{
	
	private int idUsuario;
	
	
	@OneToOne
	@JoinColumn(name="idPersona", nullable=false)
	private Persona persona;
	
	@ManyToOne
	@JoinColumn(name="idPerfil", nullable=false)
	private Perfil perfil;
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idUsuario;
		result = prime * result + ((perfil == null) ? 0 : perfil.hashCode());
		result = prime * result + ((persona == null) ? 0 : persona.hashCode());
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
		UsuarioPK other = (UsuarioPK) obj;
		if (idUsuario != other.idUsuario)
			return false;
		if (perfil == null) {
			if (other.perfil != null)
				return false;
		} else if (!perfil.equals(other.perfil))
			return false;
		if (persona == null) {
			if (other.persona != null)
				return false;
		} else if (!persona.equals(other.persona))
			return false;
		return true;
	}
	
	
	
	
	
}
