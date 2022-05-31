package main;

import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {

        long credit;
        int count = 0;
        int soma = 0;
        long divisor = 10;
        int ultimo;
        String result;
        long workingCC;
        int mult;

        //passo 0
        //Adquirir o número do cartão
        do {
            credit = Long.parseLong(JOptionPane.showInputDialog("Digite o número do cartão: "));
        } while (credit <= 0);
        //
        workingCC = credit;
        while (workingCC > 0) {
            ultimo = Integer.parseInt((workingCC % 10));
            System.out.println(ultimo);
            soma += ultimo;
            workingCC = workingCC / 100;

        }
        //
        workingCC = (credit / 10);
        while (workingCC > 0) {
            ultimo = Integer.parseInt((workingCC % 10));
            mult = (ultimo * 2);
            soma = (soma + (mult % 10) + (mult / 10));
            workingCC = workingCC / 100;
        }
        //
        workingCC = credit;
        while (workingCC != 0) {
            workingCC = workingCC / 10;
            count++;
        }
        //
        for (int i = 0; i < (count - 2); i++) {
            divisor = divisor * 10;
        }

        //
        System.out.println((credit/divisor));
        int primeiroDigito = Integer.parseInt((credit / divisor));
        int primeESegDigito = Integer.parseInt((credit / (divisor / 10)));
        //
        if ((soma % 10) == 0) {
            if (primeiroDigito == 4 && (count == 13 || count == 16)) {
                result = "VISA";
            } else if ((primeESegDigito == 34 || primeESegDigito == 37) && count == 15) {
                result = "AMEX";
            } else if ((primeESegDigito >= 51 && primeESegDigito <= 55) && count == 16) {
                result = "MASTERCARD";
            } else {
                result = "INVALID";
            }
        } else {
            result = "INVALID";
        }
        System.out.println(result);
    }

}
