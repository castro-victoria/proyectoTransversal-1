package proyectotrnasversalentrega1;

import AccesoADatos.AlumnoData;
import AccesoADatos.Conexion;
import AccesoADatos.MateriaData;
import java.sql.Connection;
import java.time.LocalDate;
import java.time.Month;
import proyectotrnasversalentrega1.entidades.Alumno;
import proyectotrnasversalentrega1.entidades.Materia;

/**
 *
 * @author Damián
 */
public class ProyectoTrnasversalEntrega1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Los queremos profes.
        //Connection con = Conexion.getConexion(); (?
        //CREATE
        //Alumno damian = new Alumno(4, 33515875, "D'Eramo", "Damián", LocalDate.of(2000, Month.MAY, 27), true);

        //AlumnoData alu = new AlumnoData();
        //alu.guardarAlumno(damian);
        //UPDATE
        //alu.modificarAlumno(damian);
        //DELETE (UPDATE) Lógico
        //alu.eliminarAlumno(8);
        //READ
        /*System.out.println("Buscar alumno por ID");
        Alumno encontrado = alu.buscarAlumno(4);
        if (encontrado != null) {
            System.out.println("Dni: " + encontrado.getDni());
            System.out.println("Apellido: " + encontrado.getApellido());
            System.out.println("Nombre: " + encontrado.getNombre());
            System.out.println("Fecha nacimiento: " + encontrado.getFechaNac());
        }
        System.out.println("");
        System.out.println("Buscar alumno por DNI");
        Alumno encontradoPorDni = alu.buscarPorDni(33515875);
        if (encontradoPorDni != null) {
            System.out.println("Dni: " + encontradoPorDni.getDni());
            System.out.println("Apellido: " + encontradoPorDni.getApellido());
            System.out.println("Nombre: " + encontradoPorDni.getNombre());
            System.out.println("Fecha nacimiento: " + encontradoPorDni.getFechaNac());
        }
        System.out.println("");
        //Listar alumnos
        System.out.println("Lista de alumnos activos");
        for (Alumno alum : alu.listarAlumno()) {
            System.out.println(alum.getApellido() + " " +  alum.getNombre());
        }*/
        MateriaData mat = new MateriaData();
        //Materia nose = new Materia("Inglés Técnico", 2024, true);
        //mat.guardarMateria(nose);
        
        /*Materia matEncontrada = mat.buscarMateria(1);
        if (matEncontrada != null) {
            System.out.println("nombre: " + matEncontrada.getNombre());
            System.out.println("Año: " + matEncontrada.getAnioMateria());
        }*/
        //Materia eda= new Materia(2, "EDyA", 2024, true);
        //mat.modificarMateria(eda);
        
        //mat.eliminarMateria(7);
        
        for (Materia materias : mat.listarMaterias()) {
            System.out.println("nombre: " + materias.getNombre());
            System.out.println("Año: " + materias.getAnioMateria());
            
        }
        
        

    }

}
