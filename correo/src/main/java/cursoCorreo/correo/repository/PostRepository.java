package cursoCorreo.correo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cursoCorreo.correo.bean.Post;

public interface PostRepository extends JpaRepository<Post,Integer> {//se le va a pasar un post y su clave primaria, por esp el integer
    @Query(value ="from Post p JOIN FETCH p.user")
    public List<Post> findAll();
}
