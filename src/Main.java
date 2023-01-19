import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main{

    private static FileWriter writer;

    public static final String nazevSouboru = "kolekce.txt";
    public static void main(String[] args) {
        List<String> seznam = new ArrayList<>();

        try{
            FileWriter writer = new FileWriter("kolekce.txt");
            writer.write("Karel Dvořák" + "\n" +"Milada Dvořáková" + "\n" + "Karel Heřman");
            writer.close();
        }

        catch(IOException e) {
            e.printStackTrace();
        }

        try(Scanner scanner = new Scanner(new BufferedReader(new FileReader(nazevSouboru))))
        {

            while (scanner.hasNextLine()) {
                String prectenyRadek = scanner.nextLine();
                seznam.add(prectenyRadek);
            }

        }

        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        seznam.forEach(System.out::println);

    }
}