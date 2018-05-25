package com.unia.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.inject.Named;

import com.unia.dao.IAreaDAO;
import com.unia.model.Area;
import com.unia.service.IAreaService;

@Named
public class AreaServiceImpl implements IAreaService, Serializable{
	
	@EJB
	private IAreaDAO dao;

	@Override
	public void registrar(Area area) throws Exception {
		dao.registrar(area);
		
	}

	@Override
	public void modificar(Area area) throws Exception {
		dao.modificar(area);
		
	}

	@Override
	public List<Area> listar() throws Exception {
		// TODO Auto-generated method stub
		return dao.listar();
	}

	@Override
	public Area listaPorId(Area area) throws Exception {
		// TODO Auto-generated method stub
		return dao.listaPorId(area);
	}

	
	
	

}
