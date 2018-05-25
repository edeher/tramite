package com.unia.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.unia.dao.IMenuDAO;
import com.unia.model.Menu;


@Stateless
public class MenuDAOImpl implements IMenuDAO, Serializable{

	@PersistenceContext(unitName="Tramite2PU")
	private EntityManager em;
	
	
	@Override
	public void registrar(Menu menu) throws Exception {
		em.persist(menu);
		
	}

	@Override
	public void modificar(Menu menu) throws Exception {
		em.merge(menu);
		
	}

	@Override
	public List<Menu> listar() throws Exception {
		List<Menu> lista=new ArrayList<>();
		
		Query q= em.createQuery("FROM Menu m");
		lista=(List<Menu>)q.getResultList();
		
		return lista;
	}

	@Override
	public Menu listaPorId(Menu m) throws Exception {
       List<Menu> lista=new ArrayList<>();
		
		Query q= em.createQuery("FROM Menu m where m.idMenu=?1");
		q.setParameter(1, m.getIdMenu());
		lista=(List<Menu>)q.getResultList();
		
		Menu menu=lista!=null && !lista.isEmpty() ?lista.get(0):new Menu();
		
		return menu;
	}

}
