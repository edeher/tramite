package com.unia.service;

import com.unia.model.Persona;
import com.unia.model.Usuario;

public interface IUsuarioService extends IService<Usuario>{
	int getSiguientePK(Persona persona);
}
