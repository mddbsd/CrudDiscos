package net.cfl.crudDiscos.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import net.cfl.crudDiscos.entidad.Disco;
/*
 * Esta interfaz implementa los metodos del JpaRepository para tareas de CRUD
 * */
public interface DiscoRepositorio extends JpaRepository<Disco, Long>{

}
