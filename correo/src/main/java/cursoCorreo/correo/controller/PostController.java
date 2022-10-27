package cursoCorreo.correo.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cursoCorreo.correo.bean.Post;
import cursoCorreo.correo.dto.DtoPost;
import cursoCorreo.correo.impl.PostServiceImpl;

@RestController
@RequestMapping("v1/post")
public class PostController {
    
    @Autowired
    private PostServiceImpl servicioPost;

    public ResponseEntity<?> createPost(@RequestBody Post post){
        try {
            DtoPost dtoPost = DtoPost.fromPost(servicioPost.createPost(post));

            return new ResponseEntity<DtoPost>(dtoPost,HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_ACCEPTABLE);
        }
    }

    public List<DtoPost> list()
    {
        return  this.servicioPost.list().stream().map(post-> DtoPost.fromPost(post)).collect(Collectors.toList());
    }
}
