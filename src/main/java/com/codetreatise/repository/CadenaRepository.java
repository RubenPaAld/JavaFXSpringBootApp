package com.codetreatise.repository;

import com.codetreatise.bean.Cadena;
import com.codetreatise.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CadenaRepository extends JpaRepository<Cadena, Integer> {

}
