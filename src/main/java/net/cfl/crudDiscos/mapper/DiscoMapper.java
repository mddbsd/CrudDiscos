package net.cfl.crudDiscos.mapper;

import net.cfl.crudDiscos.dto.DiscoDto;
import net.cfl.crudDiscos.entidad.Disco;

/*
 * Los mappers se encargan de transportar los datos desde
 * la entidad JPA (Disco) hacia nuestros objetos
 * de java (DiscoDto) y viceversa
 * */

public class DiscoMapper {
	public static DiscoDto mapToDiscoDto(Disco disco) {
		return new DiscoDto(
				disco.getId(),
				disco.getTitulo(),
				disco.getArtista(),
				disco.getCod(),
				disco.getDuracion()
		);
	}
	public static Disco mapToDisco(DiscoDto discoDto) {
		return new Disco(
				discoDto.getId(),
				discoDto.getTitulo(),
				discoDto.getArtista(),
				discoDto.getCod(),
				discoDto.getDuracion()
				);
	}
	
	
}
