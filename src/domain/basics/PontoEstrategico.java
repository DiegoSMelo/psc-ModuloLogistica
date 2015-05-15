package domain.basics;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import domain.basics.enums.Situacao;
import domain.basics.profile.Endereco;
/**
 * 
 * @author domenico
 *
 */
@Entity
public class PontoEstrategico {
	
	@Id @GeneratedValue
	private Long codigo;
	
	private String nome;
	
	@Embedded
	private Endereco endereco;
	
	private String telefone;
	
	private String email;
	
	@Column(nullable=false)
	private Integer capacidadeTotalDePrateleiras;
	
	@Column(nullable=false)
	private Integer capacidadeAtualDePrateleiras;
	
	private Situacao situacaoPontoEstrategico;
	
	@Column(unique=true)
	private String cnpj;
	
	
	public boolean isAtivo(){
		return situacaoPontoEstrategico.equals(Situacao.ATIVO);
	}
	
	
	public boolean isAlerta(){
		
		if (this.getCapacidadeAtualDePrateleiras() <= 20) {
			return true;
		}
		
		return false;
	}
	
	
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public Integer getCapacidadeTotalDePreteleiras() {
		return capacidadeTotalDePrateleiras;
	}
	public void setCapacidadeTotalDePreteleiras(Integer capacidadeTotalDePreteleiras) {
		this.capacidadeTotalDePrateleiras = capacidadeTotalDePreteleiras;
	}
	public Integer getCapacidadeAtualDePrateleiras() {
		return capacidadeAtualDePrateleiras;
	}
	public void setCapacidadeAtualDePrateleiras(Integer capacidadeAtualDePrateleiras) {
		this.capacidadeAtualDePrateleiras = capacidadeAtualDePrateleiras;
	}
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public Situacao getSituacaoPontoEstrategico() {
		return situacaoPontoEstrategico;
	}
	public void setSituacaoPontoEstrategico(Situacao situacao) {
		this.situacaoPontoEstrategico = situacao;
	}
	
	

	
	
	
}
