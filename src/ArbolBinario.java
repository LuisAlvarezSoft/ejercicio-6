class ArbolBinario {
    Nodo raiz;

    public ArbolBinario() {
        raiz = null;
    }

    public void insertar(String nombre, int edad, String sexo) {
        raiz = insertarRecursivo(raiz, nombre, edad, sexo);
    }

    private Nodo insertarRecursivo(Nodo nodo, String nombre, int edad, String sexo) {
        if (nodo == null) {
            return new Nodo(nombre, edad, sexo);
        }
        if (edad < nodo.edad) {
            nodo.izquierda = insertarRecursivo(nodo.izquierda, nombre, edad, sexo);
        } else {
            nodo.derecha = insertarRecursivo(nodo.derecha, nombre, edad, sexo);
        }
        return nodo;
    }

    public double calcularEdadPromedio() {
        int[] resultado = calcularSumaYConteoEdades(raiz);
        return resultado[1] > 0 ? (double) resultado[0] / resultado[1] : 0;
    }

    private int[] calcularSumaYConteoEdades(Nodo nodo) {
        if (nodo == null) return new int[]{0, 0};
        int[] izquierda = calcularSumaYConteoEdades(nodo.izquierda);
        int[] derecha = calcularSumaYConteoEdades(nodo.derecha);
        int suma = izquierda[0] + derecha[0] + nodo.edad;
        int conteo = izquierda[1] + derecha[1] + 1;
        return new int[]{suma, conteo};
    }

    public String obtenerMenorEdad() {
        Nodo menor = obtenerNodoMenor(raiz);
        return menor != null ? menor.nombre + " (" + menor.edad + " años)" : "Árbol vacío";
    }

    private Nodo obtenerNodoMenor(Nodo nodo) {
        while (nodo != null && nodo.izquierda != null) {
            nodo = nodo.izquierda;
        }
        return nodo;
    }

    public String obtenerMayorEdad() {
        Nodo mayor = obtenerNodoMayor(raiz);
        return mayor != null ? mayor.nombre + " (" + mayor.edad + " años)" : "Árbol vacío";
    }

    private Nodo obtenerNodoMayor(Nodo nodo) {
        while (nodo != null && nodo.derecha != null) {
            nodo = nodo.derecha;
        }
        return nodo;
    }

    public int contarHombres() {
        return contarGenero(raiz, "M");
    }

    public int contarMujeres() {
        return contarGenero(raiz, "F");
    }

    private int contarGenero(Nodo nodo, String genero) {
        if (nodo == null) return 0;
        int cuenta = nodo.sexo.equals(genero) ? 1 : 0;
        return cuenta + contarGenero(nodo.izquierda, genero) + contarGenero(nodo.derecha, genero);
    }

    public int contarMiembros() {
        return contarNodos(raiz);
    }

    private int contarNodos(Nodo nodo) {
        if (nodo == null) return 0;
        return 1 + contarNodos(nodo.izquierda) + contarNodos(nodo.derecha);
    }
}
