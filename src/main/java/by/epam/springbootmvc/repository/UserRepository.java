package by.epam.springbootmvc.repository;

import by.epam.springbootmvc.beans.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.jws.soap.SOAPBinding;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {

    @Query("select u from User u where u.username = :name")
    User getUserByName(@Param("name")String username);
}
