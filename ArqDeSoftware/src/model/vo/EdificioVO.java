package model.vo;

public class EdificioVO {

	private int qtdApto;
	private EnderecoVO end;
	private int qtdBloco;
	private String nomeSindico;
	private String nomeZelador;
	private boolean gasIndividual;
	private String nomeEdificio;
	private int idadeEdificio;
	private String email;
	private int telContato;
	
	public EdificioVO(int qtdApto, EnderecoVO end, int qtdBloco, String nomeSindico, String nomeZelador,
			boolean gasIndividual, String nomeEdificio, int idadeEdificio, String email, int telContato) {
		super();
		this.qtdApto = qtdApto;
		this.end = end;
		this.qtdBloco = qtdBloco;
		this.nomeSindico = nomeSindico;
		this.nomeZelador = nomeZelador;
		this.gasIndividual = gasIndividual;
		this.nomeEdificio = nomeEdificio;
		this.idadeEdificio = idadeEdificio;
		this.email = email;
		this.telContato = telContato;
	}
	
	public EdificioVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getQtdApto() {
		return qtdApto;
	}
	public void setQtdApto(int qtdApto) {
		this.qtdApto = qtdApto;
	}
	public EnderecoVO getEnd() {
		return end;
	}
	public void setEnd(EnderecoVO end) {
		this.end = end;
	}
	public int getQtdBloco() {
		return qtdBloco;
	}
	public void setQtdBloco(int qtdBloco) {
		this.qtdBloco = qtdBloco;
	}
	public String getNomeSindico() {
		return nomeSindico;
	}
	public void setNomeSindico(String nomeSindico) {
		this.nomeSindico = nomeSindico;
	}
	public String getNomeZelador() {
		return nomeZelador;
	}
	public void setNomeZelador(String nomeZelador) {
		this.nomeZelador = nomeZelador;
	}
	public boolean isGasIndividual() {
		return gasIndividual;
	}
	public void setGasIndividual(boolean gasIndividual) {
		this.gasIndividual = gasIndividual;
	}
	public String getNomeEdificio() {
		return nomeEdificio;
	}
	public void setNomeEdificio(String nomeEdificio) {
		this.nomeEdificio = nomeEdificio;
	}
	public int getIdadeEdificio() {
		return idadeEdificio;
	}
	public void setIdadeEdificio(int idadeEdificio) {
		this.idadeEdificio = idadeEdificio;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getTelContato() {
		return telContato;
	}
	public void setTelContato(int telContato) {
		this.telContato = telContato;
	}
		
}
