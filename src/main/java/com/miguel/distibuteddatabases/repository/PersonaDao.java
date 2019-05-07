package com.miguel.distibuteddatabases.repository;

import com.miguel.distibuteddatabases.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository                                                                                                                 //REVISAR
public interface PersonaDao extends JpaRepository<Persona, Long> {
}
