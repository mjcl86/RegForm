package com.mjcl.RegForm.repositories;

import com.mjcl.RegForm.entities.Nota;
import com.mjcl.RegForm.entities.NotaPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotaRepository extends JpaRepository<Nota, NotaPK> {
}
