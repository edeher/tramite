package com.unia.dao;

import java.util.List;

import javax.ejb.Local;

import com.unia.model.Area;
import com.unia.model.ItemTipoTramite;
import com.unia.model.TipoTramite;
@Local
public interface IItemTipoTramiteDAO extends IDAO<ItemTipoTramite>{
	
	List<ItemTipoTramite> listarPorArea(Area a)throws Exception;
	
	List<ItemTipoTramite> listarPorTipoTramite(TipoTramite tipotra)throws Exception;
}
