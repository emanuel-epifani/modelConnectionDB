package modelconnectiondb.repository;

import modelconnectiondb.model.Studente;

import java.sql.*;
import java.util.ArrayList;


public class StudenteRepository {
    static final String DB_URL = "jdbc:mysql://localhost:3306/JavaDbStudente";
    static final String USER = "JavaDbStudente";
    static final String PASS = "JavaDbStudente";

    //Create
    public static void insertStudenti(Studente studente){
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement pstmt = null;
                pstmt = conn.prepareStatement("INSERT INTO studente (nome, cognome, genere) VALUES (?,?,?)");
                pstmt.setString(1, studente.getNome());//nome personaggio
                pstmt.setString(2, studente.getCognome() );//ruolo personaggio
                pstmt.setString(3, studente.getGenere());//isAlive
                pstmt.executeUpdate();
            pstmt.close(); //chiudo lo statement
            conn.close(); //chiudo la connessione
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());        }
    }

    //Read
    public static ArrayList<Studente> selectStudenti(){
        try {
            ArrayList<Studente> studentList = new ArrayList<>();
            Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM studente");
            while (rs.next()){
                Studente st = new Studente(
                        rs.getString("nome"),
                        rs.getString("cognome"),
                        rs.getString("genere")
                );
                studentList.add(st);
            }
            conn.close();
            stmt.close();
            return studentList;

        } catch (SQLException ex){
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return new ArrayList<>();
    }

    //Update
    public static void updateStudente(Studente studente){
        try {
            final String SQL_DELETE = "UPDATE studente SET nome=?,cognome=?,genere=? WHERE nome=?";
            Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
            PreparedStatement pstmt = conn.prepareStatement(SQL_DELETE);
            pstmt.setString(1,studente.getNome());
            pstmt.setString(2,studente.getCognome());
            pstmt.setString(3,studente.getGenere());
            pstmt.setString(4,"Zeno");
            int row = pstmt.executeUpdate();
            conn.close();
            pstmt.close();
        } catch (SQLException ex){
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }

    //Delete
    public static Studente deleteStudente(Studente studente){
        try {
            final String SQL_DELETE = "DELETE FROM studente WHERE nome=? AND cognome=? AND genere=?";
            Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
            PreparedStatement stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1,studente.getNome());
            stmt.setString(2,studente.getCognome());
            stmt.setString(3,studente.getGenere());
            int row = stmt.executeUpdate();
            conn.close();
            stmt.close();
            return studente;

        } catch (SQLException ex){
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return null;
    }
}
