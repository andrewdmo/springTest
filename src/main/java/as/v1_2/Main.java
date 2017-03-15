//package as.v1_2; /**
// * 1
// * Created by andrewdmo on 8/19/16, beta done 8.30.
// */
////now I see why they outsource:
//
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//
//@SpringBootApplication
//public class Main {
//
//    public static void main(String[] args) throws IOException {
//
//        AnimalRepository animalRepository = new AnimalRepository("animals.json");
//        AnimalService animalService = new AnimalService(animalRepository);
//        MenuService menuService = new MenuService();
//
//        int userInput = menuService.waitForInt("Which number, man:?:");
//
//        while (true) {
//
//
//            if (userInput == 1) {
//                List<Animal> animalList = animalService.listAnimals();
//                menuService.listAnimal(animalList);
//                userInput = menuService.waitForInt("Next unnatural selection:?:");
//
//
//            } else if (userInput == 2) {
//                Animal animal = menuService.menuCreate();
//                animalService.createAnimal(animal);
//                userInput = menuService.waitForInt("Next unnatural selection:?:");
//
//
//            } else if (userInput == 3) {
//                List<Animal> animalList = animalService.listAnimals();
//                int index = menuService.intToInput("-+- View Critter Specifics -+-\n\nCritter number(from List):?:", 1, animalList.size());
//                Animal animal = animalService.getAnimal(index-1);
//                menuService.menuDetails(animal);
//                userInput = menuService.waitForInt("Next unnatural selection:?:");
//
//
//            } else if (userInput == 4) {
//                List<Animal> animalList = animalService.listAnimals();
//                int index = menuService.intToInput("-+- Splice Critter's Genes: -+-\n\nCritter number(from List):?:", 1, animalList.size());
//                //get animal:
//                Animal animal = animalService.getAnimal(index-1);
//                //get new data:
//                Animal editedAnimal = menuService.menuEdit(animal);
//                //save edited:
//                animalService.editAnimal(index-1, editedAnimal);
//                userInput = menuService.waitForInt("Next unnatural selection:?:");
//
//
//            } else if (userInput == 5) {
//                List<Animal> animalList = animalService.listAnimals();
//                int index = menuService.intToInput("\n-+- Terminate Critter -+-\n\nCritter number (from List):?:", 1, animalList.size());
//                String deadName = animalService.deleteAnimal(index-1);
//                System.out.println("Congrats Lord Homo, " + "'" + deadName + "' is now extinct.  One less bowl to fill!");
//                userInput = menuService.waitForInt("Next unnatural selection:?:");
//
//
//            } else if (userInput == 6) {
//                System.out.println("\n-+- Fine, enjoy extinction!... -+-");
//                break;
//            }
//        }
//    }
//}