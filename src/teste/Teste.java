package teste;

import domain.basics.Declaracao;
import domain.basics.ItemDeclaracao;
import domain.basics.ItemDeclaracaoPK;
import domain.basics.enums.TipoDeclaracao;
import domain.dao.factory.DAOFactory;
import domain.rn.RNDeclaracao;
import domain.util.Datas;

public class Teste {

	public static void main(String[] args) {
		/*
		PontoEstrategico pe = new PontoEstrategico();
		pe.setNome("Ponto Estratégico Recife");
		pe.setTelefone("3214565");
		pe.setEmail("pontorecife@gmai.com");
		pe.setCapacidadeTotalDePreteleiras(50);
		pe.setCapacidadeAtualDePrateleiras(50);
		
		
		Item i = new Item();
		i.setAltura(22.00);
		i.setDescricao("Lote de sapatos");
		i.setLargura(22.00);
		i.setPeso(22.00);
		i.setProfundidade(22.00);
		*/
		
		Declaracao d = new Declaracao();
		
		d.setDataHora(Datas.criarData(10, 10, 2014, 20, 00));
		d.setResponsavelEntrega("Silvio");
		d.setResponsavelRecebimento("Ana");
		d.setResponsavelRemocao("Beto");
		d.setTipoDeclaracao(TipoDeclaracao.DEVOLUCAO);
		d.setPontoEstrategico(DAOFactory.getDaoPontoEstrategico().consultarPorId((long) 1));
		
		
		ItemDeclaracaoPK idpk = new ItemDeclaracaoPK();
		idpk.setDeclaracao(d);
		idpk.setItem(DAOFactory.getDaoItem().consultarPorId((long) 1));
		
		
		
		
		
		
		ItemDeclaracao id = new ItemDeclaracao();
		id.setQuantidade(1.0);
		id.setId(idpk);
		
		RNDeclaracao rnd = new RNDeclaracao();
		
		
		
		
		
		

	}

}
