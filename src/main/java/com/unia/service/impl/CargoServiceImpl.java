package com.unia.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.inject.Named;

import com.unia.dao.ICargoDAO;
import com.unia.model.Area;
import com.unia.model.Cargo;
import com.unia.service.ICargoService;

@Named
public class CargoServiceImpl implements ICargoService, Serializable {

	@EJB
	private ICargoDAO dao;
	
	@Override
	public void registrar(Cargo t) throws Exception {
		dao.registrar(t);
		
	}

	@Override
	public void modificar(Cargo t) throws Exception {
		dao.modificar(t);
		
	}

	@Override
	public List<Cargo> listar() throws Exception {
		// TODO Auto-generated method stub
		return dao.listar();
	}

	@Override
	public Cargo listaPorId(Cargo t) throws Exception {
		// TODO Auto-generated method stub
		return dao.listaPorId(t);
	}

	@Override
	public List<Cargo> listarPorArea(Area a) throws Exception {
		// TODO Auto-generated method stub
		return dao.listarPorArea(a);
	}

}
