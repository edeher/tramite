package com.unia.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.unia.dao.IItemTipoTramiteDAO;
import com.unia.model.Area;
import com.unia.model.ItemTipoTramite;
import com.unia.model.Menu;
import com.unia.model.TipoTramite;
@Stateless
public class ItemTipoTramiteDAOImpl implements IItemTipoTramiteDAO, Serializable{

	@PersistenceContext(unitName="Tramite2PU")
	private EntityManager em;
	
	@Override
	public void registrar(ItemTipoTramite itemtipotramite) throws Exception {
		em.persist(itemtipotramite);
		
	}

	@Override
	public void modificar(ItemTipoTramite itemtipotramite) throws Exception {
		em.merge(itemtipotramite);
		
	}

	@Override
	public List<ItemTipoTramite> listar() throws Exception {
      List<ItemTipoTramite> lista=new ArrayList<>();
		
		Query q= em.createQuery("FROM ItemTipoTramite m");
		lista=(List<ItemTipoTramite>)q.getResultList();
		
		return lista;
	}

	@Override
	public ItemTipoTramite listaPorId(ItemTipoTramite i) throws Exception {
		
		List<ItemTipoTramite> lista=new ArrayList<>();
		
		Query q= em.createQuery("FROM ItemTipoTramite m where m.idItemTipoTramite=?1");
		q.setParameter(1, i.getIdItemTipoTramite());
		lista=(List<ItemTipoTramite>)q.getResultList();
		
		ItemTipoTramite itemtipotramite   =  lista     !=null && !lista.isEmpty() ?lista.get(0): new ItemTipoTramite();
		
		return itemtipotramite;
	}

	@Override
	public List<ItemTipoTramite> listarPorArea(Area a) throws Exception {
		
		List<ItemTipoTramite> lista=null;
		
		Query q= em.createQuery("FROM ItemTipoTramite m where m.area.idArea=?1");
		q.setParameter(1, a.getIdArea());
		
		lista=(List<ItemTipoTramite>)q.getResultList();
		
				
		return lista;
	}

	@Override
	public List<ItemTipoTramite> listarPorTipoTramite(TipoTramite tipotra) throws Exception {
			List<ItemTipoTramite> lista=null;
		
		Query q= em.createQuery("FROM ItemTipoTramite m where m.tipotramite.idTipoTramite=?1");
		q.setParameter(1, tipotra.getIdTipoTramite());
		
		lista=(List<ItemTipoTramite>)q.getResultList();
		
				
		return lista;
	}

}
