package br.com.vendas_api.repository;

import br.com.vendas_api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RepositoryRestResource(exported = false)
public interface UserRepository extends JpaRepository<User, String> {

    User findByEmail(String email);
}
