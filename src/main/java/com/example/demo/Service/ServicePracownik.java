package com.example.demo.Service;

import com.example.demo.Class.Klient;
import com.example.demo.Class.Pracownik;
import com.example.demo.RecordNotFoundException;
import com.example.demo.Repository.RepositoryKlient;
import com.example.demo.Repository.RepositoryPracownicy;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ServicePracownik {

    @Autowired
    RepositoryPracownicy repositoryPracownicy;


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



                return newEntity;
            } else {
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
}
