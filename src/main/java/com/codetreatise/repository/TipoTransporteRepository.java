package com.codetreatise.repository;

import com.codetreatise.bean.TipoMateria;
import com.codetreatise.bean.TipoTransporte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoTransporteRepository extends JpaRepository<TipoTransporte, Integer> {

}
