package com.miguel.distibuteddatabases.repository.persona;

import com.miguel.distibuteddatabases.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaDao extends JpaRepository<Persona, Long> {
}
