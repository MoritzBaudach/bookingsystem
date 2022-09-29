package com.example.bookingsystem.service;

import com.example.bookingsystem.model.Sitzplatz;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SitzplatzService {

    private Integer nextSitzplatzNummer;

    private List<Sitzplatz> alleSitzplaetze;

    public SitzplatzService() {
        this.nextSitzplatzNummer = 0;
        this.alleSitzplaetze = new ArrayList<>();
    }

    public Sitzplatz createSitzplatz(Double price){
        Sitzplatz sitzplatz = new Sitzplatz(nextSitzplatzNummer++, price);
        alleSitzplaetze.add(sitzplatz);
        return sitzplatz;
    }

    public List<Sitzplatz> getAlleSitzplaetze(){
        return alleSitzplaetze;
    }

    public Sitzplatz updateSitzplatz(Integer id, Double price){

        //find the sitzplatz with the given id
        for(int i=0; i<alleSitzplaetze.size(); i++) {
            Sitzplatz sitzplatz = alleSitzplaetze.get(i);

            if(id.equals(sitzplatz.getId())){
                //Eintrag gefunden -> fuehre update durch
                sitzplatz.setPrice(price);
                return sitzplatz;
            }
        }
        return null;
    }


    public boolean deleteSitzplatz(Integer id){
        for(int i=0; i<alleSitzplaetze.size(); i++) {
            Sitzplatz sitzplatz = alleSitzplaetze.get(i);

            if(id.equals(sitzplatz.getId())){
                //Eintrag gefunden -> fuehre update durch
                alleSitzplaetze.remove(id.intValue());
                return true;
            }
        }
        return false;
    }

}
