package com.unia.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.inject.Named;

import com.unia.dao.IMenuDAO;
import com.unia.model.Menu;
import com.unia.service.IMenuService;

@Named
public class MenuServiceImpl implements IMenuService, Serializable{
	
	@EJB
	private IMenuDAO dao;
	
	@Override
	public void registrar(Menu menu) throws Exception {
		dao.registrar(menu);
		
	}

	@Override
	public void modificar(Menu menu) throws Exception {
		dao.modificar(menu);
		
	}

	@Override
	public List<Menu> listar() throws Exception {
		// TODO Auto-generated method stub
		return dao.listar();
	}

	@Override
	public Menu listaPorId(Menu menu) throws Exception {
		// TODO Auto-generated method stub
		return dao.listaPorId(menu);
	}

}
