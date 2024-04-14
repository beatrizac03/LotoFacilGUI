import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Lotofacil {
    public static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        menu();
    }

    public static void menu() throws IOException {

        int opcaoMenu = 55;

        do {
            System.out.println("");
            System.out.println("                                        .........................................");
            System.out.println("                                        .              Menu LOTOFÁCIL           .");
            System.out.println("                                        .           1) Apostar de 0 a 100       .");
            System.out.println("                                        .           2) Apostar de A à Z         .");
            System.out.println("                                        .           3) Apostar em par ou ímpar  .");
            System.out.println("                                        .           0) Sair                     .");
            System.out.println("                                        .........................................");
            System.out.print("                                        . Opção: ");
            opcaoMenu = scn.nextInt();

            switch(opcaoMenu) {
                case 0:
                    System.out.println("");
                    System.out.println("                                        OBRIGADO POR ESCOLHER A LOTOFÁCIL!");
                    break;
                case 1:
                    aposta1();
                    break;
                case 2:
                    aposta2();
                    break;
                case 3:
                    aposta3();
                    break;
                default:
                    System.out.println("                                        Opção inexistente. Tente novamente!");
                    break;
            }

        } while(opcaoMenu != 0);
    }

    public static void aposta1() {
        System.out.println("                                               APOSTAR DE 0 A 100");
        System.out.print("                                          Digite um número: ");
        int aposta1 = scn.nextInt();

        if(aposta1 > 100 || aposta1 < 0) {
            System.out.println("                                          Aposta inválida!");
        }
        else {
            Random random1 = new Random();
            int randomNumber1 = random1.nextInt(101);
            if(aposta1 == randomNumber1) {
                System.out.println("                                          Número sorteado: " + randomNumber1);
                System.out.println("                                          Você ganhou R$ 1.000,00 reais!");
            } else {
                System.out.println("                                          Que pena! O número sorteado foi: " + randomNumber1);
            }
        }
    }

    public static void aposta2() throws IOException {
        System.out.println("                                               APOSTAR DE A à Z");
        System.out.print("                                          Digite uma letra: ");
        int aposta2 = System.in.read();
        if(Character.isLetter(aposta2)) {
            String resulAposta2 = (Character.toUpperCase(aposta2) == 'B') ? "Você ganhou R$ 500,00 reais" : "Que pena a letra sorteada foi: B";
            System.out.println("                                          " + resulAposta2);
        } else {
            System.out.println("                                          Aposta inválida!");
        }
    }

    public static void aposta3() {
        System.out.println("                                               APOSTAR EM PAR OU ÍMPAR");
        System.out.print("                                          Digite um número: ");

        if (scn.hasNextInt()) {
            int aposta3 = scn.nextInt();
            String resulAposta3 = (aposta3 % 2 == 0) ? "Você ganhou R$ 100,00 reais!" : "Que pena! O número digitado é ímpar e a premiação foi para números pares.";
            System.out.println("                                          " + resulAposta3);
        } else {
            scn.next();
            System.out.println("                                          Você não digitou um caractere válido. Tente novamente!");
        }
    }

}
