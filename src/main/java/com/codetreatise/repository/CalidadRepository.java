package com.codetreatise.repository;

import com.codetreatise.bean.Calidad;
import com.codetreatise.bean.Campana;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalidadRepository extends JpaRepository<Calidad, Integer> {

}
