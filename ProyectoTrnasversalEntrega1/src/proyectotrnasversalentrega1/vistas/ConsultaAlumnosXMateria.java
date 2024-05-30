package proyectotrnasversalentrega1.vistas;

import AccesoADatos.InscripcionData;
import AccesoADatos.MateriaData;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import proyectotrnasversalentrega1.entidades.Alumno;
import proyectotrnasversalentrega1.entidades.Materia;

public class ConsultaAlumnosXMateria extends javax.swing.JInternalFrame {
    private List<Materia> listaM;
    private List<Alumno> listaA;
    private DefaultTableModel modelo;
    private MateriaData mData;
    private InscripcionData inscData;
    
    public ConsultaAlumnosXMateria() {
        initComponents();
        mData = new MateriaData();
        modelo = new DefaultTableModel();
        listaM = (ArrayList<Materia>) mData.listarMaterias();
        inscData = new InscripcionData();
        
        cargarMateria();
        armarCabeceraTabla();
    }
    
    private void cargarMateria(){
        for (Materia item : listaM) {
            jbMateria.addItem(item);
        }
    }
    private void borrarFilaTabla(){
    int indice = modelo.getRowCount()-1;
        for (int i = indice; i >=0; i--) {
            modelo.removeRow(i);
        }
    }
    private void armarCabeceraTabla(){
    ArrayList<Object> filaCabecera = new ArrayList<>();
    filaCabecera.add("ID");
    filaCabecera.add("DNI");
    filaCabecera.add("Apellido");
    filaCabecera.add("Nombre");
        for (Object it : filaCabecera) {
            modelo.addColumn(it);
        }
       jtAlumnos.setModel(modelo);
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtAlumnos = new javax.swing.JTable();
        jbMateria = new javax.swing.JComboBox<>();

        jLabel1.setText("Listado de Alumno por Materia");

        jLabel2.setText("Seleccione una materia");

        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jtAlumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jtAlumnos);
        if (jtAlumnos.getColumnModel().getColumnCount() > 0) {
            jtAlumnos.getColumnModel().getColumn(0).setHeaderValue("Title 1");
            jtAlumnos.getColumnModel().getColumn(1).setHeaderValue("Title 2");
            jtAlumnos.getColumnModel().getColumn(2).setHeaderValue("Title 3");
            jtAlumnos.getColumnModel().getColumn(3).setHeaderValue("Title 4");
        }

        jbMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbMateriaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(81, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(136, 136, 136))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(34, 34, 34)
                        .addComponent(jbMateria, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49))))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbMateria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbMateriaActionPerformed
        //primero vaciamos la lista:
        borrarFilaTabla();
        //creamos un objeto de tipo materia al que le asignamos los valores elegidos en el combo box:
        Materia selec = (Materia)jbMateria.getSelectedItem();
        //obtenemos alumnos que esten inscriptos en esa materia:
        listaA = inscData.obtenerAlumnosPorMateria(selec.getIdMateria());
        //mostramos alumnos inscriptos: 
        for (Alumno a : listaA) {
            modelo.addRow(new Object[] { a.getIdAlumno(), a.getDni(), a.getApellido(), a.getNombre()});
        }
    }//GEN-LAST:event_jbMateriaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<Materia> jbMateria;
    private javax.swing.JTable jtAlumnos;
    // End of variables declaration//GEN-END:variables
}
