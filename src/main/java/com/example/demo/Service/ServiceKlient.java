package com.example.demo.Service;


import com.example.demo.Class.Klient;
import com.example.demo.RecordNotFoundException;
import com.example.demo.Repository.RepositoryKlient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceKlient {

    @Autowired
    RepositoryKlient repositoryKlient;

    public List<Klient> getAllKlient()
    {
        List<Klient> result = (List<Klient>)repositoryKlient.findAll();

        if(result.size() > 0) {

            return result;
        } else {
            return new ArrayList<Klient>();
        }
    }

    public Klient getKlientById(Integer id) throws RecordNotFoundException
    {
        Optional<Klient> employee = repositoryKlient.findById(id);

        if(employee.isPresent()) {
            return employee.get();
        } else {
            throw new RecordNotFoundException("No employee record exist for given id");
        }
    }

    public Klient createOrUpdateKlient(Klient entity)
    {
        if( entity.getId() == null)
        {
            entity = repositoryKlient.save(entity);
            return entity;
        }
        else
        {
            Optional<Klient> employee = repositoryKlient.findById(entity.getId());

            if(employee.isPresent())
            {
                Klient newEntity = employee.get();

                newEntity.setId(entity.getId());

                newEntity.setNazwa(entity.getNazwa());
                newEntity.setUlica(entity.getUlica());
                newEntity.setPesel(entity.getPesel());
                newEntity.setNip(entity.getNip());
                newEntity.setMiasto(entity.getMiasto());
                newEntity.setKod_pocztowy(entity.getKod_pocztowy());
                newEntity.setNr_domu_mieszkania(entity.getNr_domu_mieszkania());
                newEntity.setNumer_telefonu(entity.getNumer_telefonu());
                newEntity.setPracownik(entity.getPracownik());
                newEntity = repositoryKlient.save(newEntity);

                return newEntity;
            } else {
                entity = repositoryKlient.save(entity);

                return entity;
            }
        }
    }

    public void deleteKlientById(Integer id) throws RecordNotFoundException
    {
        Optional<Klient> employee = repositoryKlient.findById(id);

        if(employee.isPresent())
        {

            repositoryKlient.deleteById(id);
        } else {
            throw new RecordNotFoundException("No employee record exist for given id");
        }
    }
}
