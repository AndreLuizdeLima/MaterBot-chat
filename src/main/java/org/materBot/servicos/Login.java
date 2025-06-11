package org.materBot.servicos;

import java.util.Scanner;

import static org.materBot.servicos.Relatorios.relatorio;
import static org.materBot.servicos.Relatorios.relatorioPorProduto;

public class Login {
    public static void login(){
        Scanner scan = new Scanner(System.in);

        System.out.println("Área restrita: acesso permitido apenas para pessoas autorizadas.");
        System.out.print("Por favor, informe seu e-mail: ");
        String email = scan.nextLine();

        if (!email.equalsIgnoreCase("tia")) {
            System.out.println("E-mail incorreto. Acesso negado.");
            System.exit(0);
        }

        System.out.print("Agora, informe sua senha: ");
        String senha = scan.nextLine();

        if (!senha.equalsIgnoreCase("senha")) {
            System.out.println("Senha incorreta. Acesso negado.");
            System.exit(0);
        }

        System.out.println("Acesso autorizado. Bem-vindo(a)!");
        relatorio();
        relatorioPorProduto();
    }
}
