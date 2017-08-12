package cerner.patient;

import cerner.allergy.Allergy;
import cerner.demographics.Address;
import cerner.demographics.Gender;
import cerner.demographics.Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Patient extends Person {

    private List<Allergy> allergies;
    private Temperature temperature;

    public Patient(String name, Address address, int phoneNo, Gender gender, List<Allergy> allergies, Temperature temperature) {
        super(name, address, phoneNo, gender);
        this.allergies = allergies;
        this.temperature = temperature;
    }

    public List<Allergy> getAllergies(){
        return allergies;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }

    public boolean hasFever(){
        return (temperature.getFahrenheit() > 98.6) ? true : false;
    }

    public List<String> getAllergywithGivenSymptom(String symptom){

        List<String> res = new ArrayList<>();
        for(Allergy al: allergies){
            List<String> symp = al.getSymptoms();
            for(String sym: al.getSymptoms()){
                if(sym.equals(symptom)){
                    res.add(al.getAllergyName());
                }
            }
        }
        return res;
    }

    public HashMap<String, List<String>> getAllAllergyWithSymptoms(){
        HashMap<String, List<String>> hmap = new HashMap<>();
        for(Allergy al : allergies){
            hmap.put(al.getAllergyName(),al.getSymptoms());
        }
        return hmap;
    }
}
