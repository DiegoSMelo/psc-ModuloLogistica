package domain.basics;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import domain.basics.enums.CategoriaItem;
import domain.basics.enums.StatusItem;
import domain.basics.enums.UnidadeMedida;

@Entity
public class Item {
	
	@Id @GeneratedValue
	private Long codigo;
		
	private String descricao;
	
	private Double valorCusto;
	
	private Double estoqueAtual;
	
	private Double estoqueMinimo;
	
	@Enumerated
	private UnidadeMedida unidadeMedida;
	
	@Enumerated
	private CategoriaItem categoriaItem;
	
	@Enumerated
	private StatusItem statusItem;
	
	@ManyToOne
	private Fornecedor fornecedor;
	
	
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
	public Double getValorCusto() {
		return valorCusto;
	}
	public void setValorCusto(Double valorCusto) {
		this.valorCusto = valorCusto;
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
	public CategoriaItem getCategoriaItem() {
		return categoriaItem;
	}
	public void setCategoriaItem(CategoriaItem categoriaItem) {
		this.categoriaItem = categoriaItem;
	}
	public StatusItem getStatusItem() {
		return statusItem;
	}
	public void setStatusItem(StatusItem statusItem) {
		this.statusItem = statusItem;
	}
	public Fornecedor getFornecedor() {
		return fornecedor;
	}
	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	
}
