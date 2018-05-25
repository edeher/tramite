package com.unia.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.inject.Named;

import com.unia.dao.ITipoTramiteDAO;
import com.unia.model.TipoTramite;
import com.unia.service.ITipoTramiteService;

@Named
public class TipoTramiteServiceImpl implements ITipoTramiteService,Serializable{

	@EJB
	private ITipoTramiteDAO dao;
	
	@Override
	public void registrar(TipoTramite t) throws Exception {
		
		dao.registrar(t);
	}

	@Override
	public void modificar(TipoTramite t) throws Exception {
		dao.modificar(t);
		
	}

	@Override
	public List<TipoTramite> listar() throws Exception {
		// TODO Auto-generated method stub
		return dao.listar();
	}

	@Override
	public TipoTramite listaPorId(TipoTramite t) throws Exception {
		// TODO Auto-generated method stub
		return dao.listaPorId(t);
	}

}
