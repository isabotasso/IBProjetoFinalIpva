package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



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
	public ArrayList<Ipva> getListIpva(){
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		ArrayList<Ipva> lista = new ArrayList<Ipva>();
		try {
			PreparedStatement p = con.prepareStatement("select * from ipva");
			ResultSet r = p.executeQuery();
			
			while (r.next()) {
				Integer id_ipva = r.getInt ("id_ipva");
				Integer ano_ipva = r.getInt("ano_ipva");
				Ipva ipva = new Ipva(id_ipva, ano_ipva);
				ipva.setId_ipva(id_ipva);
				lista.add(ipva);
}
			r.close();
			p.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}
	public void removeIpva(Integer id) {
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		
		try {
			PreparedStatement p = con.prepareStatement("delete from ipva where id = ?");
			p.setInt(1, id);
			System.out.println(p);
			p.executeUpdate();
			System.out.println("Comando executado");
			p.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void updateIpva(Ipva updateIpva) {
		Conexao c = Conexao.getInstance();
				Connection con = c.getConnection();
				try {
					PreparedStatement p = con.prepareStatement("update ipva set ano_ipva = ? where id = ?");
					p.setInt(1, updateIpva.getAno_ipva());
					System.out.println(p);
					p.executeUpdate();
					System.out.println("");
					p.close();
				}catch (SQLException e) {
					e.printStackTrace();
				}
	}
	public Ipva buscarIpva(Integer id) {
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		Ipva u = null;
		try {
			PreparedStatement p = con.prepareStatement("select * from ipva where id = ?");
			p.setInt(1, id);
			ResultSet r = p.executeQuery();

			while (r.next()) {
				Integer id_ipva = r.getInt("id_ipva");
				Integer ano_ipva = r.getInt("ano_ipva");
				u = new Ipva(id_ipva, ano_ipva);
				u.setId_ipva(id_ipva);
			}
			r.close();
			p.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
		}

	}
