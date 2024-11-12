
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
            nodo = new Nodo(nombre, edad, sexo);
            return nodo;
        }
        if (edad < nodo.edad) {
            nodo.izquierda = insertarRecursivo(nodo.izquierda, nombre, edad, sexo);
        } else if (edad >= nodo.edad) {
            nodo.derecha = insertarRecursivo(nodo.derecha, nombre, edad, sexo);
        }
        return nodo;
    }
}
