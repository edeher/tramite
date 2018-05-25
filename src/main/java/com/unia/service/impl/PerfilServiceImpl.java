package com.unia.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.inject.Named;

import com.unia.dao.IPerfilDAO;
import com.unia.model.Perfil;
import com.unia.service.IPerfilService;


@Named
public class PerfilServiceImpl implements IPerfilService, Serializable{

	@EJB
	private IPerfilDAO dao;
	
	@Override
	public void registrar(Perfil t) throws Exception {
		dao.registrar(t);
		
	}

	@Override
	public void modificar(Perfil t) throws Exception {
		dao.modificar(t);
		
	}

	@Override
	public List<Perfil> listar() throws Exception {
		// TODO Auto-generated method stub
		return dao.listar();
	}

	@Override
	public Perfil listaPorId(Perfil t) throws Exception {
		// TODO Auto-generated method stub
		return dao.listaPorId(t);
	}

}
