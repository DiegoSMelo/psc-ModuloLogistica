package testes;

import domain.basics.Endereco;
import domain.basics.Usuario;
import domain.basics.enums.Situacao;
import domain.basics.enums.UF;
import domain.dao.factory.DAOFactory;
import domain.exceptions.DAOException;

public class Teste {

	public static void main(String[] args) {
		
		Usuario u = new Usuario();
		u.setNome("Diego Melo");
		u.setCpf("1234");
		u.setEmail("diosmelo@gmail.com");
		u.setLogin("diosmelo");
		u.setSenha("senhalegal132");
		u.setTelefone("08195208024");
		u.setSituacao(Situacao.ATIVO);
		
		Endereco e = new Endereco();
		e.setLogradouro("Rua Dom Bosco");
		e.setBairro("Padre Roma");
		e.setCep("54100-270");
		e.setCidade("Jaboatão dos Guararapes");
		e.setNumero("67");
		e.setUf(UF.PE);
		
		u.setEndereco(e);
		
		try {
			DAOFactory.getDaoUsuario().inserir(u);
		} catch (DAOException ex) {
			ex.printStackTrace();
		}
	}

}
