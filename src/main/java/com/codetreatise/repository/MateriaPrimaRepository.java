package com.codetreatise.repository;

import com.codetreatise.bean.MateriaPrima;
import com.codetreatise.bean.TipoTransporte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MateriaPrimaRepository extends JpaRepository<MateriaPrima, Integer> {

}
