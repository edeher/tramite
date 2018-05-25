package com.unia.dao;

import java.util.List;

import javax.ejb.Local;

import com.unia.model.Area;
import com.unia.model.Cargo;


@Local
public interface ICargoDAO extends IDAO<Cargo>{
	
	List<Cargo> listarPorArea(Area a)throws Exception;
}
