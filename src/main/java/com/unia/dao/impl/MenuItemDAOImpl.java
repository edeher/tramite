package com.unia.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.unia.dao.IMenuItemDAO;
import com.unia.model.Menu;
import com.unia.model.MenuItem;

@Stateless
public class MenuItemDAOImpl implements IMenuItemDAO, Serializable{

	@PersistenceContext(unitName="Tramite2PU")
	private EntityManager em;
	
	@Override
	public void registrar(MenuItem me) throws Exception {
		em.persist(me);
		
	}

	@Override
	public void modificar(MenuItem me) throws Exception {
		em.merge(me);
		
	}

	@Override
	public List<MenuItem> listar() throws Exception {
		List<MenuItem> lista=new ArrayList<>();
		
		Query q= em.createQuery("FROM MenuItem m");
		lista=(List<MenuItem>)q.getResultList();
		
		return lista;
	}

	@Override
	public MenuItem listaPorId(MenuItem me) throws Exception {
     List<MenuItem> lista=new ArrayList<>();
		
		Query q= em.createQuery("FROM MenuItem m where m.idMenuItem=?1");
		q.setParameter(1, me.getIdMenuItem());
		lista=(List<MenuItem>)q.getResultList();
		
		MenuItem menuitem=lista!=null && !lista.isEmpty() ?lista.get(0):new MenuItem();
		
		return menuitem;
	}

}
