package br.com.prog2.trabalho.negocio;
import java.time.LocalDate;
public class Hospedagem {
	private String codHospedagem;
	private String codCliente;
	private String codChale;
	private String estado;
	private LocalDate dataInicio;
	private LocalDate dataFim;
	private Integer qtdPessoas;
	private Double desconto;
	private Double valorFinal;
	
	public String getCodHospedagem() {
		return codHospedagem;
	}
	
	public String getCodChale() {
		return codChale;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public LocalDate getDataInicio() {
		return dataInicio;
	}
	
	public LocalDate getDataFim() {
		return dataFim;
	}
	
	public Integer getQtdPessoas() {
		return qtdPessoas;
	}
	
	public Double getDesconto() {
		return desconto;
	}
	
	public Double getValorFinal() {
		return valorFinal;
	}
	
	public void setCodHospedagem(String codHospedagem) {
		this.codHospedagem = codHospedagem;
	}
	
	public void setCodChale(String codChale) {
		this.codChale = codChale;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}
	
	public void setDataFim(LocalDate dataFim) {
		this.dataFim = dataFim;
	}
	
	public void setQtdPessoas(Integer qtdPessoas) {
		this.qtdPessoas = qtdPessoas;
	}
	
	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}
	
	public void setValorFinal(Double valorFinal) {
		this.valorFinal = valorFinal;
	}

	public String getCodCliente() {
		return codCliente;
	}

	public void setCodCliente(String codCliente) {
		this.codCliente = codCliente;
	}
}
