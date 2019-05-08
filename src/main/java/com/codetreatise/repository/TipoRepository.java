package com.codetreatise.repository;

import com.codetreatise.bean.Campana;
import com.codetreatise.bean.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoRepository extends JpaRepository<Tipo, Integer> {

}
