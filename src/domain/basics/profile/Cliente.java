package domain.basics.profile;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import domain.basics.Item;

@Entity
public class Cliente extends Usuario{
		
		@Column(unique=true)
		private String cnpj;
		
		@OneToMany(mappedBy="cliente", fetch = FetchType.LAZY)
		private List<Item> listaItens;
		
		
		public String getCnpj() {
			return cnpj;
		}

		public void setCnpj(String cnpj) {
			this.cnpj = cnpj;
		}

		public List<Item> getListaItens() {
			return listaItens;
		}

		public void setListaItens(List<Item> listaItens) {
			this.listaItens = listaItens;
		}
		
}
