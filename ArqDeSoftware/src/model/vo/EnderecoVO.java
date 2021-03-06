package model.vo;

public class EnderecoVO {

	private int idEnd;
	private String rua;
	private int num;
	private String bairro;
	private String municipio;
	private int cep;
	
	public EnderecoVO(int idEnd, String rua, int num, String bairro, String municipio, int cep) {
		super();
		this.idEnd = idEnd;
		this.rua = rua;
		this.num = num;
		this.bairro = bairro;
		this.municipio = municipio;
		this.cep = cep;
	}

	public EnderecoVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdEnd() {
		return idEnd;
	}

	public void setIdEnd(int idEnd) {
		this.idEnd = idEnd;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public int getCep() {
		return cep;
	}

	public void setCep(int cep) {
		this.cep = cep;
	}
	
}
