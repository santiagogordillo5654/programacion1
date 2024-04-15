package co.edu.uniquindio.poo;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.function.Predicate;

/**
 * Registro que agrupa los datos de un Curso.
 * 
 * @author Área de programación UQ
 * @since 2024-01
 * 
 *        Licencia GNU/GPL V3.0
 *        (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE)
 */

public class Curso {
    private final String nombre;
    private final Collection<Estudiante> estudiantes;
    private final Collection<ClaseCurso> clases;

    /**
     * Método constructor de la clase Curso --> Modificado por : Yefry
     * 
     * @param nombre Nombre del curso
     */
    

    public Curso(String nombre) {
        if (nombre == null) {
            throw new IllegalArgumentException("El nombre no puede ser nulo");
        }
        this.nombre = nombre;
        estudiantes = new LinkedList<>();
        clases = new LinkedList<>();
    }
    
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
        for (Estudiante e : estudiantes) {
            if (e.getNumeroIdentificacion().equals(estudiante.getNumeroIdentificacion())) {
                throw new IllegalArgumentException("El número de identificación ya existe.");
            }
        }
    public void agregarEstudianteIterativo(Estudiante estudiante) {
       
        assert !validarNumeroIdentificacionExiste(estudiante.getNumeroIdentificacion()) : "El número de identificación ya existe.";
        estudiantes.add(estudiante);
    }
    
    /**
     * Método para buscar un estudiante dado el número de indicación
     * 
     * @param numeroIdenficacion Número de identificación del estudiante a buscar
     * @return Estudiante con el número de indicación indicado o null
     */
    public Estudiante getEstudiante(String numeroIdentificacion) {
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getNumeroIdentificacion().equals(numeroIdentificacion)) {
                return estudiante;
            }
        }
        return null;
    }
    
    /**
     * Método para obtener la colección NO modificable de los estudiantes del curso
     * 
     * @return la colección NO modificable de los estudiantes del curso
     */
    public Collection<Estudiante> getEstudiantes() {
        return new ArrayList<>(estudiantes);
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
                return true;
            }
        }
        return false;
    }
    
    for (Estudiante estudiante : estudiantes) {
        if (estudiante.getNumeroIdentificacion().equals(numeroIdentificacion)) {
            return true; // Se encontró un estudiante con el número de identificación dado
        }
    }
    return false; // No se encontró ningún estudiante con el número de identificación dado
}


    /**
     * Método para programar (agregar) una clase a un curso.
     * TODO evitar agregar más de una vez una misma clase.
     * 
     * @param claseCurso claseCurso que se desea programar
     */
    public void programarClase(ClaseCurso claseCurso) {
        clases.add(claseCurso);
    }
    
     * @param numeroIdenficacion Número de identificación del estudiante a buscar --> Modificado por : Santiago
     * @return Estudiante con el número de indicación indicado o null
     */
    public Optional<Estudiante> obtenerEstudiante(String numeroIdentificacion) {
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getNumeroIdentificacion().equals(numeroIdentificacion)) {
                return Optional.of(estudiante);
            }
        }
        return Optional.empty();
    }
    

    /**
     * Método para obtener la colección NO modificable de los estudiantes del curso --> Modificado por : Sebastian
     * 
     * @return la colección NO modificable de las clases del curso
     */
    public Collection<ClaseCurso> getClases() {
        return new ArrayList<>(clases);
    public Collection<Estudiante> getEstudiantesIterativo() {
        List<Estudiante> copiaEstudiantes = new ArrayList<>(estudiantes);
        return copiaEstudiantes;
    }
    
    /**
     * Método que obtiene la colección de estudiantes que asistieron a una clase
     * Método para obtener la colección NO modificable de los estudiantes del curso --> Modificado por : Yefry
     * en orden alfabético
     * 
     * @param claseCurso la clase de interés
     * @return colección de los estudiantes que asistieron a una clase interés
     */
    public Collection<Estudiante> getAsistentes(ClaseCurso claseCurso) {
        List<Estudiante> asistentes = new ArrayList<>();
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.asistioClase(claseCurso)) {
                asistentes.add(estudiante);
            }
        }
        return asistentes;
    }
    
    /**
     * Método que obtiene la colección de estudiantes que estaban ausentes a una
     * clase
    public Collection<Estudiante> obtenerListadoAlfabetico() {
    List<Estudiante> estudiantesOrdenados = new ArrayList<>(estudiantes);
    Collections.sort(estudiantesOrdenados, Comparator.comparing(Estudiante::getNombres));
        return Collections.unmodifiableCollection(estudiantesOrdenados);
    }



    /**
     * Método para obtener la colección NO modificable de los estudiantes del curso --> Modificado por : Santiago
     * en orden descendente de la edad
     * 
     * @param claseCurso la clase de interés
     * @return colección de los estudiantes que estuvieron ausentes a una clase
     *         interés
     */
    public Collection<Estudiante> getAusentes(ClaseCurso claseCurso) {
        List<Estudiante> ausentes = new ArrayList<>();
        for (Estudiante estudiante : estudiantes) {
            if (!estudiante.asistioClase(claseCurso)) {
                ausentes.add(estudiante);
            }
        }
        return ausentes;
    }
    
    public double calcularPorcentajeAsistencia(ClaseCurso claseCurso) {
        int cantidadEstudiantes = estudiantes.size();
        int cantidadAsistentes = 0;
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.asistioClase(claseCurso)) {
                cantidadAsistentes++;
            }
        }
        return (double) cantidadAsistentes / cantidadEstudiantes;
    }
    public Collection<Estudiante> obtenerListadoEdadDescendente() {
        List<Estudiante> estudiantesOrdenados = new ArrayList<>(estudiantes);
        Comparator<Estudiante> comparador = Comparator.comparing(Estudiante::getEdad).reversed();
        estudiantesOrdenados.sort(comparador);
        return Collections.unmodifiableCollection(estudiantesOrdenados);
    }
    

    /**
     * Método para obtener la colección NO modificable de los estudiantes del curso --> Modificado por : Sebastian
     * que son menores de edad
     * 
     * @return la colección NO modificable de los estudiantes del curso que
     *         son menores de edad.
     */
    public Collection<Estudiante> obtenerListadoMenoresEdadIterativo() {
        List<Estudiante> listadoMenoresEdad = new ArrayList<>();
    
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getEdad() < 18) {
                listadoMenoresEdad.add(estudiante);
            }
        }
    
        return listadoMenoresEdad;
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
     * Método para obtener una nota parcial dado el nombre de la nota parcial --> Modificado por : Santiago--
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
    public Collection<Estudiante> obtenerListadoMayorNotaIterativo() {
        double mayorNota = obtenerMayorNota();
        List<Estudiante> listadoMayorNota = new ArrayList<>();
    
        for (Estudiante estudiante : estudiantes) {
            if (mayorNota - estudiante.getDefinitiva() <= App.PRECISION) {
                listadoMayorNota.add(estudiante);
            }
        }
    
        return listadoMayorNota;
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
        List<Estudiante> estudiantesPerdieron = new ArrayList<>();
        Comparator<Estudiante> comparador = Comparator.comparing(Estudiante::getNombres);
        
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getDefinitiva() < App.MINIMA_NOTA) {
                estudiantesPerdieron.add(estudiante);
            }
        }
        
        estudiantesPerdieron.sort(comparador);
        return estudiantesPerdieron;
    }
    

    /**
     * Método para validar que la suma de los porcentajes de las notas parciales esa 1.0 (100%) --> Modificado por : Sebastian
     * @return verdadero si la suma de los porcentajes es 1.0 (100%) o tan cercano como la precisión indicada.
     */
    public boolean validarPorcentajes() {
        double pesoNotas = 0.0;
        for (NotaParcial nota : notasParciales) {
            pesoNotas += nota.porcentaje();
        }
        return (1.0 - pesoNotas) <= App.PRECISION;
    }
    

}
    