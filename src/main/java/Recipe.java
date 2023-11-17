import java.util.ArrayList;

public class Recipe {
    private ArrayList<String> ingredients;
    private int cookTime;
    private String name;


    public Recipe(String n, int c, ArrayList<String> i){
        cookTime = c;
        name = n;
        ingredients = i;
    }


    public String toString(){
        return name + ", cooking time: " + cookTime;
    }

    public String getName(){
        return name;
    }

    public ArrayList<String> getIngredients(){
        return ingredients;
    }

    public int getCookTime(){
        return cookTime;
    }
}
