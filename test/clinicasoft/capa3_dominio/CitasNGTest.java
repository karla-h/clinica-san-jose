package clinicasoft.capa3_dominio;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

public class CitasNGTest {

    @Test
    public void test1PermiteNuevoCitas() {
        System.out.println("permiteNuevaCitas");
        int citasmaximas = 17;
        Citas instance = new Citas();
        Medico medico = new Medico();
        medico.setCitaMaxima(17);
        instance.setMedico(medico);
        boolean expResult = true;
        boolean result = instance.permiteNuevaCitas(citasmaximas);
        assertEquals(result, expResult);
    }

    @Test
    public void test2PermiteNuevoCitas() {
        System.out.println("permiteNuevaCitas");
        int citasmaximas = 28;
        Citas instance = new Citas();
        Medico medico = new Medico();
        medico.setCitaMaxima(17);
        instance.setMedico(medico);
        boolean expResult = false;
        boolean result = instance.permiteNuevaCitas(citasmaximas);
        assertEquals(result, expResult);
    }

    @Test
    public void test3CalcularDescuento() {
        System.out.println("calcularDescuento");
        Citas instance = new Citas();
        Paciente paciente = new Paciente();
        paciente.setAplicaDescuento(true);
        Especialidad especialidad = new Especialidad();
        especialidad.setCosto(50);
        Medico medico = new Medico();
        medico.setEspecialidad(especialidad);
        instance.setPaciente(paciente);
        instance.setMedico(medico);
        double expResult = 10;
        double result = instance.calcularDescuento();
        assertEquals(result, expResult, 0.0);
    }

    @Test
    public void test4CalcularDescuento() {
        System.out.println("calcularDescuento");
        Citas instance = new Citas();
        Paciente paciente = new Paciente();
        paciente.setAplicaDescuento(false);
        Especialidad especialidad = new Especialidad();
        especialidad.setCosto(50);
        Medico medico = new Medico();
        medico.setEspecialidad(especialidad);
        instance.setPaciente(paciente);
        instance.setMedico(medico);
        double expResult = 0;
        double result = instance.calcularDescuento();
        assertEquals(result, expResult, 0.0);
    }

    @Test
    public void test5CalcularCostoTotal() {
        System.out.println("calcularCostoTotal");
        Citas instance = new Citas();
        Paciente paciente = new Paciente();
        paciente.setAplicaDescuento(true);
        Especialidad especialidad = new Especialidad();
        especialidad.setCosto(50);
        Medico medico = new Medico();
        medico.setEspecialidad(especialidad);
        instance.setPaciente(paciente);
        instance.setMedico(medico);
        double expResult = 40;
        double result = instance.calcularCostoTotal();
        assertEquals(result, expResult, 0.0);
    }

    @Test
    public void test6CalcularCostoTotal() {
        System.out.println("calcularCostoTotal");
        Citas instance = new Citas();
        Paciente paciente = new Paciente();
        paciente.setAplicaDescuento(false);
        Especialidad especialidad = new Especialidad();
        especialidad.setCosto(50);
        Medico medico = new Medico();
        medico.setEspecialidad(especialidad);
        instance.setPaciente(paciente);
        instance.setMedico(medico);
        double expResult = 50;
        double result = instance.calcularCostoTotal();
        assertEquals(result, expResult, 0.0);
    }
}
