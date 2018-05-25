package com.unia.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.unia.dao.IAreaDAO;
import com.unia.model.Area;


@Stateless
public class AreaDAOImpl implements IAreaDAO,Serializable{

	@PersistenceContext(unitName="Tramite2PU")
	private EntityManager em;
	
	@Override
	public void registrar(Area area) throws Exception {
		em.persist(area);
		
	}

	@Override
	public void modificar(Area area) throws Exception {
		em.merge(area);
		
	}

	@Override
	public List<Area> listar() throws Exception {
		List<Area> lista=new ArrayList<>();
		
		Query q= em.createQuery("FROM Area a");
		lista=(List<Area>)q.getResultList();
		
		return lista;
	}

	@Override
	public Area listaPorId(Area a) throws Exception {
        List<Area> lista=new ArrayList<>();
		
		Query q= em.createQuery("FROM Area a where a.idArea=?1");
		q.setParameter(1, a.getIdArea());
		lista=(List<Area>)q.getResultList();
		
		Area area=lista!=null && !lista.isEmpty() ?lista.get(0):new Area();
		
		return area;
	}

}
