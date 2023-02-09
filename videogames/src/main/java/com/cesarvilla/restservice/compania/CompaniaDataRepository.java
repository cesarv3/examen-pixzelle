package com.cesarvilla.restservice.compania;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface CompaniaDataRepository extends JpaRepository<CompaniaData,Integer>{

}
