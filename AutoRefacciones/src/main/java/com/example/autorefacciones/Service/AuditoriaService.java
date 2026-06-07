package com.example.autorefacciones.Service;

import com.example.autorefacciones.Entity.ServidorLocal;
import com.example.autorefacciones.Entity.Sucursal;
import com.example.autorefacciones.Interfaces.NormativaISO;
import org.springframework.stereotype.Service;

@Service
public class AuditoriaService {

    public void ejecutarAuditoria(Sucursal sucursal){

        sucursal.getServidorLocal().generarReporteEstado();
        sucursal.getServidorLocal().calibrar();
    }
}
