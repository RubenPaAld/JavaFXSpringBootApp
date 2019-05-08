package com.codetreatise.repository;

import com.codetreatise.bean.Cadena;
import com.codetreatise.bean.Campana;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampanaRepository extends JpaRepository<Campana, Integer> {

}
