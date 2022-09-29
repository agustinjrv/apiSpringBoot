package cursoCorreo.correo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cursoCorreo.correo.bean.User;
import cursoCorreo.correo.dto.DtoUser;
import cursoCorreo.correo.repository.UserRepository;

@Service
public class UserService {
    //Para lectura complementaria
	//https://medium.com/javarevisited/spring-beans-in-depth-a6d8b31db8a1
    @Autowired
    private UserRepository repository;

    public User registerUser(User user) throws Exception{

        User aux = repository.findByuser(user.getUser());

        if(aux != null){
            throw new Exception("El usuario ya existe");
        }

        return repository.save(user);// hace insert y update si ya existe
    }

    public User update(User user) throws Exception{

        User aux = repository.findByuser(user.getUser());

        if(aux == null){
            throw new Exception("El usuario no existe");
        }

        return repository.save(user);// hace insert y update si ya existe
    }

    public List<User> findAll()
    {
        return repository.findAll();
    }


    public User findBysurname(String surname)
    {   
        return repository.findBysurname(surname);
    }

    public DtoUser findByuser(String name)
    {
        User us = repository.findByuser(name);

        return us.toDtoUser();
    }
/*
    public User findByuser(String name)
    {
        return repository.findByuser(name);
    }
*/
    public void deleteUser(String user)
    {
        repository.deleteUser3(user);
    }
}
