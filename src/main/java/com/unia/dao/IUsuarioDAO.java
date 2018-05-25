package com.unia.dao;

import javax.ejb.Local;

import com.unia.model.Persona;
import com.unia.model.Usuario;

@Local
public interface IUsuarioDAO extends IDAO<Usuario> {
	
	int getSiguientePK(Persona persona);
}
