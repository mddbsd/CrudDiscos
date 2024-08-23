package net.cfl.crudDiscos.servicios.impl;

import net.cfl.crudDiscos.dto.DiscoDto;
import net.cfl.crudDiscos.entidad.Disco;
import net.cfl.crudDiscos.mapper.DiscoMapper;
import net.cfl.crudDiscos.repositorio.DiscoRepositorio;
import net.cfl.crudDiscos.servicios.DiscoServicio;

public class DiscoServicioImpl implements DiscoServicio {
	
	private DiscoRepositorio discoRepositorio;
	
	@Override
	public DiscoDto crearDisco(DiscoDto discoDto) {
		Disco disco = DiscoMapper.mapToDisco(discoDto);
		Disco discoGuardado = discoRepositorio.save(disco);
		return DiscoMapper.mapToDiscoDto(discoGuardado);
	}

}
