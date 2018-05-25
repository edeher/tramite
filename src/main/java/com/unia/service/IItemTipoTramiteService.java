package com.unia.service;

import java.util.List;

import com.unia.model.Area;
import com.unia.model.ItemTipoTramite;
import com.unia.model.TipoTramite;

public interface IItemTipoTramiteService extends IService<ItemTipoTramite>{
	
	List<ItemTipoTramite> listarPorArea(Area a)throws Exception;
	List<ItemTipoTramite> listarTipoTramite(TipoTramite tipotra)throws Exception;
}
