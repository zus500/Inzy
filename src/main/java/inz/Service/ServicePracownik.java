package inz.Service;

import inz.Class.Pracownik;
import inz.Class.Role;
import inz.RecordNotFoundException;
import inz.Repository.RepositoryPracownicy;
import inz.Repository.RepositoryRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ServicePracownik {

    @Autowired
    RepositoryPracownicy repositoryPracownicy;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    RepositoryRole repositoryRole;


    public List<Pracownik> getAllPracownik()
    {
        List<Pracownik> result = (List<Pracownik>)repositoryPracownicy.findAll();

        if(result.size() > 0) {

            return result;
        } else {
            return new ArrayList<Pracownik>();
        }
    }

    public Pracownik getPracowniktById(Integer id) throws RecordNotFoundException
    {
        Optional<Pracownik> employee = repositoryPracownicy.findById(id);

        if(employee.isPresent()) {
            return employee.get();
        } else {
            throw new RecordNotFoundException("No employee record exist for given id");
        }
    }

    public Pracownik createOrUpdatePracownik(Pracownik entity)
    {
        if( entity.getId() == null)
        {
            entity.setHaslo(bCryptPasswordEncoder.encode(entity.getHaslo()));
          Role role = repositoryRole.findByRole("ADMIN");
          entity.setActive(true);
            entity.setRoles(new HashSet<Role>(Arrays.asList(role)));
            entity = repositoryPracownicy.save(entity);
            return entity;
        }
        else
        {
            Optional<Pracownik> employee = repositoryPracownicy.findById(entity.getId());

            if(employee.isPresent())
            {
                Pracownik newEntity = employee.get();

                newEntity.setId(entity.getId());
                newEntity.setImie(entity.getImie());
                newEntity.setNazwisko(entity.getNazwisko());
                newEntity.setHaslo(bCryptPasswordEncoder.encode(entity.getHaslo()));
                System.out.print(newEntity.getHaslo());
                newEntity.setEmail(entity.getEmail());
                newEntity.setActive(true);
                return newEntity;
            } else {
                entity.setHaslo(bCryptPasswordEncoder.encode(entity.getHaslo()));
                Role role = repositoryRole.findByRole("ADMIN");
                entity.setActive(true);
                entity.setRoles(new HashSet<Role>(Arrays.asList(role)));
                entity = repositoryPracownicy.save(entity);
                return entity;
            }
        }
    }
    public void deletePracownikById(Integer id) throws RecordNotFoundException
    {
        Optional<Pracownik> employee = repositoryPracownicy.findById(id);

        if(employee.isPresent())
        {

            repositoryPracownicy.deleteById(id);
        } else {
            throw new RecordNotFoundException("No employee record exist for given id");
        }
    }
    public Pracownik findByEmail(String email)
    {
        return  repositoryPracownicy.findByEmail(email);
    }
}
