package proyectotrnasversalentrega1;

import AccesoADatos.AlumnoData;
import AccesoADatos.Conexion;
import java.sql.Connection;
import java.time.LocalDate;
import proyectotrnasversalentrega1.entidades.Alumno;
/**
 *
 * @author Damián
 */
public class ProyectoTrnasversalEntrega1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Connection con = Conexion.getConexion();
        
       Alumno juan= new Alumno(1, 45000000, "Castro", "Victoria", LocalDate.of(2000, 4, 27), true);
       AlumnoData alu = new AlumnoData();
       //alu.guardarAlumno(juan);
       //alu.modificarAlumno(juan);
       alu.eliminarAlumno(1);
    }
    
}
