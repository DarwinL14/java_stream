package com.streams.empleado;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamEmpleado {
    static List<Empleado> empleados = List.of(

        Empleado.builder().nombre("Cristian").apellido("Buitrago").salario(2000000).departamento("SISTEMAS").build(),

        Empleado.builder().nombre("Daniela").apellido("Perez").salario(2500000).departamento("CARTERA").build(),

        new Empleado("Jeisson", "Rojas", 2600000, "SISTEMAS"),

        new Empleado("Jerson", "Muñoz", 2600000, "SISTEMAS"),

        new Empleado("David", "Murcia", 2600000, "SISTEMAS")

    );

    public static void main(String[] args) {
        // crear un empleado utilizando lombok:builder
        

        // System.out.println(empleados);

        // Crear stream de empleados:
        Stream<Empleado> streamEmpleados = empleados.stream();

        // 1 contrar el numero de empleados q hay
        // System.out.println( "Numero de empleados: " + streamEmpleados.count());

        // recorrer todos los empleados:

        // streamEmpleados.forEach(e -> System.out.println((e).getSalario()));

        //Predicate:

        Predicate<Empleado> mayoresA2Palos =
            empleado -> (empleado).getSalario() >= 2000000;
        Predicate<Empleado> menoresA3Palos =
            empleado -> (empleado).getSalario() <= 3000000;
        Predicate<Empleado> entre2y3 =
            mayoresA2Palos.and(menoresA3Palos);


        Function<Empleado, String> getNombreyApellido = empleado -> empleado.getApellido() + " " + empleado.getNombre();
        // Function<Empleado, Integer> getSalario = Empleado::getSalario;
        Function<Empleado, Integer> getSalario = e -> e.getSalario();

        //aplicacion del predicado con un filtro 
        // streamEmpleados.filter(mayoresA2Palos)
        //     .map(getNombreyApellido)
        //     .forEach(System.out::println);
        // System.out.println("Maximo salario: " + streamEmpleados.max(Comparator.comparing(getSalario)));

        // System.out.println("Minimo salario: " + streamEmpleados.min(Comparator.comparing(getSalario)));
        
        // Total de salarios de los empleados

        // Integer totalSalarios = streamEmpleados.map(getSalario)
        // // reduce: halla el resultado de una operacion de acumulacion sobre un flujo
        // // parametros:
        // // identidad:el valor inicial de la operacion:
        // // el BO: para ir sumando los numeros
        // .reduce(0 , (sal1, sal2) -> sal1 + sal2);
        // System.out.println("total de salarios: " + totalSalarios);

        // System.out.println(
        //     "Promedio empleados de sistemas: " +
        //     streamEmpleados.filter(e -> e.getDepartamento().equals("SISTEMAS"))
        //     .mapToInt(Empleado::getSalario)
        //     .average());
            
        System.out.println(
            "Suma de empleados de sistemas: " +
            streamEmpleados.filter(entre2y3).filter(empleado -> empleado.getDepartamento().equals("SISTEMAS"))
            .mapToInt(Empleado::getSalario)
            .sum());
            
        


    }
}

