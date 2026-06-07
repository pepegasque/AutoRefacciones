package com.example.autorefacciones.Repository;

import com.example.autorefacciones.Entity.Refaccion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RefaccionRepository extends JpaRepository <Refaccion,Long> {
}
