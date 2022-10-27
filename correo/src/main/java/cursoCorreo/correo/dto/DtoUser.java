package cursoCorreo.correo.dto;

import org.springframework.beans.BeanUtils;

import cursoCorreo.correo.bean.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DtoUser {
    private String user;
	private String name;
	private String surname;

    public static DtoUser fromUser(User user)
    {
        if(user==null)
        return null;

        DtoUser dtoUser = new DtoUser();
        BeanUtils.copyProperties(user, dtoUser);

        return dtoUser;
    }

	
}
