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

import domain.basics.enums.Situacao;
import domain.basics.enums.TipoDeclaracao;
import domain.basics.profile.Cliente;
/**
 * 
 * @author diego_melo
 *
 */

@Entity
public class Declaracao {
	
	@Id @GeneratedValue
	private Long Codigo;
	
	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date dataEntrada;
	
	@Temporal(TemporalType.DATE)
	private Date dataSaida;
	


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
	
	@Enumerated
	private Situacao situacao;
	
	
	
	public boolean isEntrada(){
		return this.getTipoDeclaracao().equals(TipoDeclaracao.ENTRADA);
	}
	
	public boolean isSaida(){
		return this.getTipoDeclaracao().equals(TipoDeclaracao.SAIDA);
	}
	
	public boolean isDevolucao(){
		return this.getTipoDeclaracao().equals(TipoDeclaracao.DEVOLUCAO);
	}
	
	
	
	public Long getCodigo() {
		return Codigo;
	}
	public void setCodigo(Long codigo) {
		Codigo = codigo;
	}
	public Date getDataEntrada() {
		return dataEntrada;
	}
	public void setDataEntrada(Date data) {
		this.dataEntrada = data;
	}
	public Date getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(Date dataSaida) {
		this.dataSaida = dataSaida;
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

	public Situacao getSituacao() {
		return situacao;
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}
	
	
}
