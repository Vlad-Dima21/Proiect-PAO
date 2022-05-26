package com.proiect.services.io;

import com.proiect.domain.Ingredient;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IngredientIO implements GenericIO<Ingredient> {
    private static final IngredientIO INSTANCE = new IngredientIO();
    private static final String pathToCSVfile = "D:\\Facultate\\An_2_Sem_2\\PAO\\Proiect\\src\\main\\java\\com\\proiect\\resources\\ingrediente.csv";

    public static IngredientIO getInstance() {
        return INSTANCE;
    }

    @Override
    public List<Ingredient> getAllFromCSV() throws CustomException {
        try (BufferedReader IngredientReader = new BufferedReader(new FileReader(pathToCSVfile))) {
            int cnt = 0;    // used to ignore the header of the csv file
            String line;
            List<Ingredient> ingrediente = new ArrayList<>();
            while ((line = IngredientReader.readLine()) != null) {
                cnt++;
                if (cnt == 1) {
                    continue;
                }
                String[] values = line.split(",");
                try {
                    ingrediente.add(new Ingredient(values[0], Integer.parseInt(values[1]), Integer.parseInt(values[2]), values[3]));

                } catch (Exception e) {
                    throw new CustomException(String.format("In fisierul de la %s linia %d este gresita!", pathToCSVfile, cnt));
                }
            }
            return ingrediente;
        }catch (IOException e){
            return new ArrayList<>();
        }
    }

    public void writeAllToCSV(List<Ingredient> listOfEntities) throws IOException {
        BufferedWriter IngredientWriter = new BufferedWriter(new FileWriter(pathToCSVfile));
        IngredientWriter.write("nume,stoc,stocLunar,numeFurnizor\n");
        StringBuilder str = new StringBuilder();

        for (Ingredient ingredient : listOfEntities) {
                str.append(ingredient.toCSVformat()).append('\n');
            }

        IngredientWriter.write(str.toString().trim());
        IngredientWriter.close();
    }
}
