package domain.basics.profile;

import javax.persistence.Column;
import javax.persistence.Entity;
/**
 * 
 * @author bruno
 *
 */
@Entity
public class Cliente extends Usuario{
		
		@Column(unique=true)
		private String cnpj;
		
	
		
		public String getCnpj() {
			return cnpj;
		}

		public void setCnpj(String cnpj) {
			this.cnpj = cnpj;
		}

	
		
}
