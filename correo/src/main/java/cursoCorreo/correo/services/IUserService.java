package cursoCorreo.correo.services;

import java.util.List;
import cursoCorreo.correo.bean.User;
import cursoCorreo.correo.dto.DtoUser;

public interface IUserService { 

    public User registerUser(User user) throws Exception;

    public User update(User user) throws Exception;

    public List<DtoUser> findAll();

    public User findBysurname(String surname);

    public User findByuser(String name);

    public void deleteUser(String user);

}
