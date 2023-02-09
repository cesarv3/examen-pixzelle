package com.cesarvilla.restservice.consola;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ConsolaDataRepository extends JpaRepository<ConsolaData,Integer>{

}
