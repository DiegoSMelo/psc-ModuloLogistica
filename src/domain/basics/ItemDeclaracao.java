package domain.basics;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;


@Entity
public class ItemDeclaracao {
	
	@EmbeddedId
	private ItemDeclaracaoPK id;
	
	@Column(nullable=false)
	private Double quantidade;
	
	
	public ItemDeclaracaoPK getId() {
		return id;
	}
	public void setId(ItemDeclaracaoPK id) {
		this.id = id;
	}
	public Double getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}
	
	
}
