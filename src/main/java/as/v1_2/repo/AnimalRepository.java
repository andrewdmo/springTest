package as.v1_2.repo;

import as.v1_2.entity.Animal;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * Created by andrewdmo on 9/8/16.
 */
public class AnimalRepository {

    private final Path filePath;
    private final Gson gson;

    private ArrayList<Animal> masterList = new ArrayList<>();

    //constructor:
    public AnimalRepository(String file) throws IOException {
        gson = new GsonBuilder().setPrettyPrinting().create();

        filePath = Paths.get(file);

        if (Files.exists(filePath)) {
            String json = new String(Files.readAllBytes(filePath));
            Type listType = new TypeToken<ArrayList<Animal>>() {
            }.getType();

            masterList = gson.fromJson(json, listType);
        }
    }

    //persist('save'):
    private void persist() throws IOException {
        String json = gson.toJson(masterList);
        Files.write(filePath, json.getBytes());
    }

    //method 1:
    public ArrayList<Animal> listAnimals() {
        return masterList;
    }

    //Menu 2:
    public void createAnimal(Animal animal) throws IOException {
        masterList.add(animal);

        persist();
    }


    //menu 3:
    public Animal viewAnimal(int index) {
        return masterList.get(index);
    }

    //menu 4:
    public void editAnimal(int index, Animal animal) throws IOException {
        masterList.set(index, animal);

        persist();
    }

    //menu 5:
    public void deleteAnimal(int index) throws IOException {
        masterList.remove(index);

        persist();
    }

    public Animal getAnimal(int index) {
        return masterList.get(index);
    }
}