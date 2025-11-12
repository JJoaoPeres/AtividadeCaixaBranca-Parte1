

Link Excel: https://1drv.ms/x/c/49b51658f93dc409/EY_8RKFIQE9Ljo3ge9OItvIBNdgqGKaRvAOe0_O-ASdFQQ?e=tlzTCg
<img width="1044" height="565" alt="image" src="https://github.com/user-attachments/assets/04ec1869-276e-48a6-9171-316bea9503bd" />

Para acessar o código, segue caminho abaixo:

AtividadeCaixaBranca-Parte1>Login>User


Nos arquivos enviados pelo Git, foi incluída uma classe Main para realizar testes de execução e verificar o funcionamento do código, além de um diretório lib contendo o conector SQL.
Apesar disso, durante a execução ocorreu um erro informando que o banco de dados não existia.
Ainda assim, foi possível confirmar que a conexão com o servidor foi estabelecida com sucesso.

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
            ResultSet rs = st.executeQuery(sql);    ( 14 )
            if (rs.next()) { (15)
                nome = rs.getString("nome"); ( 16 )
                result = true;               (    )
            }  
        } catch (Exception e) { (17)
        } 
        return result; (18)
    }
}
// fim da classe

```
NOTAÇÃO DE GRAFO DE FLUXO 

<img width="1024" height="768" alt="Cópia de Cópia de Yellow and White Modern Recruitment Process Flow Chart Graph" src="https://github.com/user-attachments/assets/c35077fe-2770-4c2f-99b9-9d85c8c3d1b5" />

COMPLEXIDADE CICLOMÁTICA 

FÓRMULA: M = E − N + 2P

19 - 18 + 2 = 3

CAMINHOS BÁSICOS:

Quando o connection da certo, e o if(rs.next() da certo e o usuário foi achado:

1-2-3-4-5-7-8-9-10-11-12-13-14-15-16-18
Quando o connection da certo, e o if(rs.next() da errado indo para o catch e o usuário não foi achado:

1-2-3-4-5-7-8-9-10-11-12-13-14-17-18
Quando o connection da errado, e o if(rs.next() da errado indo para o catch e o usuário não foi achado: 

1-2-3-4-5-6-8-9-10-11-12-13-14-17-18

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
→ (8 → 9 → 10 → 11 → 12 → 13 → 14 → 15 → 16 → 18)

Caminho 2: Conexão e consulta bem-sucedidas, mas rs.next() falso (usuário não encontrado)
→ (8 → 9 → 10 → 11 → 12 → 13 → 14 → 18)

Caminho 3: Erro ao executar a query (entra no bloco catch)
→ (8 → 9 → 10 → 11 → 12 → 17 → 18)

Caminho 4: Falha na conexão (conn = null, o try interno falha)
→ (8 → 9 → 10 → 12 → 17 → 18)


