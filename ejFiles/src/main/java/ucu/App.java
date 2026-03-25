package ucu;
import java.util.Scanner;
import ucu.ejercicios;
public class App {

    
    public static void main(String[] args) {
          ejercicios ejs= new ejercicios();
          Scanner e = new Scanner(System.in);

          System.out.println("Qué ejercicio desea realizar? [1 al 20]");

          int eleccion = e.nextInt();
          switch (eleccion) {
              case 1:
                  ejercicios.crearArchivo();
                  break;

              case 2:
                  ejercicios.leerArchivo("saludo.txt");
                  break;
            /*
              case 3:
                  ejs.ej3();
                  break;
            
              case 4:
                  ejs.ej4();
                  break;

              case 5:
                  ejs.ej5();
                  break;

              case 6:
                  ejs.ej6();
                  break;

              case 7:
                  ejs.ej7();
                  break;

              case 8:
                  ejs.ej8();
                  break;

              case 9:
                  ejs.ej9();
                  break;

              case 10:
                  ejs.ej10();
                  break;

              case 11:
                  ejs.ej11();
                  break;

              case 12:
                  ejs.ej12();
                  break;

              case 13:
                  ejs.ej13();
                  break;

              case 14:
                  ejs.ej14();
                  break;

              case 15:
                  ejs.ej15();
                  break;

              case 16:
                  ejs.ej16();
                  break;

              case 17:
                  ejs.ej17();
                  break;

              case 18:
                  ejs.ej18();
                  break;

              case 19:
                  ejs.ej19();
                  break;

              case 20:
                  ejs.ej20();
                  break;
                */
              default:
                  System.out.println("Opción inválida. Ingrese un número del 1 al 20.");
                  break;
          }

          e.close();
      }
}

