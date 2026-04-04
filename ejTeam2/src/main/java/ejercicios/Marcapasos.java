package ejercicios;

public class Marcapasos {
    //Atributos

    public static int contador; //Esto consume 4 bytes pero es estatico, se comparte para todas las clases.
    /*
    byte → 1 byte (−128 a 127)
    short → 2 bytes (−32,768 a 32,767)
    int → 4 bytes (muy grande, suele ser innecesario si el rango es chico)
     */
    private int idDispositivo;
    private short codigoFabricante;
    private byte latidosPorMinuto;
    private byte nivelBateria;

    /*
    Si todo fuera int ocuparía 4 bytes por cada variable, en total 16 bytes.
    Con ests valores, ocupo solamente 8 bytes.
    */

    public void setLatidos(byte latidosPorMinuto){
        this.latidosPorMinuto = latidosPorMinuto;
    }

    public void setNivelBateria(byte nivelBateria){
        this.nivelBateria = nivelBateria;
    }

    public int getIdDispositivo(){
        return this.idDispositivo;
    }

    public short getCodigoFabricante(){
        return this.codigoFabricante;
    }

    public byte getLatidosPorMinuto(){
        return this.latidosPorMinuto;
    }

    public byte getNivelBateria(){
        return this.nivelBateria;
    }

    public static int getCantidadInstancias(){
        return contador;
    }

    /*
    El id de dispositivo y el codigo del fabricante deberían ser unicos y no modificables, por ejemplo, si un paciente muere por un defecto
    en el dispositivo y su codigo de fabricante se podría modificar, las empresas podrían utilizar esto para hacer fraude, en cambio si no es modificable
    se podría investigar sin problema.
     */


    //El toString hace que cuando hagamos System.out.println(Marcapasos) se imprima esto xd
    @Override
    public String toString() {
        return "Marcapasos{" +
                "idDispositivo=" + idDispositivo +
                ", codigoFabricante=" + codigoFabricante +
                ", latidosPorMinuto=" + latidosPorMinuto +
                ", nivelBateria=" + nivelBateria +
                '}';
    }

    @Override
    public boolean equals(Object m){
        if (this==m) return true;
        if (m==null || getClass() != m.getClass()) return false;

        //Cast
        Marcapasos otro = (Marcapasos) m;
        try{
            return (this.idDispositivo == otro.getIdDispositivo()
            ) && (this.codigoFabricante == otro.getCodigoFabricante());
        } catch (Exception e){
            return false;
        }
    }

    @Override
    public int hashCode(){
        return idDispositivo + codigoFabricante;
    }

    public Marcapasos(int id, short codigoFabricante){
        contador++;
        this.idDispositivo = id;
        this.codigoFabricante = codigoFabricante;
    }
}
