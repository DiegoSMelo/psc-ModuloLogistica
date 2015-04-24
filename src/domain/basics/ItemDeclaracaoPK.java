package domain.basics;

import java.io.Serializable;

import javax.persistence.ManyToOne;


public class ItemDeclaracaoPK implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	private Item item;
	
	@ManyToOne
	private Declaracao declaracao;
	
	
	public Declaracao getDeclaracao() {
		return declaracao;
	}
	public void setDeclaracao(Declaracao declaracao) {
		this.declaracao = declaracao;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	
}
