package cursoCorreo.correo.dto;

import java.util.Date;

import org.springframework.beans.BeanUtils;

import cursoCorreo.correo.bean.Post;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class DtoPost {
    
    private Integer id;
    private String title;
    private String description;
    private Date creationDate;
    private DtoUser user;

    public static DtoPost fromPost(Post _post)
    {
        if(_post == null)
            return null;

        DtoPost dtoPost = new DtoPost();

        BeanUtils.copyProperties(_post, dtoPost);

        dtoPost.setUser(DtoUser.fromUser(_post.getUser()));


        return dtoPost;
    }

}
