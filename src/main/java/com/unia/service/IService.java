package com.unia.service;

import java.util.List;

import com.unia.model.Persona;

public interface IService<T> {
	
	void registrar(T t)throws Exception;
	void modificar (T t)throws Exception;
	List<T> listar()throws Exception;
	T listaPorId(T t) throws Exception;
}
