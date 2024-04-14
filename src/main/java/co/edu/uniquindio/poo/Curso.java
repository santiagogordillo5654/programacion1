
package co.edu.uniquindio.poo;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Clase para manejar la información de un curso
 * @author Área de programación UQ
 * @since 2024-01
 * 
 * Licencia GNU/GPL V3.0 (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE) 
 */
public class Curso {
    private final String nombre;
    private final Collection<Estudiante> estudiantes;
    private final Collection<NotaParcial> notasParciales;

    /**
     * Método constructor de la clase Curso --> Modificado por : Yefry
     * 
     * @param nombre Nombre del curso
     */
    

    public Curso(String nombre) {
    while (nombre == null) {
        System.out.println("El nombre no puede ser nulo. Introduce un nombre válido:");
        // Aquí puedes usar alguna entrada de usuario para asignar un valor a 'nombre'
    }
    this.nombre = nombre;
    estudiantes = new LinkedList<>();
    notasParciales = new LinkedList<>();
}






    /**
     * Método para obtener el nombre del curso --> Modificado por : Santiago
     * 
     * @return Nombre del curso
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método para agregar a un estudiante al curso --> Modificado por : Sebastian
     * 
     * @param estudiante Estudiante que se desea agregar
     */
    public void agregarEstudiante(Estudiante estudiante) {
        assert validarNumeroIdentificacionExiste(estudiante.getNumeroIdentificacion()) == false
                : "El número de identificación ya existe.";
        estudiantes.add(estudiante);
    }

    /**
     * Método privado para determinar si ya existe un estudiante registro en el --> Modificado por : Yefry
     * mismo número de identificación
     * 
     * @param numeroIdentificacion Número de identificación a buscar
     * @return Valor boolean que indica si el número de identificación ya está o no
     *         registrado.
     */
    private boolean validarNumeroIdentificacionExiste(String numeroIdentificacion) {
    for (Estudiante estudiante : estudiantes) {
        if (estudiante.getNumeroIdentificacion().equals(numeroIdentificacion)) {
            return true; // Se encontró un estudiante con el número de identificación dado
        }
    }
    return false; // No se encontró ningún estudiante con el número de identificación dado
}


    /**
     * Método para buscar un estudiante dado el número de indicación
     * 
     * @param numeroIdenficacion Número de identificación del estudiante a buscar --> Modificado por : Santiago
     * @return Estudiante con el número de indicación indicado o null
     */
    public Optional<Estudiante> obtenerEstudiante(String numeroIdenficacion) {
        Predicate<Estudiante> condicion = estudiante -> estudiante.getNumeroIdentificacion().equals(numeroIdenficacion);

        return estudiantes.stream().filter(condicion).findAny();
    }

    /**
     * Método para obtener la colección NO modificable de los estudiantes del curso --> Modificado por : Sebastian
     * 
     * @return colección NO modificable de los estudiantes del curso
     */
    public Collection<Estudiante> getEstudiantes() {
        return Collections.unmodifiableCollection(estudiantes);
    }

    /**
     * Método para obtener la colección NO modificable de los estudiantes del curso --> Modificado por : Yefry
     * en orden alfabético
     * 
     * @return colección NO modificable de los estudiantes del curso en
     *         orden alfabético
     */
    public Collection<Estudiante> obtenerListadoAlfabetico() {
    List<Estudiante> estudiantesOrdenados = new ArrayList<>(estudiantes);
    Collections.sort(estudiantesOrdenados, Comparator.comparing(Estudiante::getNombres));
        return Collections.unmodifiableCollection(estudiantesOrdenados);
    }



    /**
     * Método para obtener la colección NO modificable de los estudiantes del curso --> Modificado por : Santiago
     * en orden descendente de la edad
     * 
     * @return la colección NO modificable de los estudiantes del curso registrados
     *         en el curso descendente por edad.
     */
    public Collection<Estudiante> obtenerListadoEdadDescendente() {
        var comparador = Comparator.comparing(Estudiante::getEdad).reversed();
        var estudiantesOrdenados = estudiantes.stream().sorted(comparador).toList();
        return Collections.unmodifiableCollection(estudiantesOrdenados);
    }

    /**
     * Método para obtener la colección NO modificable de los estudiantes del curso --> Modificado por : Sebastian
     * que son menores de edad
     * 
     * @return la colección NO modificable de los estudiantes del curso que
     *         son menores de edad.
     */
    public Collection<Estudiante> obtenerListadoMenoresEdad() {
        return estudiantes.stream()
                .filter(estudiante -> estudiante.getEdad() < 18)
                .toList();
    }

    /**
     * Método para adicionar una nota parcial
     * TODO: Se puede validar que la suma de los porcentajes no sobrepase en ningún --> Modificado por : Yefry
     * momento 1.0 (100%)
     * 
     * @param notaParcial nota parcial que se desea adicionar al curso
     */
    public void adicionarNotaParcial(NotaParcial notaParcial) {
        notasParciales.add(notaParcial);
    }

    /**
     * Método para obtener una nota parcial dado el nombre de la nota parcial --> Modificado por : Santiago
     * @param nombreNotaParcial nombre de la nota parcial a buscar
     * @return nota parcial encontrada o un excepción de no entrada.
     */
    public NotaParcial getNotaParcial(String nombreNotaParcial) {
        Predicate<NotaParcial> nombreIgual = j -> j.nombre().equals(nombreNotaParcial);
        var posibleNotaParcial = notasParciales.stream().filter(nombreIgual).findAny();
        assert posibleNotaParcial.isPresent();

        return posibleNotaParcial.get();
    }

    /**
     * Método que obtiene la colección de los estudiantes con mayor nota. --> Modificado por : Sebastian
     * @return colección de los estudiantes con la mayor nota.
     */
    public Collection<Estudiante> obtenerListadoMayorNota() {
        double mayorNota = obtenerMayorNota();

        return estudiantes.stream()
                .filter(estudiante -> mayorNota - estudiante.getDefinitiva() <= App.PRECISION)
                .toList();
    }

    /**
     * Método de apoyo (privado) que determinar el valor de la mayor nota definitiva --> Modificado por : Yefry
     * @return mayor nota definitiva de los estudiantes del curso.
     */
    

    private double obtenerMayorNota() {
    double mayorNota = Double.MIN_VALUE; // Valor inicial muy pequeño

    for (Estudiante estudiante : estudiantes) {
        double definitiva = estudiante.getDefinitiva();
        if (definitiva > mayorNota) {
            mayorNota = definitiva;
        }
    }

    return mayorNota;
}




    /**
     * Método para obtener la colección de los estudiantes que perdieron en orden alfabético. --> Modificado por : Santiago
     * @return colección de los estudiantes que perdieron en orden alfabético.
     */
    public Collection<Estudiante> obtenerListadoAlfabeticoPerdieron() {
        var comparador = Comparator.comparing(Estudiante::getNombres);
        return estudiantes.stream()
                .filter(estudiante -> estudiante.getDefinitiva() < App.MINIMA_NOTA)
                .sorted(comparador)
                .toList();
    }

    /**
     * Método para validar que la suma de los porcentajes de las notas parciales esa 1.0 (100%) --> Modificado por : Sebastian
     * @return verdadero si la suma de los porcentajes es 1.0 (100%) o tan cercano como la precisión indicada.
     */
    public boolean validarPorcentajes() {
        double pesoNotas = notasParciales.stream()
                .mapToDouble(n -> n.porcentaje()).sum();
        return (1.0 - pesoNotas) <= App.PRECISION;
    }

}
