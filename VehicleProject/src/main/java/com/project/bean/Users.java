package com.project.bean;

import lombok.*;

import java.util.Date;

@Data
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Users {

	private Integer idUsers;

	private String userName;

	private String passwords;

	private Date startedDate;

	private String typeUser;

	private Status status;


}
