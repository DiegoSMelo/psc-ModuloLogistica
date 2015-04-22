package domain.basics;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import domain.basics.enums.TipoMovimentacao;

@Entity
public class Movimentacao {

	@Id @GeneratedValue
	private Long codigo;
	
	@ManyToOne
	private Produto produto;
	
	@Enumerated
	private TipoMovimentacao tipoMovimentacao;
	
	@Temporal(TemporalType.DATE)
	private Date dataMovimentacao;
	
	private String descricao;
	
	private double quantidadeItem;
	


	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Produto getItem() {
		return produto;
	}

	public void setItem(Produto item) {
		this.produto = item;
	}

	public TipoMovimentacao getTipoMovimentacao() {
		return tipoMovimentacao;
	}

	public void setTipoMovimentacao(TipoMovimentacao tipoMovimentacao) {
		this.tipoMovimentacao = tipoMovimentacao;
	}

	public Date getDataMovimentacao() {
		return dataMovimentacao;
	}

	public void setDataMovimentacao(Date dataMovimentacao) {
		this.dataMovimentacao = dataMovimentacao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getQuantidadeItem() {
		return quantidadeItem;
	}

	public void setQuantidadeItem(double quantidadeItem) {
		this.quantidadeItem = quantidadeItem;
	}
	
	
}
