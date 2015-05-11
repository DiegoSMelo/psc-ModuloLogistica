package domain.basics.profile;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import domain.basics.enums.Situacao;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Usuario {
	
	@Id @GeneratedValue
	private Long codigo;
	
	@Column(nullable=false)
	private String nome;
	
	@Embedded
	private Endereco endereco;
		
	private String telefone;
	
	@Column(unique=true)
	private String email;
	
	@Column(unique=true, nullable=false)
	private String login;
	
	@Column(nullable=false)
	private String senha;
	
	@Enumerated
	private Situacao situacaoUsuario;
	
	
	public boolean isAtivo(){
		return situacaoUsuario.equals(Situacao.ATIVO);
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
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Situacao getSituacaoUsuario() {
		return situacaoUsuario;
	}
	public void setSituacaoUsuario(Situacao situacaoUsuario) {
		this.situacaoUsuario = situacaoUsuario;
	}
	
	

}