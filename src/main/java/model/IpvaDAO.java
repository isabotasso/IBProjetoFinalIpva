package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class IpvaDAO {

	public IpvaDAO() {
		
	}
	
	public void addIpva(Ipva ipva) {
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		
		try {
			PreparedStatement p = con.prepareStatement("insert into ipva (ano_ipva) values (?)");
			p.setInt(1, ipva.getAno_ipva());
			
			System.out.println(p);
			p.executeUpdate();
			System.out.println("Comando executado");
			p.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
}
