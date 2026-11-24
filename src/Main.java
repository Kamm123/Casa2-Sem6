public class Main {
    public static void main(String[] args) {
        ErrorSoftware[] errores = new ErrorSoftware[7];
        errores[0] = new ErrorSoftware("ERR-01", "Caída al iniciar sesión", "ALTA", true);
        errores[1] = new ErrorSoftware("ERR-02", "Error de cálculo en IVA", "ALTA", false);
        errores[2] = new ErrorSoftware("ERR-03", "Botón desalineado en móvil", "BAJA", false);
        errores[3] = new ErrorSoftware("ERR-04", "Lentitud al cargar reporte", "MEDIA", false);
        errores[4] = new ErrorSoftware("ERR-05", "Fallo de conexión BD", "ALTA", false);
        errores[5] = new ErrorSoftware("ERR-06", "Texto con falta ortográfica", "BAJA", true);
        errores[6] = new ErrorSoftware("ERR-07", "Filtro de fecha no limpia", "MEDIA", true);

        AnalizadorErrores analizador = new AnalizadorErrores(errores);

        System.out.println("Errores pendientes: " + analizador.contarPendientes());
        System.out.println("Cantidad severidad ALTA: " + analizador.contarPorSeveridad("ALTA"));
        System.out.println("\n--- Listado Severidad ALTA ---");
        System.out.println(analizador.listarPorSeveridad("ALTA"));

        ErrorSoftware buscado = analizador.buscarPorCodigo("ERR-04");
        System.out.println("Búsqueda ERR-04: " + (buscado != null ? buscado.mostrarInformacion() : "No encontrado"));

        ErrorSoftware primerAlta = analizador.obtenerPrimerPendienteAlta();
        System.out.println("Primer pendiente ALTA (Desafío): " + (primerAlta != null ? primerAlta.mostrarInformacion() : "Ninguno"));
    }
}