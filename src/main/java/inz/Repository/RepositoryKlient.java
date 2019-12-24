package inz.Repository;

import inz.Class.Klient;
import org.springframework.data.repository.CrudRepository;

public interface RepositoryKlient extends CrudRepository <Klient , Integer> {
    Klient findByEmail(String email);
}
