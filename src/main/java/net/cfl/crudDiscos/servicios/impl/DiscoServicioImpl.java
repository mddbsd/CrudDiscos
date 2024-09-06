package net.cfl.crudDiscos.servicios.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import net.cfl.crudDiscos.dto.DiscoDto;
import net.cfl.crudDiscos.entidad.Disco;
import net.cfl.crudDiscos.excepciones.RecursoNoEncontrado;
import net.cfl.crudDiscos.mapper.DiscoMapper;
import net.cfl.crudDiscos.repositorio.DiscoRepositorio;
import net.cfl.crudDiscos.servicios.DiscoServicio;

@Service
@AllArgsConstructor
public class DiscoServicioImpl implements DiscoServicio {
	
	private DiscoRepositorio discoRepositorio;
	
	@Override
	public DiscoDto crearDisco(DiscoDto discoDto) {
		Disco disco = DiscoMapper.mapToDisco(discoDto);
		//El metodo .save() de JPA guarda los datos en la base de datos
		Disco discoGuardado = discoRepositorio.save(disco); 
		return DiscoMapper.mapToDiscoDto(discoGuardado);
	}

	@Override
	public DiscoDto consultaDiscoPorId(Long discoId) {
		//El metodo .findById devuelve los datos
		//contenidos en la entidad en donde coincida
		//el id
		Disco disco = discoRepositorio.findById(discoId)
						.orElseThrow(() -> new RecursoNoEncontrado("El disco no existe " + discoId));
		return DiscoMapper.mapToDiscoDto(disco);
	}

	@Override
	public List<DiscoDto> consultaTodosDiscos() {
		//El metodo .findAll devuelve una LISTA de todos los datos contenidos
		//en la base de datos;
			List<Disco> discos = discoRepositorio.findAll();
		return discos.stream().
					  map((disco) -> DiscoMapper.mapToDiscoDto(disco)).
					  collect(Collectors.toList());
	}

	@Override
	public DiscoDto actualizaDisco(Long discoId, DiscoDto discoActualizado) {
		Disco disco = discoRepositorio.findById(discoId)
						.orElseThrow(() -> new RecursoNoEncontrado("El disco no existe " + discoId));
		
		disco.setArtista(discoActualizado.getArtista());
		disco.setTitulo(discoActualizado.getTitulo());
		disco.setDuracion(discoActualizado.getDuracion());
		disco.setCod(discoActualizado.getCod());
		
		Disco discoActualizadoObj = discoRepositorio.save(disco);
		
		
		
		return DiscoMapper.mapToDiscoDto(discoActualizadoObj);
	}

	@Override
	public void borraDisco(Long discoId) {
		Disco disco = discoRepositorio.findById(discoId)
				.orElseThrow(() -> new RecursoNoEncontrado("El disco no existe " + discoId));
		discoRepositorio.deleteById(discoId);
		
	}

}



















