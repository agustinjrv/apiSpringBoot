package cursoCorreo.correo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cursoCorreo.correo.bean.Post;
import cursoCorreo.correo.bean.User;
import cursoCorreo.correo.repository.PostRepository;

@Service
public class PostServiceImpl {
    
    @Autowired
    PostRepository repository;
    
    @Autowired
    UserServiceImpl servicioUsuarios;

    public Post createPost(Post post) throws Exception{
        User user = servicioUsuarios.findByuser(post.getUser().getUser());

        if(user==null)
        {
            throw new Exception("El usuario no Existe");
        }

        post.setUser(user);
        return repository.save(post);
    }

    public List<Post> list()
    {
        return repository.findAll();
    }

}
