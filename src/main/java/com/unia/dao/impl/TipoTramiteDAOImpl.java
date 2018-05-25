package com.unia.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.unia.dao.ITipoTramiteDAO;
import com.unia.model.TipoTramite;

@Stateless
public class TipoTramiteDAOImpl implements ITipoTramiteDAO, Serializable{

	@PersistenceContext(unitName="Tramite2PU")
	private EntityManager em;
	
	@Override
	public void registrar(TipoTramite t) throws Exception {
		em.persist(t);
		
	}

	@Override
	public void modificar(TipoTramite t) throws Exception {
		em.merge(t);
		
	}

	@Override
	public List<TipoTramite> listar() throws Exception {
			List<TipoTramite> lista=new ArrayList<>();
		
		Query q= em.createQuery("FROM TipoTramite ti");
		lista=(List<TipoTramite>)q.getResultList();
		
		return lista;
	}

	@Override
	public TipoTramite listaPorId(TipoTramite t) throws Exception {
		  List<TipoTramite> lista=new ArrayList<>();
			
			Query q= em.createQuery("FROM TipoTramite t where t.idTipoTramite=?1");
			q.setParameter(1, t.getIdTipoTramite());
			lista=(List<TipoTramite>)q.getResultList();
			
			TipoTramite tipotra=lista!=null && !lista.isEmpty() ?lista.get(0):new TipoTramite();
			
			return tipotra;
	}

}
