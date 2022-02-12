package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CarroDAO {

		public CarroDAO() {
			
		}
		
		public void addCarro(Carro carro) {
			Conexao c = Conexao.getInstance();
			Connection con = c.getConnection();
			
			try {
				PreparedStatement p = con.prepareStatement("insert into carro (modelo, ano_carro) values (?, ?)");
				p.setString(1, carro.getModelo());
				p.setInt(2, carro.getAno_carro());
				
				System.out.println(p);
				p.executeUpdate();
				System.out.println("Comando executado");
				p.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
		public ArrayList<Carro> exibir(){
			Conexao c = Conexao.getInstance();
			Connection con = c.getConnection();
			ArrayList<Carro> lista = new ArrayList<Carro>();
			try {
				PreparedStatement p = con.prepareStatement("select * from carro");
				ResultSet r = p.executeQuery();
				
				while (r.next()) {
					Integer id_carro = r.getInt("id_carro");
					String modelo = r.getString("modelo");
					Integer ano_carro = r.getInt("ano_carro");
					Carro carro = new Carro(id_carro, modelo, ano_carro);
					carro.setId_carro(id_carro);
					lista.add(carro);
	}
				r.close();
				p.close();
				con.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
			return lista;
		}
		public void removeCarro(Integer id) {
			Conexao c = Conexao.getInstance();
			Connection con = c.getConnection();
			
			try {
				PreparedStatement p = con.prepareStatement("delete from carro where id = ?");
				p.setInt(1, id);
				System.out.println(p);
				p.executeUpdate();
				System.out.println("Comando executado");
				p.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		public void updateCarro(Carro updateCarro) {
			Conexao c = Conexao.getInstance();
					Connection con = c.getConnection();
					try {
						PreparedStatement p = con.prepareStatement("update carro set modelo = ?, ano_carro = ? where id = ?");
						p.setString(1, updateCarro.getModelo());
						p.setInt(2, updateCarro.getAno_carro());
						System.out.println(p);
						p.executeUpdate();
						System.out.println("");
						p.close();
					}catch (SQLException e) {
						e.printStackTrace();
					}
		}
		public Carro buscarCarro(Integer id) {
			Conexao c = Conexao.getInstance();
			Connection con = c.getConnection();
			Carro u = null;
			try {
				PreparedStatement p = con.prepareStatement("select * from carro where id = ?");
				p.setInt(1, id);
				ResultSet r = p.executeQuery();

				while (r.next()) {
					Integer id_carro = r.getInt("id_carro");
					String modelo = r.getString("modelo");
					Integer ano_carro = r.getInt("ano_carro");
					u = new Carro(id_carro, modelo, ano_carro);
					u.setId_carro(id_carro);
				}
				r.close();
				p.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return u;
			}

		}

