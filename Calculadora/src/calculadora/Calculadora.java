/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package calculadora;

import java.util.Scanner;

/**
 *
 * @author SANCHEZ
 */
public class Calculadora {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x=0,r;
        while(x!=7){
            System.out.println("Bienvenido a la calculadora recursiva");
            System.out.println("Seleccione la operacion que desea realizar:");
            System.out.println("1. Suma");
            System.out.println("2. Resta");
            System.out.println("3. Multiplicacion");
            System.out.println("4. Division");
            System.out.println("5. Potencia");
            System.out.println("6. Factorial");
            System.out.println("7. Salir");
            x = scanner.nextInt();
            if(x!=7){
            r = comprobarOperacion(x);
            System.out.println(r);
            }
            
        }
        
    }
    public static int comprobarOperacion(int x){
        int a,b,resultado = 0;
        Scanner scanner = new Scanner(System.in);
        if(x!=5 && x!=6){
            System.out.println("Digite el primer numero:");
            a = scanner.nextInt();
            System.out.println("Digite el segundo numero:");
            b = scanner.nextInt();
            if(x==1)
                resultado = suma(a,b);
            if (x==2)
                resultado = resta(a,b);
            if (x==3)
                resultado = multiplicar(a,b);
            if (x==4)
                resultado = dividir(a,b);
        }
        else if(x==5){
            System.out.println("Digite la base:");
            a = scanner.nextInt();
            System.out.println("Digite la potencia:");
            b = scanner.nextInt();
            resultado = potencia(a,b);
        }
        else if (x==6){
            System.out.println("Digite el numero a operar:");
            a = scanner.nextInt();
            resultado = factorial(a);
        }
        return resultado;
    }
    public static int suma(int a, int b) {
        if (b == 0) return a;
        return suma(a + 1, b - 1);
    }

    
    public static int resta(int a, int b) {
        if (b == 0) return a;
        return resta(a - 1, b - 1);
    }

    
    public static int multiplicar(int a, int b) {
        if (b == 0) return 0;
        return a + multiplicar(a, b - 1);
    }

    
    public static int dividir(int a, int b) {
        if (a < b) return 0;
        return 1 + dividir(a - b, b);
    }

    
    public static int potencia(int base, int exponente) {
        if (exponente == 0) return 1;
        return base * potencia(base, exponente - 1);
    }

    
    public static int factorial(int n) {
        if (n <= 1) return 1;
        return n * factorial(n - 1);
    }
}
    

