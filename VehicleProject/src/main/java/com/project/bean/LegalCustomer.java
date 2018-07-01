package com.project.bean;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LegalCustomer {

	private Integer idLegalCustomer;

	private String companyName;

	private String address;

	private String ruc;

	private String contactName;

	private String numberPhone;

	private Status status;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idLegalCustomer == null) ? 0 : idLegalCustomer.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LegalCustomer other = (LegalCustomer) obj;
		if (idLegalCustomer == null) {
			if (other.idLegalCustomer != null)
				return false;
		} else if (!idLegalCustomer.equals(other.idLegalCustomer))
			return false;
		return true;
	}

}
