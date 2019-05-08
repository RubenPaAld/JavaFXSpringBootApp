package com.codetreatise.repository;

import com.codetreatise.bean.Tipo;
import com.codetreatise.bean.TipoMateria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoMateriaRepository extends JpaRepository<TipoMateria, Integer> {

}
