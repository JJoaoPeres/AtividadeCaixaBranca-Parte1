package Login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class User {

    private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/test";
    private static final String DB_USER = "lopes";
    private static final String DB_PASS = "123";

    // Conecta ao banco
    private Connection conectarBD() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
    }

    // Verifica se o usuário existe
    public boolean verificarUsuario(String login, String senha) {
        boolean resultado = false; // começa como falso
        final String sql = "SELECT nome FROM usuarios WHERE login = ? AND senha = ?";

        try (Connection conn = conectarBD()) {

            // Verifica se a conexão deu certo
            if (conn == null) {
                System.out.println("Erro: conexao nula");
                return false;
            }

            // Prepara a query
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, login);
                ps.setString(2, senha);

                // Executa a consulta
                try (ResultSet rs = ps.executeQuery()) {

                    // Se houver resultado, usuário existe
                    if (rs.next()) {
                        String nome = rs.getString("nome");
                        System.out.println("Usuário encontrado: " + nome);
                        resultado = true;
                    } else {
                        System.out.println("Usuario nao encontrado.");
                    }
                }
            }

        } catch (Exception e) {
            System.out.println("Erro ao verificar usuario: " + e.getMessage());
        }

        // Retorna true se encontrou, false se não
        if (resultado) {
            System.out.println("Login valido");
        } else {
            System.out.println("Login invalido");
        }

        return resultado;
    }

}
