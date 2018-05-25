package com.unia.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.inject.Named;

import com.unia.dao.IMenuItemDAO;
import com.unia.model.MenuItem;
import com.unia.service.IMenuItemService;
@Named
public class MenuItemServiceImpl implements IMenuItemService,Serializable {

	@EJB
	private IMenuItemDAO dao;
	
	@Override
	public void registrar(MenuItem me) throws Exception {
		dao.registrar(me);
		
	}

	@Override
	public void modificar(MenuItem me) throws Exception {
		dao.modificar(me);
		
	}

	@Override
	public List<MenuItem> listar() throws Exception {
		// TODO Auto-generated method stub
		return dao.listar();
	}

	@Override
	public MenuItem listaPorId(MenuItem me) throws Exception {
		// TODO Auto-generated method stub
		return dao.listaPorId(me);
	}

}
