import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<Persona> personas = new ArrayList<>();

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            System.out.print("Ingresar nombre: ");
            String nombre = entrada.next();

            System.out.print("Ingresar fecha de nacimiento: ");
            String fechanac = entrada.next();

            Persona persona = new Persona(nombre, fechanac);
            personas.add(persona);
        }

        System.out.println("Datos ingresados:");
        for (Persona persona : personas) {
            System.out.println("- " + persona.nombre + " nació el " + persona.fechaNac);
        }

        // Calcular mayor
        Persona mayor = personas.get(0);
        for (Persona persona : personas) {
            if (persona.edad() > mayor.edad()) {
                mayor = persona;
            }
        }
        System.out.println("La persona más grande es " + mayor.nombre + " con " + mayor.edad() + " años.");

        // Calcular los dos más jóvenes :3
        Persona[] menores = new Persona[2];
        menores[0] = null;
        menores[1] = null;

        for (Persona persona : personas) {
            if (menores[0] == null || persona.edad() < menores[0].edad()) {
                menores[1] = menores[0];
                menores[0] = persona;
            } else if (menores[1] == null || persona.edad() < menores[1].edad()) {
                menores[1] = persona;
            }
        }

        System.out.println("Las personas jóvenes son: ");
        for (Persona menor : menores) {
            System.out.println("- " + menor.nombre + " con " + menor.edad() + " años.");
        }

        // Calcular promedio de edades
        int sumEdades = 0;
        for (Persona persona : personas) {
            sumEdades += persona.edad();
        }
        double promedio = (double) sumEdades / personas.size();
        System.out.println("El promedio de las edades son: " + promedio + " años.");

        entrada.close();
    }
}
