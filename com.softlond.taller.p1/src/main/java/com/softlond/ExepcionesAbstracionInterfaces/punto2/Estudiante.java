package com.softlond.ExepcionesAbstracionInterfaces.punto2;

import java.util.ArrayList;
import java.util.List;

public class Estudiante {
    List<String> materias;

    public Estudiante(List<String> materias) {
        this.materias = materias;
    }

    public List<String> getMaterias() {
        return materias;
    }

    public void setMaterias(List<String> materias) {
        this.materias = materias;
    }
}

