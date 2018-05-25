package com.unia.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.unia.dao.IUsuarioDAO;
import com.unia.model.Persona;
import com.unia.model.Usuario;

@Stateless
public class UsuarioDAOImpl implements IUsuarioDAO, Serializable{

	@PersistenceContext(unitName="Tramite2PU")
	private EntityManager em;
	
	@Override
	public void registrar(Usuario t) throws Exception {
		em.persist(t);
		
		
	}

	@Override
	public void modificar(Usuario t) throws Exception {
		em.merge(t);
		
	}

	@Override
	public List<Usuario> listar() throws Exception {
			List<Usuario> lista=new ArrayList<>();
		
		Query q= em.createQuery("FROM Usuario p");
		lista=(List<Usuario>)q.getResultList();
		
		return lista;
	}

	@Override
	public Usuario listaPorId(Usuario t) throws Exception {
			List<Usuario> lista=new ArrayList<>();
		
		Query q= em.createQuery("FROM Usuario p where p.idUsuario=?1");
		q.setParameter(1, t.getIdUsuario());
		lista=(List<Usuario>)q.getResultList();
		
		Usuario per=lista!=null && !lista.isEmpty() ?lista.get(0):new Usuario();
		
		return per;
	}

	@Override
	public synchronized int getSiguientePK(Persona persona) {
		int siguiente =0;
		List <Usuario> lista =new ArrayList<>();
		Query query=em.createQuery("FROM Usuario u where u.persona.idPersona=?1");
		query.setParameter(1, persona.getIdPersona());
		
		lista =(List<Usuario>) query.getResultList();
		
		if(lista!= null && !lista.isEmpty()) {
			siguiente =lista.get(0).getIdUsuario() +1 ;
			
		}else {
			siguiente =1;
		}
		return siguiente;
	}

}
