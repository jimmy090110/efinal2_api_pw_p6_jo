package com.uce.edu.ec.api.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.ec.api.repository.modelo.Vehiculo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class VehiculoRepositoryImpl implements IVehiculoRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Vehiculo vehiculo) {
		this.entityManager.persist(vehiculo);
		
	}

	@Override
	public void eliminar(String placa) {
		this.entityManager.remove(this.seleccionar(placa));
		
	}

	@Override
	public Vehiculo seleccionar(String placa) {
		TypedQuery<Vehiculo> myQuery = this.entityManager.createQuery("SELECT v FROM Vehiculo v WHERE v.placa=:placa",Vehiculo.class);
		myQuery.setParameter("placa", placa);
		return myQuery.getSingleResult();
	}

	@Override
	public List<Vehiculo> seleccionarTodos() {
		TypedQuery<Vehiculo> myQuery = this.entityManager.createQuery("SELECT v FROM Vehiculo v",Vehiculo.class);
		return myQuery.getResultList();
	}

}
