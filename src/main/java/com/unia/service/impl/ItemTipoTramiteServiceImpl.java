package com.unia.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.inject.Named;

import com.unia.dao.IItemTipoTramiteDAO;
import com.unia.model.Area;
import com.unia.model.ItemTipoTramite;
import com.unia.model.TipoTramite;
import com.unia.service.IItemTipoTramiteService;

@Named
public class ItemTipoTramiteServiceImpl implements IItemTipoTramiteService,  Serializable{

	@EJB
	private IItemTipoTramiteDAO dao;
	
	@Override
	public void registrar(ItemTipoTramite t) throws Exception {
		dao.registrar(t);
		
	}

	@Override
	public void modificar(ItemTipoTramite t) throws Exception {
		dao.modificar(t);
		
	}

	@Override
	public List<ItemTipoTramite> listar() throws Exception {
		// TODO Auto-generated method stub
		return dao.listar();
	}

	@Override
	public ItemTipoTramite listaPorId(ItemTipoTramite t) throws Exception {
		// TODO Auto-generated method stub
		return dao.listaPorId(t);
	}

	@Override
	public List<ItemTipoTramite> listarPorArea(Area a) throws Exception {
		// TODO Auto-generated method stub
		return dao.listarPorArea(a);
	}

	@Override
	public List<ItemTipoTramite> listarTipoTramite(TipoTramite tipotra) throws Exception {
		// TODO Auto-generated method stub
		return dao.listarPorTipoTramite(tipotra);
	}

}
