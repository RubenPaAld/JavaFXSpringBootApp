package com.codetreatise.repository;

import com.codetreatise.bean.Destino;
import com.codetreatise.bean.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DestinoRepository extends JpaRepository<Destino, Integer> {

}
