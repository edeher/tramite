package com.unia.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.inject.Named;

import com.unia.dao.IUsuarioDAO;
import com.unia.model.Persona;
import com.unia.model.Usuario;
import com.unia.service.IUsuarioService;

@Named
public class UsuarioServiceImpl implements IUsuarioService, Serializable{

	@EJB
	private IUsuarioDAO dao;
	
	@Override
	public void registrar(Usuario t) throws Exception {
		dao.registrar(t);
		
	}

	@Override
	public void modificar(Usuario t) throws Exception {
		dao.modificar(t);
		
	}

	@Override
	public List<Usuario> listar() throws Exception {
		// TODO Auto-generated method stub
		return dao.listar();
	}

	@Override
	public Usuario listaPorId(Usuario t) throws Exception {
		// TODO Auto-generated method stub
		return dao.listaPorId(t);
	}

	@Override
	public int getSiguientePK(Persona persona) {
		// TODO Auto-generated method stub
		return dao.getSiguientePK(persona);
	}
	

}
