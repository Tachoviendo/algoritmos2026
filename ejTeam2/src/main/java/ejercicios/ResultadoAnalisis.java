package ejercicios;

/*
Esta clase existe porque a veces contarPalabras solo no alcanza.
Si querés saber cuántas palabras hay Y cuántas líneas Y el texto original,
no podés devolver todo eso con un solo int. Entonces usamos esta clase como "paquete de resultados".
*/
public class ResultadoAnalisis {
    private String textoOriginal;
    private int cantidadPalabras;
    private int cantidadLineas;

    public ResultadoAnalisis(String textoOriginal, int cantidadPalabras, int cantidadLineas) {
        this.textoOriginal = textoOriginal;
        this.cantidadPalabras = cantidadPalabras;
        this.cantidadLineas = cantidadLineas;
    }

    public String getTextoOriginal() { return textoOriginal; }
    public int getCantidadPalabras() { return cantidadPalabras; }
    public int getCantidadLineas() { return cantidadLineas; }

    @Override
    public String toString() {
        return "ResultadoAnalisis{" +
                "palabras=" + cantidadPalabras +
                ", lineas=" + cantidadLineas +
                ", texto='" + textoOriginal + "'" +
                '}';
    }
}
