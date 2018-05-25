package com.unia.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.unia.dao.IPersonaDAO;
import com.unia.model.Persona;


@Stateless
public class PersonaDAOImpl implements IPersonaDAO, Serializable{
	
	@PersistenceContext(unitName="Tramite2PU")
	private EntityManager em;
	
	
	@Override
	public void registrar(Persona per) throws Exception {
		
			em.persist(per);
			
		}

	@Override
	public void modificar(Persona per) throws Exception {
		em.merge(per);
		
	}

	@Override
	public List<Persona> listar() throws Exception {
		List<Persona> lista=new ArrayList<>();
		
		Query q= em.createQuery("FROM Persona p");
		lista=(List<Persona>)q.getResultList();
		
		return lista;
	}

	@Override
	public Persona listaPorId(Persona P) throws Exception {
			List<Persona> lista=new ArrayList<>();
		
		Query q= em.createQuery("FROM Persona p where p.idPersona=?1");
		q.setParameter(1, P.getIdPersona());
		lista=(List<Persona>)q.getResultList();
		
		Persona per=lista!=null && !lista.isEmpty() ?lista.get(0):new Persona();
		
		return per;
	}

}
