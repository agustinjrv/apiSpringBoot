package cursoCorreo.correo.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.BeanUtils;

import cursoCorreo.correo.dto.DtoUser;

import java.util.Date;

@Entity
@Table(name = "cursojava.usuarios")
public class User {
	@Id
	private String user;
	private String name;
	private String surname;
	private String password;
	private Date creationDate;

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public DtoUser toDtoUser() {
		DtoUser aux = new DtoUser();
		BeanUtils.copyProperties(this, aux); // hace una copia de las variables en aux mirando los getters y setters

		return aux;
	}

}
