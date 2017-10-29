package team.awesome.pet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import team.awesome.pet.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
  User findByUserName(String userName);
}
