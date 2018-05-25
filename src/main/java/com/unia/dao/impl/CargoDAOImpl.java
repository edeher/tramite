package com.unia.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.unia.dao.ICargoDAO;
import com.unia.model.Area;
import com.unia.model.Cargo;




@Stateless
public class CargoDAOImpl implements ICargoDAO, Serializable{

	@PersistenceContext(unitName="Tramite2PU")
	private EntityManager em;
	
	@Override
	public void registrar(Cargo t) throws Exception {
		em.persist(t);
		
	}

	@Override
	public void modificar(Cargo t) throws Exception {
		em.merge(t);
		
	}

	@Override
	public List<Cargo> listar() throws Exception {
		 List<Cargo> lista=new ArrayList<>();
			
			Query q= em.createQuery("FROM Cargo m");
			lista=(List<Cargo>)q.getResultList();
			
			return lista;
	}

	@Override
	public Cargo listaPorId(Cargo t) throws Exception {
		List<Cargo> lista=new ArrayList<>();
		
		Query q= em.createQuery("FROM Cargo m where m.idCargo=?1");
		q.setParameter(1, t.getIdCargo());
		lista=(List<Cargo>)q.getResultList();
		
		Cargo cargo  =  lista     !=null && !lista.isEmpty() ?lista.get(0): new Cargo();
		
		return cargo;
	}

	@Override
	public List<Cargo> listarPorArea(Area a) throws Exception {
		List<Cargo> lista=null;
		
		Query q= em.createQuery("FROM Cargo m where m.area.idArea=?1");
		q.setParameter(1, a.getIdArea());
		
		lista=(List<Cargo>)q.getResultList();
		
				
		return lista;
	}

}
