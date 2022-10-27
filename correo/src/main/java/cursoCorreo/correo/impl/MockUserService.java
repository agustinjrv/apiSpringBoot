package cursoCorreo.correo.impl;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import cursoCorreo.correo.bean.User;
import cursoCorreo.correo.dto.DtoUser;
import cursoCorreo.correo.services.IUserService;

@Service
@Component("mockService")
public class MockUserService implements IUserService {

    @Override
    public void deleteUser(String user) {
        
        
    }

    @Override
    public List<DtoUser> findAll() {
        
        return null;
    }

    @Override
    public User findBysurname(String surname) {
        
        return null;
    }

    @Override
    public User findByuser(String user) {
        
        return null;
    }

    @Override
    public User registerUser(User user) throws Exception {
        
        return user;
    }

    @Override
    public User update(User user) throws Exception {
        
        return null;
    }
    
}
