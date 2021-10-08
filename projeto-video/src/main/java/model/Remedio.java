package model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Remedio implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idRemedio;
	private String nome;
	private String laboratorio;
	private String dataVencimento;
	
	public Remedio(Integer idRemedio, String nome, String laboratorio, String dataVencimento) {
		super();
		this.idRemedio = idRemedio;
		this.nome = nome;
		this.laboratorio = laboratorio;
		this.dataVencimento = dataVencimento;
	}
	
	public Remedio() {
		
	}

	public Integer getIdRemedio() {
		return idRemedio;
	}

	public void setIdRemedio(Integer idRemedio) {
		this.idRemedio = idRemedio;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLaboratorio() {
		return laboratorio;
	}

	public void setLaboratorio(String laboratorio) {
		this.laboratorio = laboratorio;
	}

	public String getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(String dataVencimento) {
		this.dataVencimento = dataVencimento;
	}
	
	
}
