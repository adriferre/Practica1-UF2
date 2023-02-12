/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

import java.util.Scanner;

/**
 *
 * @author esther
 */
public class Practica1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String operacion;
        boolean comprobar = false;

        do {

            double n1 = pedirOperador1();

            operacion = PedirOperacion(comprobar);

            double n2 = pedirOperador2();

            double res = operacion(n1, n2, operacion, true);
            mostrarResultado(n1, n2, operacion, res);
            comprobar = true;
            operacion = repetir(comprobar);

        } while (operacion.equals("s") || operacion.equals("S"));
    }

    public static double pedirOperador1() {
        Scanner sc = new Scanner(System.in);
        String numero1;
        do {
            System.out.print("\n Introdueix el primer numero.\n> ");
            numero1 = sc.nextLine();
        } while (!numero1.matches("[+-]?[\\d]*[.]?[\\d]+"));
        double nume1 = Double.parseDouble(numero1);
        double n1 = new Double(numero1);
        return n1;
    }

    public static double pedirOperador2() {
        Scanner sc = new Scanner(System.in);
        String numero2;
        do {
            System.out.print("\n Introdueix el segon numero.\n> ");
            numero2 = sc.nextLine();
        } while (!numero2.matches("[+-]?[\\d]*[.]?[\\d]+"));
        double nume2 = Double.parseDouble(numero2);
        double n2 = new Double(numero2);
        return n2;
    }

    public static String PedirOperacion(boolean comprobar) {
        Scanner sc = new Scanner(System.in);
        String operacion;
        do {
            System.out.println("\n Operació? (Indica el signe)");
            System.out.print(" + = sumar \n - = restar \n"
                    + " x = multiplicar \n / = dividir \n * = elevar primer num al segon num."
                    + "\n % = residu\n> ");
            operacion = sc.nextLine();
            if (operacion.equals("+") || operacion.equals("-") || operacion.equals("x")
                    || operacion.equals("X") || operacion.equals("/") || operacion.equals("%")
                    || operacion.equals("*")) {
                comprobar = true;
            } else {
                comprobar = false;
            }
        } while (comprobar != true);
        return operacion;
    }

    public static double operacion(double n1, double n2, String operacion, boolean comprobar) {
        double res = 0;
        Scanner sc = new Scanner(System.in);
        String numero2;
        double nume2;
        do {
            switch (operacion) {
                case "+":
                    res = n1 + n2;
                    break;
                case "-":
                    res = n1 - n2;
                    break;
                case "x":
                case "X":
                    res = n1 * n2;
                    break;
                case "/":
                    while (n2 == 0) {
                        do {
                            System.err.print(" Al denominador hi ha un zero \n"
                                    + "per a  evitar errors coloca un altre valor.\n>");
                            numero2 = sc.nextLine();
                        } while (!numero2.matches("[+-]?[\\d]*[.]?[\\d]+"));
                        nume2 = Double.parseDouble(numero2);
                        n2 = new Double(numero2);
                    }
                    res = n1 / n2;
                    break;
                case "*":
                    res = Math.pow(n1, n2);
                    break;
                case "%":
                    while (n2 == 0) {
                        do {
                            System.err.print(" Al denominador hi ha un zero \n"
                                    + "per a  evitar errors coloca un altre valor.\n> ");
                            numero2 = sc.nextLine();
                        } while (!numero2.matches("[+-]?[\\d]*[.]?[\\d]+"));
                        nume2 = Double.parseDouble(numero2);
                        n2 = new Double(numero2);
                    }
                    res = n1 % n2;
                    break;
            }
        } while (comprobar != true);
        return res;

    }

    public static void mostrarResultado(double n1, double n2, String operacion, double res) {
        System.out.println("\n(" + n1 + ") "
                + operacion + " (" + n2 + ")" + " = " + res);
        System.out.println("\n Vols continuar operant? \n");
        System.out.print(" [s/n]\n> ");
    }

    public static String repetir(boolean comprobar) {
        Scanner sc = new Scanner(System.in);
        String operacion = "";
        do {

            operacion = sc.nextLine();

            switch (operacion) {
                case "s":
                case "S":
                case "n":
                case "N":
                    break;
                default:
                    System.err.print("\n Error, posa un valor vàlid.\n> ");
                    comprobar = false;
            }
        } while (comprobar != true);
        return operacion;
    }
}
