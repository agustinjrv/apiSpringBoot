package cursoCorreo.correo.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.BeanUtils;

import cursoCorreo.correo.dto.DtoUser;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "cursojava.usuarios")
@Data//para generar getters y  setters
public class User {
	@Id
	private String user;
	private String name;
	private String surname;
	private String password;
	private Date creationDate;




	public DtoUser toDtoUser() {
		DtoUser aux = new DtoUser();
		BeanUtils.copyProperties(this, aux); // hace una copia de las variables en aux mirando los getters y setters

		return aux;
	}

}
