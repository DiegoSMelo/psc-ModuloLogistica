package domain.basics;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import domain.basics.enums.StatusProduto;
import domain.basics.enums.UnidadeMedida;

@Entity
public class Produto {
	
	@Id @GeneratedValue
	private Long codigo;
	@Column(nullable=false)
	private String descricao;
	
	private Double largura;
	private Double altura;
	private Double profundidade;
	
	private Double estoqueAtual;
	private Double estoqueMinimo;
	
	@Enumerated
	private UnidadeMedida unidadeMedida;
	
	@ManyToOne
	private Cliente cliente;
	
	@ManyToOne
	private PontoEstrategico pontoEstrategico;
	
	@Enumerated
	private StatusProduto status;
	
	
	
	
	public StatusProduto getStatus() {
		return status;
	}
	public void setStatus(StatusProduto status) {
		this.status = status;
	}
	public Double getEstoqueAtual() {
		return estoqueAtual;
	}
	public void setEstoqueAtual(Double estoqueAtual) {
		this.estoqueAtual = estoqueAtual;
	}
	public Double getEstoqueMinimo() {
		return estoqueMinimo;
	}
	public void setEstoqueMinimo(Double estoqueMinimo) {
		this.estoqueMinimo = estoqueMinimo;
	}
	public UnidadeMedida getUnidadeMedida() {
		return unidadeMedida;
	}
	public void setUnidadeMedida(UnidadeMedida unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Double getLargura() {
		return largura;
	}
	public void setLargura(Double largura) {
		this.largura = largura;
	}
	public Double getAltura() {
		return altura;
	}
	public void setAltura(Double altura) {
		this.altura = altura;
	}
	public Double getProfundidade() {
		return profundidade;
	}
	public void setProfundidade(Double profundidade) {
		this.profundidade = profundidade;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public PontoEstrategico getPontoEstrategico() {
		return pontoEstrategico;
	}
	public void setPontoEstrategico(PontoEstrategico pontoEstrategico) {
		this.pontoEstrategico = pontoEstrategico;
	}
	
}
