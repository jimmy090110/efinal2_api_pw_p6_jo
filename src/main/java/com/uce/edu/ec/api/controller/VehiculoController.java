package com.uce.edu.ec.api.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.uce.edu.ec.api.service.IVehiculoService;
import com.uce.edu.ec.api.service.to.VehiculoTO;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


import java.util.List;


@RestController
@CrossOrigin
@RequestMapping(path = "/vehiculos")
public class VehiculoController {
	
	
	@Autowired
	private IVehiculoService vehiculoService;
	
	
	//http://localhost:8080/API/v1.0/Consesionario/vehiculos
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<VehiculoTO> guardar(@RequestBody VehiculoTO vehiculoTO ){
		this.vehiculoService.guardar(vehiculoTO);
		return ResponseEntity.ok().body(vehiculoTO);
		
	}
	
	//http://localhost:8080/API/v1.0/Consesionario/vehiculos/buscar/AB123
	@GetMapping(path = "/buscar/{placa}", produces =MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<VehiculoTO>obtener(@PathVariable String placa){
		 VehiculoTO vehiculoTO = this.vehiculoService.obtener(placa);
		return ResponseEntity.ok().body(vehiculoTO);
	}
	
	
	//http://localhost:8080/API/v1.0/Consesionario/vehiculos
	@GetMapping(produces =MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<List<VehiculoTO>>obtenerTodos(){
		List<VehiculoTO> vehiculolista= this.vehiculoService.obtenerTodos();
		for (VehiculoTO v : vehiculolista) {
			Link myLink = linkTo(methodOn(VehiculoController.class).obtener(v.getPlaca())).withRel("Vehiculos");
			v.add(myLink);
		}
		return ResponseEntity.ok().body(vehiculolista);
	}
	
	
	//http://localhost:8080/API/v1.0/Consesionario/vehiculos/AB123
	@DeleteMapping(path = "/{placa}")
	public ResponseEntity<Void> borrar(@PathVariable String placa){
		this.vehiculoService.borrar(placa);
		return ResponseEntity.ok().body(null);
		
	}
	
	
	
	
	
 
}
