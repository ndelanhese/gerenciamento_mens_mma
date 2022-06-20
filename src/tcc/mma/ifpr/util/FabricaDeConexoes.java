package tcc.mma.ifpr.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaDeConexoes {

private static final String DATA_URL = "jdbc:mysql://185.213.81.1:3306/u310218112_tcc_mma?zeroDateTimeBehavior=convertToNull";
private static final String DATA_USER = "u310218112_mens_modas";
private static final String DATA_PASSWORD = "0987Mens_Modas";

public static Connection criarConexaoParaMySQL() throws SQLException{
    Connection connection = DriverManager.getConnection(DATA_URL, DATA_USER, DATA_PASSWORD);
    
return connection;
}    

public static int conec(){
    int a = 2;
    try {
       Connection con = criarConexaoParaMySQL();
       if(con != null){
           // System.out.println("Conexao realizada com sucesso! " + con);
            a =1;
            con.close();
        }else{
           a =0;
       }
    } catch (SQLException e) {
        a = 0;
    }
    return a;
}

    public static void main(String[] args) throws SQLException {
        Connection con = criarConexaoParaMySQL();
        /*
        if(con != null){
            System.out.println("Conexao realizada com sucesso! " + con);
            con.close();
        }
        */
    }

}
