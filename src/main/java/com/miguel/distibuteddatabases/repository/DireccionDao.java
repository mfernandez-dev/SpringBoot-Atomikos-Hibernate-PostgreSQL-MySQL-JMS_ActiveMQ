package com.miguel.distibuteddatabases.repository;

import com.miguel.distibuteddatabases.model.Direccion;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DireccionDao extends JpaRepository<Direccion,Long> {
}
