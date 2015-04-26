package domain.basics;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import domain.basics.enums.TipoDeclaracao;
import domain.basics.profile.Cliente;

@Entity
public class Declaracao {
	
	@Id @GeneratedValue
	private Long Codigo;
	
	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date data;
	
	@Enumerated
	@Column(nullable=false)
	private TipoDeclaracao tipoDeclaracao;
	
	@Column(nullable=false)
	private String responsavelEntrega;
	
	@Column(nullable=false)
	private String responsavelRecebimento;
	
	@Column(nullable=false)
	private String responsavelRemocao;

	@ManyToOne
	private PontoEstrategico pontoEstrategico;
	
	@ManyToOne
	private Cliente cliente;
	
	public Long getCodigo() {
		return Codigo;
	}
	public void setCodigo(Long codigo) {
		Codigo = codigo;
	}
	public Date getDataHora() {
		return data;
	}
	public void setDataHora(Date dataHora) {
		this.data = dataHora;
	}
	public TipoDeclaracao getTipoDeclaracao() {
		return tipoDeclaracao;
	}
	public void setTipoDeclaracao(TipoDeclaracao tipoDeclaracao) {
		this.tipoDeclaracao = tipoDeclaracao;
	}
	public String getResponsavelEntrega() {
		return responsavelEntrega;
	}
	public void setResponsavelEntrega(String responsavelEntrega) {
		this.responsavelEntrega = responsavelEntrega;
	}
	public String getResponsavelRecebimento() {
		return responsavelRecebimento;
	}
	public void setResponsavelRecebimento(String responsavelRecebimento) {
		this.responsavelRecebimento = responsavelRecebimento;
	}
	public String getResponsavelRemocao() {
		return responsavelRemocao;
	}
	public void setResponsavelRemocao(String responsavelRemocao) {
		this.responsavelRemocao = responsavelRemocao;
	}
	public PontoEstrategico getPontoEstrategico() {
		return pontoEstrategico;
	}
	public void setPontoEstrategico(PontoEstrategico pontoEstrategico) {
		this.pontoEstrategico = pontoEstrategico;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
}
