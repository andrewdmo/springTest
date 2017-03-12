package as.v1_2.service;

import as.v1_2.entity.Animal;

import java.util.List;
import java.util.Scanner;


/**
 * Created by andrewdmo on 8/19/16.
 */

public class MenuService {


    public MenuService() {

        System.out.println("\n-+- Welcome to Noah's Park, human!! -+- \n | \n-+- ...we're all endangered here... -+-\n | ");

        //(default animals:)
        Animal example1 = new Animal("Fido", "Dog", "Yipper", "He's a runt");
        Animal example2 = new Animal("Simba", "Cat", "Scaredy", "One life left");
    }


    Scanner action = new Scanner(System.in);

    //   service.AnimalService animalService;

    public int waitForInt(String defaultQues) {

        System.out.println("\n--+-- Mane Menewe: --+--\n" + "\n" +
            "1) List critters\n" +
            "2) Create critter\n" +
            "3) View critter specifics \n" +
            "4) Edit critter\n" +
            "5) Delete critter\n" +
            "6) Quit(ter)");

        return intToInput(defaultQues, 1, 6);
    }


    public int intToInput(String defaultQues, int min, int max) {

        System.out.println(defaultQues);
        Scanner action = new Scanner(System.in);
        String userInput = action.nextLine();

        int privInput;

        try {
            privInput = Integer.parseInt(userInput);

            if (privInput > max || privInput < min) {
                return intToInput("Noah pities the fool!...number in range:", min, max);
            }
        } catch (Exception e) {
            return intToInput("Noah pities fools that can't tell letters from numbers!!...try again, Darwin:", min, max);
        }
        return privInput;
    }


    public int intToInput(String message) {

        System.out.println(message);
        Scanner action = new Scanner(System.in);
        String userInput = action.nextLine();

        int privInput;
        try {
            privInput = Integer.parseInt(userInput);

            if (privInput > 6 || privInput < 1) {
                return intToInput("Noah pities the fool!...number in range:");
            }
        } catch (Exception e) {
            return waitForInt("Noah pities fools that can't tell letters from numbers!!...try again, Darwin:");
        }
        return privInput;
    }


    private String waitForString(String message, boolean required) {
        System.out.println(message);
        Scanner action = new Scanner(System.in);
        String input = action.nextLine();

        if (required && input.trim().length() == 0) {

            input = waitForString("\nSay somethin'!:\n", true);
        }
        return input.trim();
    }


    private String waitForString(String message, String defaultInput) {
        String input = waitForString(message, false);

        if (input.isEmpty()) {
            return defaultInput;
        } else {
            return input;
        }
    }


    public void listAnimal(List<Animal> animalList) {

        System.out.println("\n-+- Critters aboard: -+-\n");

        if (animalList.size() == 0) {
            System.out.println("\nArk's empty!  Go trap something.\n");
        } else {
            for (int x = 0; x < animalList.size(); x++) {
                Animal animal = animalList.get(x);
                System.out.printf("%s) %s\n", x + 1, animal.getName());
            }
        }
    }


    public Animal menuCreate() {

        System.out.println("-+- Create Critter -+-\n");
        String name = waitForString("Critter Name:?: ", true);
        String species = waitForString("Critter species:?: ", true);
        String breed = waitForString("Critter breed:?: ", true);
        String details = waitForString("Critter specifics (optional):?: ", "[Empty]");

        System.out.printf("Congrats, %s has been begat!\n", name);
        return new Animal(name, species, breed, details);
    }


    public void menuDetails(Animal animal) {
        System.out.printf("-+- View Critter -+-\n" +
                "\n" +
                "Name: %s\n" +
                "Species: %s\n" +
                "Breed: %s\n" +
                "Description: %s\n",
            animal.getName(),
            animal.getSpecies(),
            animal.getBreed(),
            animal.getDescription());
    }


    public Animal menuEdit(Animal animal) {

        System.out.println("\nNew values for... " + animal.getName() + " ('Enter' for current):?:");

        String name = waitForString(
            String.format("Name [%s]:?: ", animal.getName()),
            animal.getName());
        String species = waitForString(
            String.format("Species [%s]:?: ", animal.getSpecies()),
            animal.getSpecies());
        String breed = waitForString(
            String.format("Breed [%s]:?: ", animal.getBreed()),
            animal.getBreed());
        String description = waitForString(
            String.format("Specifics [%s]:?:", animal.getDescription()), animal.getDescription());

        if (animal != null) {
            System.out.printf("\nCongrats, %s has been horribly altered!!\n", animal.getName());
            return new Animal(name, species, breed, description);

        } else {
            System.out.printf("Nature F'd up and %s was not begat", name);
            menuEdit(animal);
            return null;
        }
    }
}