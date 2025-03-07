package controladores;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Inicio {

    public static void main(String[] args) {
        
        boolean esCerrado = false;
        Scanner scanner = new Scanner(System.in);
        byte opcionUsuario;
        float operandoUno, operandoDos, resultado;
        
        // Intentamos abrir el archivo de log
        try (FileWriter fw = new FileWriter("log.txt", true);
             PrintWriter log = new PrintWriter(fw)) {

            // Registro de inicio de la sesión
            log.println("----- NUEVA SESIÓN -----");

            do {
                System.out.println("------ MENÚ ------");
                System.out.println("0. Cerrar menú.");
                System.out.println("1. Suma.");
                System.out.println("2. Resta.");
                System.out.println("3. División.");
                System.out.println("4. Producto.");
                System.out.println("5. Módulo.");
                System.out.println("------------------");
                System.out.println("Escriba la opción deseada: ");

                opcionUsuario = scanner.nextByte();
                log.println("Opción seleccionada: " + opcionUsuario); // Se registra la opción

                switch (opcionUsuario) {
                    case 0: {
                        System.out.println("Se ha seleccionado la opción 0.");
                        esCerrado = true;
                        log.println("Menú cerrado.");
                        break;
                    }
                    case 1: {
                        System.out.println("Operación suma.");
                        System.out.println("Indique el primer operando: ");
                        operandoUno = scanner.nextFloat();
                        System.out.println("Indique el segundo operando: ");
                        operandoDos = scanner.nextFloat();
                        resultado = operandoUno + operandoDos;
                        System.out.println("El resultado de la operación es: " + resultado);
                        log.println("Suma: " + operandoUno + " + " + operandoDos + " = " + resultado);
                        break;
                    }
                    case 2: {
                        System.out.println("Operación resta.");
                        System.out.println("Indique el primer operando: ");
                        operandoUno = scanner.nextFloat();
                        System.out.println("Indique el segundo operando: ");
                        operandoDos = scanner.nextFloat();
                        resultado = operandoUno - operandoDos;
                        System.out.println("El resultado de la operación es: " + resultado);
                        log.println("Resta: " + operandoUno + " - " + operandoDos + " = " + resultado);
                        break;
                    }
                    case 3: {
                        System.out.println("Operación división.");
                        System.out.println("Indique el primer operando: ");
                        operandoUno = scanner.nextFloat();
                        System.out.println("Indique el segundo operando: ");
                        operandoDos = scanner.nextFloat();
                        if (operandoDos != 0) {
                            resultado = operandoUno / operandoDos;
                            System.out.println("El resultado de la operación es: " + resultado);
                            log.println("División: " + operandoUno + " / " + operandoDos + " = " + resultado);
                        } else {
                            System.out.println("Error: División por cero no permitida.");
                            log.println("Error: División por cero.");
                        }
                        break;
                    }
                    case 4: {
                        System.out.println("Operación producto.");
                        System.out.println("Indique el primer operando: ");
                        operandoUno = scanner.nextFloat();
                        System.out.println("Indique el segundo operando: ");
                        operandoDos = scanner.nextFloat();
                        resultado = operandoUno * operandoDos;
                        System.out.println("El resultado de la operación es: " + resultado);
                        log.println("Producto: " + operandoUno + " * " + operandoDos + " = " + resultado);
                        break;
                    }
                    case 5: {
                        System.out.println("Operación módulo.");
                        System.out.println("Indique el primer operando: ");
                        operandoUno = scanner.nextFloat();
                        System.out.println("Indique el segundo operando: ");
                        operandoDos = scanner.nextFloat();
                        if (operandoDos != 0) {
                            resultado = operandoUno % operandoDos;
                            System.out.println("El resultado de la operación es: " + resultado);
                            log.println("Módulo: " + operandoUno + " % " + operandoDos + " = " + resultado);
                        } else {
                            System.out.println("Error: Módulo por cero no permitido.");
                            log.println("Error: Módulo por cero.");
                        }
                        break;
                    }
                    default:
                        System.out.println("La opción seleccionada no existe.");
                        log.println("Error: Opción no válida seleccionada.");
                        break;
                }

            } while (!esCerrado);

            scanner.close();

        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo de log.");
            try (FileWriter fwError = new FileWriter("log.txt", true);
                 PrintWriter logError = new PrintWriter(fwError)) {
                logError.println("ERROR: " + e.getMessage());
            } catch (IOException ex) {
                System.err.println("No se pudo registrar el error en el archivo de log.");
            }
        }
    }
}
