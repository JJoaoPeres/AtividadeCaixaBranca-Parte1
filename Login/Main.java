package Login;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        User usuario = new User();

        System.out.print("Digite o login: ");
        String login = sc.nextLine();

        System.out.print("Digite a senha: ");
        String senha = sc.nextLine();

        boolean autenticado = usuario.verificarUsuario(login, senha);

        if (autenticado) {
            System.out.println("Usuário autenticado com sucesso!");
            System.out.println("Bem-vindo, " + usuario.nome + "!");
        } else {
            System.out.println("Login ou senha incorretos.");
        }

        sc.close();
    }
}