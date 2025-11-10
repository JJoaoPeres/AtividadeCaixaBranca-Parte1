package Login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

//Classe responsável para a conexão com o banco e verificação de login de usuários
public class User {

    // Método para conectar ao banco de dados
    public Connection conectarBD() {
        Connection conn = null; //n1
        try { //n2
            Class.forName("com.mysql.cj.jdbc.Driver"); //n3
            String url = "jdbc:mysql://127.0.0.1/test?user=lopes&password=123"; //n4
            //estabelece a conexão com o banco
            conn = DriverManager.getConnection(url); //n5
        } catch (Exception e) { //n6
            e.printStackTrace();
        }
        return conn; //n7
    }

    public String nome = "";
    public boolean result = false;

    // Método para verificar o usuário se ele existe
    public boolean verificarUsuario(String login, String senha) {
        String sql = montarConsultaUsuario(login, senha); //n8
        try (Connection conn = conectarBD(); //n9
                 Statement st = conn.createStatement();//n10
                 ResultSet rs = st.executeQuery(sql)) {//n11
            //se houver usuário, vai haver resultado
            if (rs.next()) { //n12
                nome = rs.getString("nome"); //n13
                result = true; //n14
            } //n15

        } catch (Exception e) { //n16
            System.out.println("Erro ao verificar usuário: " + e.getMessage());
        }
        return result; //n17
    }

    // Método separado para montar a SQL
    private String montarConsultaUsuario(String login, String senha) {
        StringBuilder sb = new StringBuilder(); //n18
        sb.append("SELECT nome FROM usuarios "); //n19
        sb.append("WHERE login = '").append(login).append("' "); //n20
        sb.append("AND senha = '").append(senha).append("'"); //n21
        return sb.toString();//n22
    }
}
