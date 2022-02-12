package model;

public class Carro {
 private Integer id_carro;
 private String modelo;
 private Integer ano_carro;
 
 public Carro (Integer id_carro, String modelo, Integer ano_carro) {
	 super();
	 this.id_carro = id_carro;
	 this.modelo = modelo;
	 this.ano_carro = ano_carro;
	 
	 }

public Integer getId_carro() {
	return id_carro;
}

public void setId_carro(Integer id_carro) {
	this.id_carro = id_carro;
}

public String getModelo() {
	return modelo;
}

public void setModelo(String modelo) {
	this.modelo = modelo;
}

public Integer getAno_carro() {
	return ano_carro;
}

public void setAno_carro(Integer ano_carro) {
	this.ano_carro = ano_carro;
}

@Override
public String toString() {
	return "Carro [id_carro=" + id_carro + ", modelo=" + modelo + ", ano_carro=" + ano_carro + "]";
}
 


}
