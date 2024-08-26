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
		Disco discoGuardado = discoRepositorio.save(disco);
		return DiscoMapper.mapToDiscoDto(discoGuardado);
	}

	@Override
	public DiscoDto consultaDiscoPorId(Long discoId) {
		Disco disco = discoRepositorio.findById(discoId)
						.orElseThrow(() -> new RecursoNoEncontrado("El disco no existe" + discoId));
		return DiscoMapper.mapToDiscoDto(disco);
	}

	@Override
	public List<DiscoDto> consultaTodosDiscos() {
			List<Disco> discos = discoRepositorio.findAll();
		return discos.stream().
					  map((disco) -> DiscoMapper.mapToDiscoDto(disco)).
					  collect(Collectors.toList());
	}

}



















