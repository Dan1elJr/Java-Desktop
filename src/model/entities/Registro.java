package model.entities;

import java.io.Serializable;

public class Registro implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private int linha;
	private String maquina;
	private String problema;
	private String causa;
	private String solucao;
	
	
	public Registro(int id, int linha, String maquina, String problema, String causa, String solucao) {
		this.id = id;
		this.linha = linha;
		this.maquina = maquina;
		this.problema = problema;
		this.causa = causa;
		this.solucao = solucao;
	}
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	
	public int getLinha() {
		return linha;
	}
	public void setLinha(int linha) {
		this.linha = linha;
	}
	public String getMaquina() {
		return maquina;
	}
	public void setMaquina(String maquina) {
		this.maquina = maquina;
	}
	public String getProblema() {
		return problema;
	}
	public void setProblema(String problema) {
		this.problema = problema;
	}
	public String getCausa() {
		return causa;
	}
	public void setCausa(String causa) {
		this.causa = causa;
	}
	public String getSolucao() {
		return solucao;
	}
	public void setSolucao(String solucao) {
		this.solucao = solucao;
	}


	
	
	
}
