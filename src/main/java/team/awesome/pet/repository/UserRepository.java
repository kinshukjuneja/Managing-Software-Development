package team.awesome.pet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import team.awesome.pet.model.User;

/**
 * This is an interface of User Repository where all the functions will be inherited from calling
 * Jpa Repository. Thus no need for explicit calling those functions here but rather at the Service
 * layer.
 *
 */
public interface UserRepository extends JpaRepository<User, Integer> {

  /**
   * This is an extra method to help finding the correct User by searching for his/her userName
   *
   * @param userName given an userName
   * @return an user whose userName matches with search
   */
  User findByUserName(String userName);
}
