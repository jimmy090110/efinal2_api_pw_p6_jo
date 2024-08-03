package com.uce.edu.ec.api.service;

import java.util.List;


import com.uce.edu.ec.api.service.to.VehiculoTO;

public interface IVehiculoService {
	public void guardar(VehiculoTO vehiculoTO);
	public void borrar(String placa);
	public VehiculoTO obtener(String placa);
	
	public  List<VehiculoTO> obtenerTodos();

}
