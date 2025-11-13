

Link Excel: https://1drv.ms/x/c/49b51658f93dc409/Edkv_8tclGFLkYvqrDPH9A4B5gv8IwZmQ7f29v4mLbG2LA?e=CGmA1a

<img width="1044" height="565" alt="image" src="https://github.com/user-attachments/assets/dc7b269f-c55d-4e2c-bc5c-febd9bef6515" />


Para acessar o código, segue caminho abaixo:

AtividadeCaixaBranca-Parte1>Login>User

Nos arquivos enviados pelo Git, foi incluída uma classe Main para realizar testes de execução e verificar o funcionamento do código, além de um diretório lib contendo o conector SQL. Apesar disso, durante a execução ocorreu um erro informando que o banco de dados não existia.
Ainda assim, foi possível confirmar que a conexão com o servidor foi estabelecida com sucesso.

<img width="885" height="531" alt="Captura de tela 2025-11-09 211730" src="https://github.com/user-attachments/assets/0296f811-7959-4bad-86d6-7b96bae8c131" />

Na versão alterada, o código foi corrigido para funcionar corretamente e se tornar mais seguro e organizado. Foram aplicadas melhorias como o uso do driver certo (com.mysql.cj.jdbc.Driver), tratamento de erros com try-with-resources, uso de PreparedStatement para evitar SQL Injection, e inclusão de comentários explicando o funcionamento dos métodos. Essas mudanças deixaram o código mais limpo, seguro e fácil de entender.

AGORA ABAIXO SEGUE NOTAÇÃO DE GRAFO DE FLUXO; COMPLEXIDADE CICLOMÁTICA; CAMINHOS BÁSICOS.
```
package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

 public class User { (1)
 public Connection conectarBD() { (2)
     Connection conn = null; (3)
     try { (4)
            Class.forName("com.mysql.Driver.Manager").newInstance();                  (   )
            String url = "jdbc:mysql://127.0.0.1/test?user=lopes&password=123";       ( 5 )
            conn = DriverManager.getConnection(url);                                  (   )
        } catch (Exception e) { (6)
        }
        return conn; (7)
    }

    public String nome = ""; 
    public boolean result = false;

    public boolean verificarUsuario(String login, String senha) { (8)
        String sql = ""; (9)
        Connection conn = conectarBD(); (10)

        // INSTRUÇÃO SQL
        sql = "select nome from usuarios ";         (    )
        sql += "where login = '" + login + "'";     ( 11 )
        sql += " and senha = '" + senha + "'";      (    )

        try { (12)
            Statement st = conn.createStatement();  ( 13 )
            ResultSet rs = st.executeQuery(sql);    (    )
            if (rs.next()) { (14)
                nome = rs.getString("nome"); ( 15 )
                result = true;               (    )
            }  
        } catch (Exception e) { (16)
        } 
        return result; (17)
    }
}
// fim da classe

```
NOTAÇÃO DE GRAFO DE FLUXO 

<img width="1024" height="768" alt="Cópia de Cópia de Cópia de Yellow and White Modern Recruitment Process Flow Chart Graph" src="https://github.com/user-attachments/assets/6161fd74-fb39-470a-9d11-0f19306a3f77" />


COMPLEXIDADE CICLOMÁTICA 

FÓRMULA: M = E − N + 2P

18 - 17 + 2 = 3

CAMINHOS BÁSICOS:

Quando o connection da certo, e o if(rs.next() da certo e o usuário foi achado:

1-2-3-4-5-7-8-9-10-11-12-13-14-15-17 

Quando o connection da certo, e o if(rs.next() da errado indo para o catch e o usuário não foi achado:

1-2-3-4-5-7-8-9-10-11-12-13-16-17

Quando o connection da errado, e o if(rs.next() da errado indo para o catch e o usuário não foi achado: 

1-2-3-4-5-6-7-8-9-10-11-12-13-16-17

CAMINHOS INDEPENDENTES:

* Método conectarBD()

Complexidade ciclomática: 2

Há dois caminhos principais (com ou sem erro na conexão).

Caminhos independentes:

Caminho 1: Conexão estabelecida com sucesso 

→ (1 → 2 → 3 → 4 → 5 → 7)

Caminho 2: Exceção lançada ao tentar conectar

→ (1 → 2 → 3 → 4 → 5 → 6 → 7)

* Método verificarUsuario()

Complexidade ciclomática: 4

São quatro fluxos possíveis: sucesso total, usuário não encontrado, erro SQL, e falha na conexão.

Caminhos independentes:

Caminho 1: Conexão e consulta bem-sucedidas, rs.next() verdadeiro (usuário encontrado)

→ (8 → 9 → 10 → 11 → 12 → 13 → 14 → 15 → 17)

Caminho 2: Conexão e consulta bem-sucedidas, mas rs.next() falso (usuário não encontrado)

→ (8 → 9 → 10 → 11 → 12 → 13 → 14 → 17)

Caminho 3: Erro ao executar a query (entra no bloco catch)

→ (8 → 9 → 10 → 11 → 12 → 16 → 17)

Caminho 4: Falha na conexão (conn = null, o try interno falha)

→ (8 → 9 → 10 → 12 → 16 → 17)


