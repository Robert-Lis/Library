package pl.library.Library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.library.Library.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    Role findRoleByRole(String role);

}
