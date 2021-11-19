package com.example.petstore;

import java.util.ArrayList;
import java.util.List;

public final class ResourcesManage {

    private static List<Pet> pets = new ArrayList<Pet>();
    private static List<PetType> petTypes = new ArrayList<PetType>();

    public static boolean addPet(Pet pet){
        if(pets.stream().filter(p->p.getPetId().equals(pet.getPetId())).findAny().orElse(null)!=null){
            return false;
        }else if(!petTypes.contains(pet.getPetType())){
            return false;
        }else{
            pets.add(pet);
            return true;
        }
    }

    public static boolean addPetType(PetType petType){
        if(petTypes.stream().filter(p->petType.getPetTypeId().equals(p.getPetTypeId())).findAny().orElse(null)!=null){
            return false;
        }else{
            petTypes.add(petType);
            return true;
        }
    }

    public static boolean updatePet(Pet pet){
        Pet pet1 = pets.stream().filter(p->pet.getPetId().equals(p.getPetId())).findAny().orElse(null);
        if(pet1==null){
            return false;
        }else{
            pet1.setPetId(pet.getPetId());
            pet1.setPetAge(pet.getPetAge());
            pet1.setPetName(pet.getPetName());
            pet1.setPetType(pet.getPetType());
            return true;
        }

    }

    public static boolean updatePetType(PetType petType){
        PetType petType1 = petTypes.stream().filter(p->petType.getPetTypeId().equals(p.getPetTypeId())).findAny().orElse(null);
        if(petType1==null){
            return false;
        }else{
            petType1.setPetTypeId(petType.getPetTypeId());
            petType1.setName(petType.getName());
            return true;
        }
    }

    public static boolean deletePet(int id){
        if(pets.stream().filter(p->p.getPetId().equals(id)).findAny().orElse(null)==null){
            return false;
        }else{
            pets.remove(pets.stream().filter(p->p.getPetId().equals(id)).findAny().orElse(null));
            return true;
        }

    }

    public static boolean deletePetType(int id){
        if(petTypes.stream().filter(p->p.getPetTypeId().equals(id)).findAny().orElse(null)==null){
            return false;
        }else{
            petTypes.remove(petTypes.stream().filter(p->p.getPetTypeId().equals(id)).findAny().orElse(null));
            return true;
        }
    }

    public static Pet getPet(int id){
        return pets.stream().filter(p->p.getPetId().equals(id)).findAny().orElse(null);
    }

    public static List<Pet> getPets(){

        return pets;
    }

    public static PetType getPetType(int id){

        return petTypes.stream().filter(p->p.getPetTypeId().equals(id)).findAny().orElse(null);
    }

    public static List<PetType> getPetTypes(){
        return petTypes;
    }

}
