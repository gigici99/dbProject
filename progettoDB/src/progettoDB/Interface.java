package progettoDB;

import java.sql.*;

import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class Interface {

	private static Connection con = null ;
	public static String connessione () {

		try {
			//caricamento e registrazione driver
			String s=" ";
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url ="jdbc:mysql://localhost:3306/Spotify?useSSL=false&serverTimezone=UTC";
			String username = "root";
			String pwd = "One_plus3t";  
			con = DriverManager.getConnection(url,username,pwd);
			s="Connessione riuscita!!";
			return s;
		}
		catch(Exception e)
		{
			return "Connessione fallita";  
		}
	}

	public static String uscita() {

		try {
			con.close();
			return "Connessione chiusa correttamente\n";
		} catch (SQLException e) {
			return "Chiusura connessione fallita\n";
		}
	}

	public static void query1(String nome_cognome,String data,String cf,String email,String password)  {

		try {
			String sql="INSERT INTO Cliente(nome_cognome, data_di_nascita, cf, email, passwd, abbonamento) VALUES(?,?,?,?,?,?)";

			PreparedStatement query = con.prepareStatement(sql);
			query.setString(1, nome_cognome);
			query.setString(2, data);
			query.setString(3, cf);
			query.setString(4,email);
			query.setString(5, password);
			query.setString(6,"1");
			query.executeUpdate();
			query.close();

		}
		catch (SQLException e)
		{
			System.out.println(e);
			JPanel pane= new JPanel();
			JOptionPane.showMessageDialog(pane,"Inserisci i dati correttamente","Dati sbagliati", JOptionPane.ERROR_MESSAGE);
		}
	}

	public static String query2() {

		try {
			String s="";
			String sql =  "SELECT nome_arte FROM Artista;";

			PreparedStatement query = con.prepareStatement(sql);
			ResultSet rs= query.executeQuery();

			while(rs.next())
			{
				s+=rs.getString(1)+"\n";
			}
			query.close();
			return s;
		}
		catch (NumberFormatException |SQLException e )
		{
			System.out.println(e);
			return null;
		}
	}

	public static void query3(int id, String email) {

		try {


			String sql="UPDATE Cliente SET abbonamento=2 WHERE id=?";
			String sql2="INSERT INTO Paypal (email,id) VALUES (?,?)";
			PreparedStatement query = con.prepareStatement(sql);
			PreparedStatement query2 = con.prepareStatement(sql2);
			query.setInt(1, id);
			query2.setString(1, email);
			query2.setInt(2, id);
			query.executeUpdate();
			query2.executeUpdate();
			query.close();
			query2.close();
		}
		catch (SQLException e)
		{
			System.out.println(e);
			JPanel pane= new JPanel();
			JOptionPane.showMessageDialog(pane,"Inserisci i dati correttamente","Dati sbagliati", JOptionPane.ERROR_MESSAGE);
		}	
	}

	public static void query4(int id) {

		try {
			String sql="UPDATE Cliente SET abbonamento=1 WHERE id=?";
			String sql2="DELETE FROM Paypal WHERE id=?";
			PreparedStatement query = con.prepareStatement(sql);
			PreparedStatement query2 = con.prepareStatement(sql2);
			query.setInt(1, id);
			query2.setInt(1, id);
			query.executeUpdate();
			query2.executeUpdate();
			query.close();
			query2.close();
		}
		catch (SQLException e)
		{
			System.out.println(e);
			JPanel pane= new JPanel();
			JOptionPane.showMessageDialog(pane,"Inserisci i dati correttamente","Dati sbagliati", JOptionPane.ERROR_MESSAGE);
		}	

	}

	public static void query5(int id) {

		try {


			String sql="DELETE FROM Paypal WHERE id=?";
			String sql2="DELETE FROM Cliente WHERE id=?";
			PreparedStatement query = con.prepareStatement(sql);
			PreparedStatement query2 = con.prepareStatement(sql2);
			query.setInt(1, id);	
			query2.setInt(1, id);	
			query.executeUpdate();
			query2.executeUpdate();
			query2.close();
			query.close();
		}
		catch (SQLException e)
		{
			System.out.println(e);
			JPanel pane= new JPanel();
			JOptionPane.showMessageDialog(pane,"Inserisci i dati correttamente","Dati sbagliati", JOptionPane.ERROR_MESSAGE);
		}	

	}

	public static String query6() {

		String r="";
		try {

			Statement query = con.createStatement();
			
			ResultSet result = query.executeQuery("SELECT nome_arte, count(nome_arte) FROM Brano GROUP BY nome_arte");

			while (result.next())
			{
				String nome = result.getString("nome_arte");
				String brani = result.getString("count(nome_arte)");
				r+=nome+" "+brani+"\n";

			} 
			result.close();
			query.close();
			return r;

		}
		catch (SQLException e)
		{
			System.out.println(e);
			JPanel pane= new JPanel();
			JOptionPane.showMessageDialog(pane,"Inserisci i dati correttamente","Dati sbagliati", JOptionPane.ERROR_MESSAGE);
			return null;
		}
	}

	public static void query7 (String titolo, String durata, String nome_arte) {

		try {
			
			String sql="INSERT INTO Brano(titolo, durata, nome_arte) VALUES(?,?,?)";
			PreparedStatement query = con.prepareStatement(sql);
			query.setString(1, titolo);
			query.setString(2, durata);
			query.setString(3, nome_arte);
			query.executeUpdate();
			query.close();
		}
		catch (SQLException e)
		{
			System.out.println(e);
			JPanel pane= new JPanel();
			JOptionPane.showMessageDialog(pane,"Inserisci i dati correttamente","Dati sbagliati", JOptionPane.ERROR_MESSAGE);
		}
	}

	public static String query8() {
		String r="";
		try {

			Statement query = con.createStatement();
			ResultSet result = query.executeQuery("SELECT titolo, durata, nome_arte FROM Brano");

			while (result.next())
			{
				String nome = result.getString("titolo");
				String brani = result.getString("durata");
				String artista = result.getString("nome_arte");
				r+=nome+" "+brani+" "+artista+"\n";
			} 
			result.close();
			query.close();
			return r;

		}
		catch (SQLException e)
		{
			System.out.println(e);
			JPanel pane= new JPanel();
			JOptionPane.showMessageDialog(pane,"Inserisci i dati correttamente","Dati sbagliati", JOptionPane.ERROR_MESSAGE);
			return null;
		}

	}

	public static String query9(String nome) {

		String r="";
		try {

			String sql = "SELECT titolo FROM Brano where nome_arte=?";
			PreparedStatement query = con.prepareStatement(sql);
			query.setString(1, nome);
			ResultSet result= query.executeQuery();

			while (result.next())
			{  
				String titolo= result.getString("titolo");
				r+=titolo+"\n";
			}

			result.close();
			query.close();
			return r;

		}
		catch (SQLException e)
		{
			System.out.println(e);
			JPanel pane= new JPanel();
			JOptionPane.showMessageDialog(pane,"Inserisci i dati correttamente","Dati sbagliati", JOptionPane.ERROR_MESSAGE);
			return null;
		}

	}

	public static String query10() {

		String r="";
		try {

			String sql = "SELECT id, nome_cognome,email, data_di_nascita, cf, abbonamento FROM Cliente";
			PreparedStatement query = con.prepareStatement(sql);
			ResultSet result= query.executeQuery();

			while (result.next())
			{  
				String id = result.getString("id");
				String nome= result.getString("nome_cognome");
				String email= result.getString("email");
				String data=result.getString("data_di_nascita");
				String codfis=result.getString("cf");
				String abbona=result.getString("abbonamento");
			 
				r+=id+" "+nome+" "+email+" "+data+" "+codfis+" "+abbona+"\n";
			}

			result.close();
			query.close();
			return r;

		}
		catch (SQLException e)
		{
			System.out.println(e);
			JPanel pane= new JPanel();
			JOptionPane.showMessageDialog(pane,"Inserisci i dati correttamente","Dati sbagliati", JOptionPane.ERROR_MESSAGE);
			return null;
		}
	}
}
