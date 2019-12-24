package inz.Service;

import inz.Class.Polisa;
import inz.RecordNotFoundException;
import inz.Repository.RepositoryPolisa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class ServicePolisa {

    @Autowired
    RepositoryPolisa repositoryPolisa;

    public List<Polisa> getAllPolisa()
    {
        List<Polisa> result = (List<Polisa>)repositoryPolisa.findAll();

        if(result.size() > 0) {

            return result;
        } else {
            return new ArrayList<Polisa>();
        }
    }

    public Polisa getPolisaById(Integer id) throws RecordNotFoundException
    {
        Optional<Polisa> employee = repositoryPolisa.findById(id);

        if(employee.isPresent()) {
            return employee.get();
        } else {
            throw new RecordNotFoundException("No employee record exist for given id");
        }
    }

    public Polisa createOrUpdatePolisa(Polisa entity)
    {
        if( entity.getId() == null)
        {
            entity = repositoryPolisa.save(entity);
            return entity;
        }
        else
        {
            Optional<Polisa> employee = repositoryPolisa.findById(entity.getId());

            if(employee.isPresent())
            {
                Polisa newEntity = employee.get();

                newEntity.setId(entity.getId());

                newEntity.setPrzedmiot_ubepizeczenia(entity.getPrzedmiot_ubepizeczenia());
                newEntity.setNumer_polisy(entity.getNumer_polisy());
                newEntity.setUbezpieczyciel(entity.getUbezpieczyciel());
                newEntity.setData_poczatku(entity.getData_poczatku());
                newEntity.setData_konca(entity.getData_konca());
                newEntity.setSkladka(entity.getSkladka());
                newEntity.setOpis(entity.getOpis());
                newEntity.setKlient(entity.getKlient());
                newEntity = repositoryPolisa.save(newEntity);

                return newEntity;
            } else {
                entity = repositoryPolisa.save(entity);

                return entity;
            }
        }
    }

    public void deletePolisaById(Integer id) throws RecordNotFoundException
    {
        Optional<Polisa> employee = repositoryPolisa.findById(id);

        if(employee.isPresent())
        {

            repositoryPolisa.deleteById(id);
        } else {
            throw new RecordNotFoundException("No employee record exist for given id");
        }
    }
}
