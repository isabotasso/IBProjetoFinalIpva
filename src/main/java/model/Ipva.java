package model;

public class Ipva {
	private Integer id_ipva;
	private Integer ano_ipva;
	
	
	public Ipva (Integer id_ipva, Integer ano_ipva) {
		super();
		this.id_ipva = id_ipva;
		this.ano_ipva = ano_ipva;
	}


	public Integer getId_ipva() {
		return id_ipva;
	}


	public void setId_ipva(Integer id_ipva) {
		this.id_ipva = id_ipva;
	}


	public Integer getAno_ipva() {
		return ano_ipva;
	}


	public void setAno_ipva(Integer ano_ipva) {
		this.ano_ipva = ano_ipva;
	}


	@Override
	public String toString() {
		return "Ipva [id_ipva=" + id_ipva + ", ano_ipva=" + ano_ipva + "]";
	}
	
	
}
