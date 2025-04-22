/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package polinomio;
import java.util.Scanner;


/**
 *
 * @author SANCHEZ
 */
public class Polinomio {

    public static int[] multiplicar(int[] A, int[] B) {
        int n = A.length + B.length - 1;
        int[] resultado = new int[n];
        multiplicarRec(A, B, resultado, 0, A.length - 1, 0, B.length - 1);
        return resultado;
    }

    private static void multiplicarRec(int[] A, int[] B, int[] resultado, int ai, int aj, int bi, int bj) {
        // Caso base
        if (ai == aj && bi == bj) {
            resultado[ai + bi] += A[ai] * B[bi];
            return;
        }

        // Dividir A
        int amid = (ai + aj) / 2;
        // Dividir B
        int bmid = (bi + bj) / 2;

        // Recursivamente multiplicar combinaciones de mitades
        multiplicarRec(A, B, resultado, ai, amid, bi, bmid);         // Aizq * Bizq
        if (bmid + 1 <= bj)
            multiplicarRec(A, B, resultado, ai, amid, bmid + 1, bj); // Aizq * Bder
        if (amid + 1 <= aj)
            multiplicarRec(A, B, resultado, amid + 1, aj, bi, bmid); // Ader * Bizq
        if (amid + 1 <= aj && bmid + 1 <= bj)
            multiplicarRec(A, B, resultado, amid + 1, aj, bmid + 1, bj); // Ader * Bder
    }

    public static void imprimirPolinomio(int[] P) {
        for (int i = P.length - 1; i >= 0; i--) {
            if (P[i] != 0) {
                System.out.print((P[i] > 0 && i != P.length - 1 ? "+" : "") + P[i] + "x^" + i + " ");
            }
        }
        System.out.println();
    }

    public static int[] leerPolinomio(Scanner sc) {
        System.out.print("Ingrese el grado del polinomio: ");
        int grado = sc.nextInt();
        int[] coef = new int[grado + 1];

        System.out.println("Ingrese los coeficientes desde el término independiente hasta el de mayor grado:");
        for (int i = 0; i <= grado; i++) {
            System.out.print("Coeficiente de x^" + i + ": ");
            coef[i] = sc.nextInt();
        }
        return coef;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Multiplicación de Polinomios ===");
        System.out.println("Polinomio A:");
        int[] A = leerPolinomio(sc);

        System.out.println("Polinomio B:");
        int[] B = leerPolinomio(sc);

        int[] resultado = multiplicar(A, B);

        System.out.print("Resultado: ");
        imprimirPolinomio(resultado);
    }
}
    

