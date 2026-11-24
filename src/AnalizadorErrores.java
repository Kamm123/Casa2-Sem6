public class AnalizadorErrores {
    private ErrorSoftware[] errores;

    public AnalizadorErrores(ErrorSoftware[] errores) {
        this.errores = errores;
    }

    public int contarPendientes() {
        if (errores == null) {
            return 0;
        }
        int contador = 0;
        for (int i = 0; i < errores.length; i++) {
            if (errores[i] != null && !errores[i].isResuelto()) {
                contador++;
            }
        }
        return contador;
    }

    public ErrorSoftware buscarPorCodigo(String codigo) {
        if (errores == null || codigo == null) {
            return null;
        }
        for (int i = 0; i < errores.length; i++) {
            if (errores[i] != null && errores[i].getCodigo().equals(codigo)) {
                return errores[i];
            }
        }
        return null;
    }

    public String listarPorSeveridad(String severidad) {
        if (errores == null || severidad == null) {
            return "";
        }
        String listado = "";
        for (int i = 0; i < errores.length; i++) {
            if (errores[i] != null && errores[i].getSeveridad().equals(severidad)) {
                listado += errores[i].mostrarInformacion() + "\n";
            }
        }
        return listado;
    }

    public int contarPorSeveridad(String severidad) {
        if (errores == null || severidad == null) {
            return 0;
        }
        int contador = 0;
        for (int i = 0; i < errores.length; i++) {
            if (errores[i] != null && errores[i].getSeveridad().equals(severidad)) {
                contador++;
            }
        }
        return contador;
    }

    // DESAFÍO: Primer error pendiente de severidad ALTA
    public ErrorSoftware obtenerPrimerPendienteAlta() {
        if (errores == null) {
            return null;
        }
        for (int i = 0; i < errores.length; i++) {
            if (errores[i] != null && !errores[i].isResuelto() && errores[i].getSeveridad().equals("ALTA")) {
                return errores[i];
            }
        }
        return null;
    }
}