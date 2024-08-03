package com.uce.edu.ec.api.repository;

import java.util.List;

import com.uce.edu.ec.api.repository.modelo.Vehiculo;

public interface IVehiculoRepository {
	
	public void insertar(Vehiculo vehiculo);
	public void eliminar(String placa);
	public Vehiculo seleccionar(String placa);
	
	public  List<Vehiculo> seleccionarTodos();

	
	
}
