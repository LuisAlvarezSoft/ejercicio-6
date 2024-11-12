class Nodo {
    String nombre;
    int edad;
    String sexo; // "M" para masculino, "F" para femenino
    Nodo izquierda;
    Nodo derecha;

    public Nodo(String nombre, int edad, String sexo) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.izquierda = null;
        this.derecha = null;
    }
}
