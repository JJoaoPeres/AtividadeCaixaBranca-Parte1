

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
            Class.forName("com.mysql.Driver.Manager").newInstance();                  ( )
            String url = "jdbc:mysql://127.0.0.1/test?user=lopes&password=123";       (5)
            conn = DriverManager.getConnection(url);                                  ( )
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

        try { (10)
            Statement st = conn.createStatement();  ( 11 )
            ResultSet rs = st.executeQuery(sql);    ( 12 )
            if (rs.next()) { (13)
                nome = rs.getString("nome"); ( 14 )
                result = true;               ( 15 )
            }  (16)
        } catch (Exception e) { (17)
        } 
        return result; (18)
    }
}
// fim da classe

```
NOTAÇÃO DE GRAFO DE FLUXO 

<img width="1024" height="768" alt="Yellow and White Modern Recruitment Process Flow Chart Graph" src="https://github.com/user-attachments/assets/299dbc83-ec3e-4e41-8466-0f6bb253e736" />

COMPLEXIDADE CICLOMÁTICA 

FÓRMULA: M = E − N + 2P

23 - 22 + 2 = 3

CAMINHOS BÁSICOS:

Quando o connection da certo, e o if(rs.next() da certo e o usuário foi achado:
N1→N2→N3→N4→N5→N7→N8→N9→N10→N11→N12→N13→N14→N15→N17→N18→N19→N20→N21→N22
Quando o connection da certo, e o if(rs.next() da errado indo para o catch e o usuário não foi achado:
N1→N2→N3→N4→N5→N7→N8→N9→N10→N11→N16→N17→N18→N19→N20→N21→N22
Quando o connection da errado, e o if(rs.next() da errado indo para o catch e o usuário não foi achado: 
N1→N2→N6→N7→N8→N9→N10→N11→N16→N17→N18→N19→N20→N21→N22

