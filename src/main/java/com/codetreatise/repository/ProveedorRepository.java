package com.codetreatise.repository;

import com.codetreatise.bean.Destino;
import com.codetreatise.bean.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, Integer> {

}
