package com.usermanagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Data
public class UserDetails implements Comparable<UserDetails> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;

	private String userName;

	private String phoneNo;

	private String password;

	private String email;

	@Override
	public int compareTo(UserDetails o) {

		return this.userName.compareToIgnoreCase(o.getUserName()) > 0 ? 1 : -1;
	}

}
