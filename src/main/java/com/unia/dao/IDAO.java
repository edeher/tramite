package com.unia.dao;

import java.util.List;

public interface IDAO <T>{
	
	void registrar(T t)throws Exception;
	void modificar (T t)throws Exception;
	List<T> listar()throws Exception;
	T listaPorId(T t) throws Exception;
}
