package domain.basics;

import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import domain.basics.profile.Endereco;

@Entity
public class PontoEstrategico {
	
	@Id @GeneratedValue
	private Long codigo;
	
	private String nome;
	
	@Embedded
	private Endereco endereco;
	
	private String telefone;
	
	private String email;
	
	@OneToMany(mappedBy="pontoEstrategico", fetch = FetchType.LAZY)
	private List<Declaracao> listaDeclaracoes;
	
	
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
	public String getTeleone() {
		return telefone;
	}
	public void setTeleone(String teleone) {
		this.telefone = teleone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Declaracao> getListaDeclaracoes() {
		return listaDeclaracoes;
	}
	public void setListaDeclaracoes(List<Declaracao> listaDeclaracoes) {
		this.listaDeclaracoes = listaDeclaracoes;
	}
	
	
	
}
