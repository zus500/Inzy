package inz.Repository;

import inz.Class.Role;
import org.springframework.data.repository.CrudRepository;

public interface RepositoryRole  extends CrudRepository <Role, Integer> {
    Role findByRole (String role);
}
