package com.codetreatise.repository;

import com.codetreatise.bean.Cadena;
import com.codetreatise.bean.TipoEstadoEntrega;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoEstadoEntregaRepository extends JpaRepository<TipoEstadoEntrega, Integer> {

}
