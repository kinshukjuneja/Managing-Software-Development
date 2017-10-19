package team.awesome.pet.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import team.awesome.pet.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long>{
	List<Customer> findByLastName(String lastName);
}
