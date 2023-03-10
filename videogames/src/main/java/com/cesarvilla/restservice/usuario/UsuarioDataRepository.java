package com.cesarvilla.restservice.usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UsuarioDataRepository extends JpaRepository<UsuarioData, Integer>{

}
