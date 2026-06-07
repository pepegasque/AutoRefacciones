package com.example.autorefacciones.Repository;

import com.example.autorefacciones.Entity.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendedorRepository extends JpaRepository<Vendedor,Long> {
}
