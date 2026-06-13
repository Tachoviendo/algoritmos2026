package ucu.edu.aed.ejer13;

import java.util.Objects;

public class Alumno {
    /*
    Si dos objetos son iguales según equals(), entonces deben producir exactamente el mismo hashCode().

    EJ: 
    Alumno a1 = new Alumno(1, "Juan Perez", "juan@mail.com");
    Alumno a2 = new Alumno(1, "Juan Perez", "juan@mail.com");
    a1.equals(a2); // true

    */

    private int id;
    private String fullName;
    private String email;

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Alumno other = (Alumno) obj;
        return id == other.id &&
               Objects.equals(fullName, other.fullName) &&
               Objects.equals(email, other.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullName, email);
    }
}