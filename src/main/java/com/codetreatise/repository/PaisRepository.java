package com.codetreatise.repository;

import com.codetreatise.bean.Pais;
import com.codetreatise.bean.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Integer> {

}
