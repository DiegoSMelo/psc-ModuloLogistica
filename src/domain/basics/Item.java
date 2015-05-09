package domain.basics;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import domain.basics.enums.Situacao;
/**
 * 
 * @author gustavo
 *
 */
@Entity
public class Item {
	
	@Id @GeneratedValue
	private Long codigo;
	
	@Column(nullable=false)
	private String descricao;
	
	@Column(nullable=false)
	private Double largura;
	
	@Column(nullable=false)
	private Double altura;
	
	@Column(nullable=false)
	private Double profundidade;
	
	@Column(nullable=false)
	private Double peso;
	
	@Enumerated
	private Situacao situacao;
	
	
	
	public Double getVolume(){
		return this.getAltura() * this.getLargura() * this.getProfundidade();		
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
	public Double getPeso() {
		return peso;
	}
	public void setPeso(Double peso) {
		this.peso = peso;
	}


	public Situacao getSituacao() {
		return situacao;
	}


	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}
	
	
	
}
