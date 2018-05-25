package com.unia.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.unia.dao.IPerfilDAO;
import com.unia.model.Perfil;
import com.unia.model.Persona;

@Stateless
public class PerfilDAOImpl implements IPerfilDAO, Serializable{
	
	@PersistenceContext(unitName="Tramite2PU")
	private EntityManager em;

	@Override
	public void registrar(Perfil perfil) throws Exception {
		em.persist(perfil);
		
	}

	@Override
	public void modificar(Perfil perfil) throws Exception {
		em.merge(perfil);
		
	}

	@Override
	public List<Perfil> listar() throws Exception {
			List<Perfil> lista=new ArrayList<>();
		
		Query q= em.createQuery("FROM Perfil p");
		lista=(List<Perfil>)q.getResultList();
		
		return lista;
	}

	@Override
	public Perfil listaPorId(Perfil perfil) throws Exception {
			List<Perfil> lista=new ArrayList<>();
		
		Query q= em.createQuery("FROM Perfil p where p.idPerfil=?1");
		q.setParameter(1, perfil.getIdPerfil());
		lista=(List<Perfil>)q.getResultList();
		
		Perfil per=lista!=null && !lista.isEmpty() ?lista.get(0):new Perfil();
		
		return per;
	}

}
