package com.codetreatise.repository;

import com.codetreatise.bean.Entrega;
import com.codetreatise.bean.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntregaRepository extends JpaRepository<Entrega, Integer> {

}
