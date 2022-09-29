package cursoCorreo.correo.repository;

import cursoCorreo.correo.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
  public  User findByuser(String user);//findBy palabra reserbada,despues se pone el nombre de la col en la BD
  public  User findBysurname(String surname);

  @Procedure
  void deleteUser3(String user);

  
}
