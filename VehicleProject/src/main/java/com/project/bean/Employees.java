package com.project.bean;

import lombok.*;

import java.util.Date;
import java.util.Objects;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employees {

	private Integer idEmployees;

	private String firstName;

	private String lastName;

	private String dni;

	private String address;

	private String gender;

	private Date birthDate;

	private Date hireDate;

	private Double salary;

	private String phoneNumber;

	private Status status;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Employees employees = (Employees) o;
		return Objects.equals(idEmployees, employees.idEmployees);
	}

	@Override
	public int hashCode() {

		return Objects.hash(idEmployees);
	}
}