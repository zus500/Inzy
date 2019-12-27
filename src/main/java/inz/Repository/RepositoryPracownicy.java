package inz.Repository;

import inz.Class.Pracownik;
import org.springframework.data.repository.CrudRepository;

public interface RepositoryPracownicy extends CrudRepository <Pracownik , Integer> {
    Pracownik findByEmail(String Email);
}
