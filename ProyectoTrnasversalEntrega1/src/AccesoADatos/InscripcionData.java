/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AccesoADatos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import proyectotrnasversalentrega1.entidades.Alumno;
import proyectotrnasversalentrega1.entidades.Inscripcion;
import proyectotrnasversalentrega1.entidades.Materia;

public class InscripcionData {
    private Connection con =null;
    private MateriaData md= new MateriaData();
    private AlumnoData ad=new AlumnoData();
    
    public InscripcionData(){
        this.con=(Connection) Conexion.getConexion();
        
    }
    
    public void guardarInscripcion(Inscripcion insc){
        String sql= "INSERT INTO iscripcion(idAlumno,idMateria,nota) VALUES (?,?,?)";
       
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, insc.getAlumno().getIdAlumno());
            ps.setInt(2,insc.getMateria().getIdMateria());
            ps.setDouble(3,insc.getNota());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                insc.setIdInscripcion(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "inscripcion registrada ");         
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error al acceder a la tabla inscripcion");
        }
    }
    
    public void actualizarNota(int idAlumno,int idMateria,double nota){
        String sql="UPDATE inscripcion SET nota =? WHERE idAlumno=? and idMateria=? ";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDouble(1,nota);
            ps.setInt(2, idAlumno);
            ps.setInt(3,idMateria);
            int fila= ps.executeUpdate();
            if(fila>0){
                JOptionPane.showMessageDialog(null, "nota actualizada");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error al acceder a la tabla inscripcion");
        }
    }
    
    public void borrarInscripcionMateria(int idAlumno, int idMateria){
        String sql= "DELETE FROM inscripcion WHERE idAlumno=? and idMateria=? ";
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ps.setInt(2, idAlumno);
            int fila= ps.executeUpdate();
            if(fila<0){
                JOptionPane.showMessageDialog(null , "inscripcion borrada exitosamente ");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error al acceder a la tabla inscripcion ");
        }
    }
     public List<Inscripcion>obtenerInscripciones(){
         ArrayList<Inscripcion> cursadas= new ArrayList<>();
         
         String sql= "SELEC* FROM inscripcion";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                Inscripcion insc= new Inscripcion();
                insc.setIdInscripcion(rs.getInt("idInscripto"));
                Alumno alum= ad.buscarAlumno(rs.getInt("idAlumno"));
                Materia mat= md.buscarMateria(rs.getInt("idMateria"));
                insc.setMateria(mat);
                insc.setNota(rs.getDouble("nota"));
                cursadas.add(insc);
            }
            ps.close();
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null , "error al acceder a la tabla inscripcion  ");
        }
         
         
        return cursadas; 
     }
    
}
