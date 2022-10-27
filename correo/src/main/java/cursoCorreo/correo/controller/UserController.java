package cursoCorreo.correo.controller;

import cursoCorreo.correo.repository.UserRepository;
import cursoCorreo.correo.services.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import cursoCorreo.correo.bean.User;
import cursoCorreo.correo.dto.DtoUser;

import java.util.List;

@RestController
@RequestMapping("v1/user")
public class UserController {
	
	@Qualifier("realSercice")
	IUserService servicioUsuarios;

	//Singleton crea una sola instancia de la BD
	@Autowired//para que cree el objete "new algo()" ;
	UserRepository repository;//no deberia estar aca
	
	@GetMapping("/test")
	public String test()
	{
		return "hola mundo";
		
	}
	//parametro en path
	@GetMapping("/find/{username}")
	public DtoUser find(@PathVariable("username") String name)
	{
		return DtoUser.fromUser(this.servicioUsuarios.findByuser(name));
	
	}


	//por parametro
	@GetMapping("/find2")
	public String find2(@RequestParam("username") String name,@RequestParam("username2") String name2)
	{
		return name +" "+ name2 ;
		
	}

	@GetMapping("/find3")
	public DtoUser find3(@RequestParam("surname") String surname)
	{
		return DtoUser.fromUser(servicioUsuarios.findBysurname(surname));

	}

	@GetMapping("/list")
	public List<DtoUser> findList()
	{
		return servicioUsuarios.findAll();
	}
	
	@PostMapping("register")
	public ResponseEntity<?> registrar(@RequestBody User user) //Response entity respuesta que damos con un estado
	{
		try {
			User us =servicioUsuarios.registerUser(user);

			return new ResponseEntity<User>(us,HttpStatus.OK);

		} catch (Exception e) {
			
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@PutMapping("update")
	public ResponseEntity<?> update(@RequestBody User user) //Response entity respuesta que damos con un estado
	{
		try {
			User us =servicioUsuarios.update(user);

			return new ResponseEntity<User>(us,HttpStatus.OK);

		} catch (Exception e) {
			
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@DeleteMapping("/delete")
	public void delete(@RequestParam("user") String user)
	{
		User u = new User();
		u.setUser(user);
		repository.delete(u);
	}

	@DeleteMapping("/delete3")//es el que va xd
	public void delete3(@RequestParam("user") String user)
	{
		servicioUsuarios.deleteUser(user);//con sp ver en servicio
	}


	
	
	
}
