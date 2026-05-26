package com.krakdev.jdbc;

import com.krakdev.entidades.Vehiculo;

public class Main {

    public static void main(String[] args) {

        // INSERT
        Vehiculo v1 = new Vehiculo("ABC-001", "Toyota", "Corolla", 2020, 18000.00, "Blanco", true, 15000);
        Vehiculo v2 = new Vehiculo("XYZ-002", "Honda", "Civic", 2021, 22000.00, "Negro", true, 8000);
        Vehiculo v3 = new Vehiculo("DEF-003", "Chevrolet", "Spark", 2019, 12000.00, "Rojo", false, 30000);

        InsertVehiculo.insertar(v1);
        InsertVehiculo.insertar(v2);
        InsertVehiculo.insertar(v3);

        // SELECT
        System.out.println("\n--- Lista de vehículos ---");
        SelectVehiculo.listar();

        // UPDATE
        UpdateVehiculo.actualizar("ABC-001", 17000.00, "Gris", 16000);

        // SELECT después del UPDATE
        System.out.println("\n--- Lista después del UPDATE ---");
        SelectVehiculo.listar();

        // DELETE
        DeleteVehiculo.eliminar("DEF-003");

        // SELECT después del DELETE
        System.out.println("\n--- Lista después del DELETE ---");
        SelectVehiculo.listar();
    }
}