import Classes.Factory;
import java.io.*;
import java.util.*;
import java.nio.file.*;


public class Main {

    public static void main(String[] args) {

        //Manejo de archivos en java: escribir en un archivo de texto (.txt), (Octubre 2011). Extraido de: http://codigoprogramacion.com/cursos/java/130-manejo-de-archivos-en-java-escribir-en-un-archivo-de-texto-txt.html#.XHm8SLi7200
        //Aqui se ingresa el archivo de texto, para luego ser leido.
        boolean go = true;
        boolean go1 = false;
        boolean go2 = false;
        String operation = "";
        String userCard = "";
        //AbstractMap<String,String> map = null;
        Scanner sc = new Scanner(System.in);
        //-------------------------------------------

        ArrayList<String> Keys = new ArrayList<>();
        ArrayList<String> Values = new ArrayList<>();
        ArrayList<String> AllExistingKeys = new ArrayList<>();
        ArrayList<String> AllExistingValues = new ArrayList<>();
        //-------------------------------------------
        Map<String, String> Deck = null;
        Map<String, String> UserDeckOfCards= null;
        Factory<String, String> MappingFactory = new Factory<>();

        //---------------------------------------------------------------------------------------------------------------------

        String menu = "!!!Welcome to this program, please enter a .txt file" +
                "\n Enter the direction of the file.";

        //---------------------------------------------------------------------------------------------------------------------

        String menu1 = "Choose the method to proceed " +
                "\nMenu:" +
                "\n1. HashMap" +
                "\n2. TreeMap" +
                "\n3. LinkedHashMap" +
                "\n4. Exit";

        //---------------------------------------------------------------------------------------------------------------------

        String menu2 = "\nMenu:" +
                "\n1. Add a card to the deck of cards." +
                "\n2. Show the type of a card,  by the name and the type." +
                "\n3. Show the name, type and quantity of a card, that the user have in his deck of cards." +
                "\n4. Show the name, type and quantity of a card, that the user have in his deck, but order by type." +
                "\n5. Show the name and the type of all the existent cards." +
                "\n6. Show the name and the type of all the existent cards, but order by type.";

        //---------------------------------------------------------------------------------------------------------------------

        //The file is being reading
        System.out.println(menu);
        String dir = sc.nextLine();

        if(!dir.equals("0")){
            try{
                File fl = new File(dir);
                Scanner scanner = new Scanner(fl);

                while (scanner.hasNextLine()){
                    operation += scanner.next();
                }
                System.out.println("Text was read");
                go1 = true;

            }catch (Exception e){
                System.out.println("No file found");
            }
        }else {
            System.out.println("Thanks for using this program");
        }

        //------------------------------------------------------------------

        if(go1){
            System.out.println(menu1);
            String op = sc.nextLine();

            switch (Integer.parseInt(op)){
                case 1:
                    Deck = MappingFactory.SetType("HashMap");
                    UserDeckOfCards = MappingFactory.SetType("HashMap");
                    System.out.println(menu2);
                    String op1 = sc.nextLine();
                    switch (Integer.parseInt(op1)){
                        case 1:
                        Scanner scanner = new Scanner(userCard);
                        if(!Deck.containsKey(userCard.toUpperCase())){
                            System.out.println("The card tat you enter does not exist");
                            UserDeckOfCards.put(userCard.toUpperCase(), Deck.get(userCard.toUpperCase()));
                            break;
                    }
                        case 2:
                            if(!UserDeckOfCards.containsKey(userCard.toUpperCase())){
                                System.out.println("The card tat you enter does not exist");
                                System.out.println(UserDeckOfCards.get(userCard.toUpperCase()));
                                go2 = true;
                                break;
                            }
                        case 3:
                            for(String Key : UserDeckOfCards.values()){
                                Keys.add(Key);
                            }
                            for(String values : UserDeckOfCards.values()){
                                Values.add(values);
                            }
                            Collections.sort(Values);
                            for (int i = 0; i < Keys.size(); i++) {
                                System.out.println("Key: " + Keys.get(i) + ", Value: " + Values.get(i));
                            }
                            System.out.println("User has: " + UserDeckOfCards.size() + " Cards");

                    }
                    break;
                case 2:
                    Deck = MappingFactory.SetType("TreeMap");
                    UserDeckOfCards = MappingFactory.SetType("TreeMap");
                    System.out.println(menu2);
                    String op2= sc.nextLine();
                    switch (Integer.parseInt(op2)){
                        case 1:
                            Scanner scanner = new Scanner(userCard);
                            if(!Deck.containsKey(userCard.toUpperCase())){
                                System.out.println("The card tat you enter does not exist");
                                UserDeckOfCards.put(userCard.toUpperCase(), Deck.get(userCard.toUpperCase()));
                                break;
                            }
                        case 2:
                            if(!UserDeckOfCards.containsKey(userCard.toUpperCase())){
                                System.out.println("The card tat you enter does not exist");
                                System.out.println(UserDeckOfCards.get(userCard.toUpperCase()));
                                go2 = true;
                                break;
                        }
                        case 3:

                    }
                    break;
                case 3:
                    System.out.println(menu2);
                    Deck = MappingFactory.SetType("LinkedHashMap");
                    UserDeckOfCards = MappingFactory.SetType("LinkedHashMap");
                    System.out.println(menu2);

                    go2 = true;
                    break;
                default:
                    System.out.println("Ingrese una opcion valida!!!");
                    return;
            }
        }

    }
}
