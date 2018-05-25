package com.unia.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.inject.Named;

import com.unia.dao.IPersonaDAO;
import com.unia.model.Persona;
import com.unia.service.IPersonaService;

@Named
public class PersonaServiceImpl implements IPersonaService, Serializable{
	
	@EJB
	private IPersonaDAO dao;
		
	@Override
	public void registrar(Persona per) throws Exception {
		dao.registrar(per);
		
	}

	@Override
	public void modificar(Persona per) throws Exception {
		dao.modificar(per);
		
	}

	@Override
	public List<Persona> listar() throws Exception {
		return dao.listar();
	}

	@Override
	public Persona listaPorId(Persona per) throws Exception {
		// TODO Auto-generated method stub
		return dao.listaPorId(per);
	}

}
