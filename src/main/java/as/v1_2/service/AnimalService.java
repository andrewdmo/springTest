//package as.v1_2.service;
//
//import as.v1_2.entity.Animal;
//import as.v1_2.repo.AnimalRepository;
//
//import java.io.IOException;
//import java.util.ArrayList;
//
///**
// * Created by andrewdmo on 8/19/16.
// */
//public class AnimalService {
//
//    private AnimalRepository animalRepository;
//
//    //constructor:
//    public AnimalService(AnimalRepository animalRepository) {
//        this.animalRepository = animalRepository;
//    }
//
//    //menu 1:
//    public ArrayList<Animal> listAnimals() {
//        return animalRepository.listAnimals();
//    }
//
//    //menu 2:
//    public void createAnimal(Animal animal) throws IOException {
//        animalRepository.createAnimal(animal);
//
//    }
//
//    //method for menu 3:
//    public Animal viewAnimal(int index) {
//        try {
//            return animalRepository.viewAnimal(index);
//        } catch (IndexOutOfBoundsException e) {
//            return null;
//        }
//    }
//
//    //method for menu 4:
//    public void editAnimal(int index, Animal animal) throws IOException {
//        animalRepository.editAnimal(index, animal);
//    }
//
//    //method for menu 5:
//    public String deleteAnimal(int index) throws IOException {
//        try {
//            String deadName = getAnimal(index).getName();
//            animalRepository.deleteAnimal(index);
//            return deadName;
//        } catch (IndexOutOfBoundsException e) {
//            return "Anonymous";
//        }
//    }
//
//    public Animal getAnimal(int index) {
//        try {
//            return animalRepository.getAnimal(index);
//        } catch (IndexOutOfBoundsException e) {
//            return null;
//        }
//    }
//}
//
//
//
//
//
//
