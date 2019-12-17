package com.example.demo.Service;

import com.example.demo.Class.Polisa;
import com.example.demo.Class.Sprawy;
import com.example.demo.RecordNotFoundException;
import com.example.demo.Repository.RepositorySprawy;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ServiceSprawy {

    @Autowired
    RepositorySprawy repositorySprawy;

    public List<Sprawy> getAllSprawy()
    {
        List<Sprawy> result = (List<Sprawy>)repositorySprawy.findAll();

        if(result.size() > 0) {

            return result;
        } else {
            return new ArrayList<Sprawy>();
        }
    }

    public Sprawy getSprawyById(Integer id) throws RecordNotFoundException
    {
        Optional<Sprawy> employee = repositorySprawy.findById(id);

        if(employee.isPresent()) {
            return employee.get();
        } else {
            throw new RecordNotFoundException("No employee record exist for given id");
        }
    }

    public Sprawy createOrUpdateSprawy(Sprawy entity)
    {

        if( entity.getId() == null)
        {
            entity = repositorySprawy.save(entity);
            return entity;
        }
        else
        {
            Optional<Sprawy> employee = repositorySprawy.findById(entity.getId());

            if(employee.isPresent())
            {
                Sprawy newEntity = employee.get();

                newEntity.setId(entity.getId());

                newEntity.setOpis(entity.getOpis());
                newEntity.setRodzaj_szkody(entity.getRodzaj_szkody());
                newEntity.setDane_poszkodowanego(entity.getDane_poszkodowanego());
                newEntity.setDane_sprawcy(entity.getDane_sprawcy());
                newEntity.setDane_zakonczenia(entity.getDane_zakonczenia());
                newEntity.setData_rozpoczecia(entity.getData_rozpoczecia());
                newEntity.setKlient(entity.getKlient());
                newEntity.setRodzaj_szkody(entity.getRodzaj_szkody());
                newEntity.setOpiekun(entity.getOpiekun());
                newEntity = repositorySprawy.save(newEntity);
                return newEntity;
            } else {
                entity = repositorySprawy.save(entity);
                return entity;
            }
        }
    }

    public void deleteSprawyaById(Integer id) throws RecordNotFoundException
    {
        Optional<Sprawy> employee = repositorySprawy.findById(id);

        if(employee.isPresent())
        {

            repositorySprawy.deleteById(id);
        } else {
            throw new RecordNotFoundException("No employee record exist for given id");
        }
    }
}
