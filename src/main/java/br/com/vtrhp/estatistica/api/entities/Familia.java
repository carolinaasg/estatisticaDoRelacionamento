package br.com.vtrhp.estatistica.api.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Familia implements Serializable {

	private static final long serialVersionUID = 4217903259530478432L;

	@Id
	private Long idFamilia;

	
}
