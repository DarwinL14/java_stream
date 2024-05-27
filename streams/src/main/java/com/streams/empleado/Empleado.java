package com.streams.empleado;
import lombok.*;

// @AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Empleado {
    
    private String nombre;
    private String apellido;
    private Integer salario;
    private String departamento;



    public Empleado(String nombre, String apellido, Integer salario, String departamento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.salario = salario;
        this.departamento = departamento;
    }



    public Empleado(Integer salario) {
        this.salario = salario;
  
    }
}
