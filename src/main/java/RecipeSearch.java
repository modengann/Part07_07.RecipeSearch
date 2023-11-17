import java.nio.file.Paths;
import java.util.*;

public class RecipeSearch {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("File to read:");
        String file = scanner.nextLine();
        // String file = "recipes.txt";
        ArrayList<Recipe> recipes = new ArrayList<>();
        ArrayList<String> lines = new ArrayList<>();
        try (Scanner fileReader = new Scanner(Paths.get(file))) {
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                if (!line.isEmpty()) {
                    lines.add(line);
                } else {
                    recipes.add(makeRecipe(lines));
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        recipes.add(makeRecipe(lines));
        printCommands();
        while (true) {
            System.out.print("Enter command: ");
            String command = scanner.nextLine();
            if (command.equals("stop")) {
                break;
            }
            runCommand(command, recipes, scanner);
        }

    }

    public static void runCommand(String command, ArrayList<Recipe> recipes, Scanner lineReader) {
        if (command.equals("list")) {
            System.out.println("\nRecipes:");
            for (Recipe r : recipes) {
                System.out.println(r);
            }
            System.out.println();

        } else if (command.equals("find name")) {
            System.out.print("Searched word: ");
            String name = lineReader.nextLine();

            System.out.println();
            System.out.println("Recipes");
            for (Recipe r : recipes) {
                if (r.getName().contains(name)) {
                    System.out.println(r);
                }
            }
            System.out.println("");
        }else if(command.equals("find ingredient")){
            System.out.print("Ingredient: ");
            String ingredient = lineReader.nextLine();
            System.out.println("Recipes:");
            for(Recipe r: recipes){

                if(r.getIngredients().contains(ingredient)){
                    System.out.println(r);
                }
            }
        }else if(command.equals("find cooking time")){
            System.out.print("Max cooking time: ");
            int cookTime = lineReader.nextInt();
            for(Recipe r: recipes){
                if(r.getCookTime() <= cookTime){
                    System.out.println(r);
                }
            }
        }
    }

    public static Recipe makeRecipe(ArrayList<String> lines) {
        String name = lines.get(0);
        int cookTime = Integer.valueOf(lines.get(1));
        ArrayList<String> ingredients = new ArrayList<>();
        for (int i = 2; i < lines.size(); i++) {
            ingredients.add(lines.get(i));
        }
        Recipe temp = new Recipe(name, cookTime, ingredients);

        lines.clear();
        return temp;
    }

    public static void printCommands(){
        System.out.println("Commands");
        System.out.println("list - lists the recipes");
        System.out.println("stop - stops the program");
        System.out.println("find name - searches recipes by name\r\n" + //
                "find cooking time - searches recipes by cooking time\r\n" + //
                "find ingredient - searches recipes by ingredient\r\n");
    }

}
