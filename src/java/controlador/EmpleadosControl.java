/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.dao.EmpleadosDao;
import modelo.entidad.Empleados;


/**
 *
 * @author elcon
 */
@ManagedBean
@ViewScoped
public class EmpleadosControl {

    /**
     * Creates a new instance of EmpleadosControl
     */
    private List<Empleados> listaEmpleados;
    private Empleados empleados;

    public EmpleadosControl() {
        empleados = new Empleados();
    }

    public List<Empleados> getListaEmpleados() {
        EmpleadosDao ad = new EmpleadosDao();
        listaEmpleados = ad.listarEmpleados();
        return listaEmpleados;
    }

    public void setListaEmpleados(List<Empleados> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    public Empleados getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Empleados empleados) {
        this.empleados = empleados;
    }

    public void limpiarEmpleados() {
        empleados = new Empleados();
    }

    public void agregarEmpleados() {
        EmpleadosDao ad = new EmpleadosDao();
        ad.agregar(empleados);
    }

    public void modificarEmpleados() {
        EmpleadosDao ad = new EmpleadosDao();
        ad.modificar(empleados);
        limpiarEmpleados();
    }

    public void eliminarEmpleados() {
        EmpleadosDao ad = new EmpleadosDao();
        ad.eliminar(empleados);
        limpiarEmpleados();
    }
}
