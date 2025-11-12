package Login;

public class Main {

    public static void main(String[] args) {
        User u = new User();
        boolean ok = u.verificarUsuario("lopes", "123");
        if (ok) {
            System.out.println("Acesso permitido!");
        } else {
            System.out.println("Acesso negado!");
        }
    }
}
