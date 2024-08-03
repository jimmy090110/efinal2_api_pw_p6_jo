package com.uce.edu.ec.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.ec.api.repository.IVehiculoRepository;
import com.uce.edu.ec.api.repository.modelo.Vehiculo;
import com.uce.edu.ec.api.service.to.VehiculoTO;



@Service
public class VehiculoServiceImpl implements IVehiculoService {

	@Autowired
	private IVehiculoRepository vehiculoRepository;
	
	@Override
	public void guardar(VehiculoTO vehiculoTO) {
		this.vehiculoRepository.insertar(convertirdos(vehiculoTO));
		
		
	}

	@Override
	public void borrar(String placa) {
		this.vehiculoRepository.eliminar(placa);
		
	}

	@Override
	public VehiculoTO obtener(String placa) {
		
		Vehiculo vehiculo = this.vehiculoRepository.seleccionar(placa);
		
		return convertir(vehiculo);
	}

	@Override
	public List<VehiculoTO> obtenerTodos() {
		
		List<Vehiculo> vehiculos = this.vehiculoRepository.seleccionarTodos();
		List<VehiculoTO> vehiculosTO = new ArrayList<>();
		
		for (Vehiculo v : vehiculos) {
			vehiculosTO.add(convertir(v));
		}
			
		return vehiculosTO;
	}
	
	public VehiculoTO convertir(Vehiculo vehiculo) {
		VehiculoTO vehiculoTO = new VehiculoTO();
		vehiculoTO.setId(vehiculo.getId());
		vehiculoTO.setPlaca(vehiculo.getPlaca());
		vehiculoTO.setMarca(vehiculo.getMarca());
		vehiculoTO.setModelo(vehiculo.getModelo());
		vehiculoTO.setColor(vehiculo.getColor());
		vehiculoTO.setPrecio(vehiculo.getPrecio());
		
		return vehiculoTO;
	}
	
	public Vehiculo convertirdos(VehiculoTO vehiculoTO) {
		
		Vehiculo vehiculo = new Vehiculo();
		vehiculo.setId(vehiculoTO.getId());
		vehiculo.setPlaca(vehiculoTO.getPlaca());
		vehiculo.setMarca(vehiculo.getMarca());
		vehiculo.setModelo(vehiculoTO.getModelo());
		vehiculo.setColor(vehiculoTO.getColor());
		vehiculo.setPrecio(vehiculoTO.getPrecio());
		return vehiculo;
	}

}
