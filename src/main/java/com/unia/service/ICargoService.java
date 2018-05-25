package com.unia.service;

import java.util.List;

import com.unia.model.Area;
import com.unia.model.Cargo;


public interface ICargoService extends IService<Cargo>{
	
	List<Cargo> listarPorArea(Area a)throws Exception;
}
