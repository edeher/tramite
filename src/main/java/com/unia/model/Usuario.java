package com.unia.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@IdClass(UsuarioPK.class)
@Table(name="usuario")
public class Usuario implements Serializable{
	
	@Id
	private int idUsuario;
	
	@Id
	private Persona persona;
	
	@Id
	private Perfil perfil;
	
	@Column(name="username", length=30, nullable=false)
	private String username;
	
	@Column(name="password", length=30, nullable=false)
	private String password;
		
	@Column(name="estado",columnDefinition="char(1)", nullable=false)
	private String estado="1";

	

	

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	
	
	

}
