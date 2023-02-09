package com.cesarvilla.restservice.videojuego;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository
@Transactional
public interface JuegoDataRepository extends JpaRepository<JuegoData,Integer>{

}
