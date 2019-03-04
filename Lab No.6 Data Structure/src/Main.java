import Classes.Factory;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.nio.file.*;


public class Main {

    public static void main(String[] args) {

        //Manejo de archivos en java: escribir en un archivo de texto (.txt), (Octubre 2011). Extraido de: http://codigoprogramacion.com/cursos/java/130-manejo-de-archivos-en-java-escribir-en-un-archivo-de-texto-txt.html#.XHm8SLi7200
        //Aqui se ingresa el archivo de texto, para luego ser leido.
        //--------------------------------------------
        //The creation of various variables
        boolean go1 = false;
        boolean go2 = false;
        String operation = "";
        String userCard = "";
        //AbstractMap<String,String> map = null;
        Scanner sc = new Scanner(System.in);
        //-------------------------------------------
        //The creation of various ArrayList to store the cards.
        ArrayList<String> Keys = new ArrayList<>();
        ArrayList<String> Values = new ArrayList<>();
        ArrayList<String> AllExistingKeys = new ArrayList<>();
        ArrayList<String> AllExistingValues = new ArrayList<>();
        //-------------------------------------------
        //ArrayLists to store the cards of the user in his deck, and the common deck.
        Map<String, String> Deck = null;
        Map<String, String> UserDeckOfCards= null;
        Factory<String, String> MappingFactory = new Factory<>();

        //---------------------------------------------------------------------------------------------------------------------
        //The first menu, that permits you enter a file.
        String menu = "!!!Welcome to this program, please enter a .txt file" +
                "\n Enter the direction of the file.";

        //---------------------------------------------------------------------------------------------------------------------
        //The second menu, that permits you enter to one of the 3 map methods.
        String menu1 = "Choose the method to proceed " +
                "\nMenu:" +
                "\n1. HashMap" +
                "\n2. TreeMap" +
                "\n3. LinkedHashMap" +
                "\n4. Exit";

        //---------------------------------------------------------------------------------------------------------------------
        //The third menu, that permits you to get access to one option.
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
        Scanner input = new Scanner(System.in);
        String path = input.nextLine();

        if(path == null){
            System.out.println("No file found");
            go1 = false;

        }else{
            ArrayList<String> card = new ArrayList<>();
            card.add(path);
            go1 = true;
            System.out.println("The file it's being reading");
        }

        /*
        System.out.println(menu);
        String dir = sc.nextLine();

        if(!dir == null){
            try{
                File fl = new File(dir);
                Scanner scanner = new Scanner(fl);

                System.out.println("Text was read");
                go1 = true;

            }catch (Exception e){
                System.out.println("No file found");
            }
        }else {
            System.out.println("Thanks for using this program");
        }
        */

        //------------------------------------------------------------------
        
        //Note: The second menu it repeats in the three mapping method.
        if(go1 == true){
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
                        System.out.println("Please enter a card name");
                        Scanner cardInput = new Scanner(System.in);
                        String cardsFinding  =  cardInput.nextLine();
                        UserDeckOfCards.put(userCard.toUpperCase(), Deck.get(userCard.toUpperCase()));
                        if(!Deck.containsKey(userCard.toUpperCase())){
                            System.out.println("The card tat you enter does not exist");
                            break;
                        }
                        break;

                        case 2:
                            System.out.println(UserDeckOfCards.get(userCard.toUpperCase()));
                            if(!UserDeckOfCards.containsKey(userCard.toUpperCase())){
                                System.out.println("The card tat you enter does not exist");
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
                            break;

                        case 4:
                            for(String Key: UserDeckOfCards.values()){
                                Values.add(Key);
                            }

                            for(String Value: UserDeckOfCards.values()){
                                Values.add(Value);
                            }
                            for(int j=0; j <=3; j++){
                                for(int i = 0; i < Values.size();i++){
                                    switch (j){
                                        case 0:
                                            if(Values.get(i).equals("Spell")){
                                                System.out.println(Keys.get(i) + " ||" + Values.get(i));

                                            }
                                            break;

                                        case 1:
                                            if(Values.get(i).equals("Monster")){
                                                System.out.println(Keys.get(i) + " || " + Values.get(i));
                                            }
                                            break;

                                        case 2:
                                            if(Values.get(i).equals("Trap")){
                                                System.out.println(Keys.get(i) + " || " + Values.get(i));
                                            }
                                            break;
                                    }
                                }
                            }
                                System.out.println("User has:" +  UserDeckOfCards.size() + "Cards");
                            break;
                        case 5:
                            for (String Key : Deck.keySet()){
                                AllExistingKeys.add(Key);
                            }
                            for(String Value : Deck.values()){
                                AllExistingValues.add(Value);
                            }

                            Collections.sort(AllExistingValues);
                            for(int i = 0; i < AllExistingKeys.size(); i++){
                                System.out.println("The key: " + AllExistingKeys.get(i) + ", and the Value is: " + AllExistingValues.get(i));
                            }
                            break;
                        case 6:
                            for(String Key: Deck.keySet()){
                                AllExistingKeys.add(Key);
                            }
                            for(String Value: Deck.values()){
                                AllExistingValues.add(Value);
                            }
                            //This method go over the all deck, and search for the card that the user enter.
                            for(int i = 0; i <=3; i++){
                                for(int n = 0; n < AllExistingValues.size(); n++){
                                    switch (i){
                                        case 0:
                                            if(AllExistingValues.get(n).equals("Spell")){
                                                System.out.println(AllExistingKeys.get(n) + " || " + AllExistingValues.get(n));
                                            }
                                            break;
                                        case 1:
                                            if(AllExistingValues.get(n).equals("Monster")){
                                                System.out.println(AllExistingKeys.get(n) + " || " + AllExistingValues.get(n));
                                            }
                                            break;
                                        case 2:
                                            if(AllExistingValues.get(n).equals("Trap")){
                                                System.out.println(AllExistingKeys.get(n) + " || " + AllExistingValues.get(n));
                                            }break;
                                    }
                                }
                            }
                            break;
                            //The exit case
                        case 7:
                            System.out.println("Thanks for using it");

                        default:
                            System.out.println("Non valid option was choose");
                    }
                    break;
                case 2:
                    Deck = MappingFactory.SetType("TreeMap");
                    UserDeckOfCards = MappingFactory.SetType("TreeMap");
                    //Prints the second menu.
                    System.out.println(menu2);
                    String op2= sc.nextLine();
                    //The whole options that the second menu have
                    switch (Integer.parseInt(op2)){
                        case 1:
                            Scanner scanner = new Scanner(userCard);
                            if(!Deck.containsKey(userCard.toUpperCase())){
                                System.out.println("The card tat you enter does not exist");
                                UserDeckOfCards.put(userCard.toUpperCase(), Deck.get(userCard.toUpperCase()));
                                break;
                            }
                            //
                        case 2:
                            if(!UserDeckOfCards.containsKey(userCard.toUpperCase())){
                                System.out.println("The card tat you enter does not exist");
                                System.out.println(UserDeckOfCards.get(userCard.toUpperCase()));
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
                            break;

                        case 4:
                            for(String Key: UserDeckOfCards.values()){
                                Values.add(Key);
                            }

                            for(String Value: UserDeckOfCards.values()){
                                Values.add(Value);
                            }
                            for(int j=0; j <=3; j++){
                                for(int i = 0; i < Values.size();i++){
                                    switch (j){
                                        case 0:
                                            if(Values.get(i).equals("Spell")){
                                                System.out.println(Keys.get(i) + " ||" + Values.get(i));

                                            }break;
                                    }
                                }
                            }
                            System.out.println("User has:" +  UserDeckOfCards.size() + "Cards");
                            break;
                        case 5:
                            for (String Key : Deck.keySet()){
                                AllExistingKeys.add(Key);
                            }
                            for(String Value : Deck.values()){
                                AllExistingValues.add(Value);
                            }

                            Collections.sort(AllExistingValues);
                            for(int i = 0; i < AllExistingKeys.size(); i++){
                                System.out.println("The key: " + AllExistingKeys.get(i) + ", and the Value is: " + AllExistingValues.get(i));
                            }
                            break;
                        case 6:
                            for(String Key: Deck.keySet()){
                                AllExistingKeys.add(Key);
                            }
                            for(String Value: Deck.values()){
                                AllExistingValues.add(Value);
                            }
                            for(int i = 0; i <=3; i++){
                                for(int n = 0; n < AllExistingValues.size(); n++){
                                    switch (i){
                                        case 0:
                                            if(AllExistingValues.get(n).equals("Spell")){
                                                System.out.println(AllExistingKeys.get(n) + " || " + AllExistingValues.get(n));
                                            }
                                            break;
                                        case 1:
                                            if(AllExistingValues.get(n).equals("Monster")){
                                                System.out.println(AllExistingKeys.get(n) + " || " + AllExistingValues.get(n));
                                            }
                                            break;
                                        case 2:
                                            if(AllExistingValues.get(n).equals("Trap")){
                                                System.out.println(AllExistingKeys.get(n) + " || " + AllExistingValues.get(n));
                                            }break;
                                    }
                                }
                            }
                            break;
                        case 7:
                            System.out.println("Thanks for using it");

                        default:
                            System.out.println("Non valid option was choose");
                    }
                    break;
                case 3:
                    System.out.println(menu2);
                    Deck = MappingFactory.SetType("LinkedHashMap");
                    UserDeckOfCards = MappingFactory.SetType("LinkedHashMap");
                    System.out.println(menu2);
                    String op3 = "";
                    switch (Integer.parseInt(op3)){
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
                            break;

                        case 4:
                            for(String Key: UserDeckOfCards.values()){
                                Values.add(Key);
                            }

                            for(String Value: UserDeckOfCards.values()){
                                Values.add(Value);
                            }
                            for(int j=0; j <=3; j++){
                                for(int i = 0; i < Values.size();i++){
                                    switch (j){
                                        case 0:
                                            if(Values.get(i).equals("Spell")){
                                                System.out.println(Keys.get(i) + " ||" + Values.get(i));

                                            }break;
                                    }
                                }
                            }
                            System.out.println("User has:" +  UserDeckOfCards.size() + "Cards");
                            break;
                        case 5:
                            for (String Key : Deck.keySet()){
                                AllExistingKeys.add(Key);
                            }
                            for(String Value : Deck.values()){
                                AllExistingValues.add(Value);
                            }

                            Collections.sort(AllExistingValues);
                            for(int i = 0; i < AllExistingKeys.size(); i++){
                                System.out.println("The key: " + AllExistingKeys.get(i) + ", and the Value is: " + AllExistingValues.get(i));
                            }
                            break;
                        case 6:
                            for(String Key: Deck.keySet()){
                                AllExistingKeys.add(Key);
                            }
                            for(String Value: Deck.values()){
                                AllExistingValues.add(Value);
                            }
                            for(int i = 0; i <=3; i++){
                                for(int n = 0; n < AllExistingValues.size(); n++){
                                    switch (i){
                                        case 0:
                                            if(AllExistingValues.get(n).equals("Spell")){
                                                System.out.println(AllExistingKeys.get(n) + " || " + AllExistingValues.get(n));
                                            }
                                            break;
                                        case 1:
                                            if(AllExistingValues.get(n).equals("Monster")){
                                                System.out.println(AllExistingKeys.get(n) + " || " + AllExistingValues.get(n));
                                            }
                                            break;
                                        case 2:
                                            if(AllExistingValues.get(n).equals("Trap")){
                                                System.out.println(AllExistingKeys.get(n) + " || " + AllExistingValues.get(n));
                                            }break;
                                    }
                                }
                            }
                            break;
                        case 7:
                            System.out.println("Thanks for using it");

                        default:
                            System.out.println("Non valid option was choose");
                    }
                    break;

                case 4:
                    System.out.println("Godbye, and thanks for using my program!!!");
                    break;
                default:
                    System.out.println("Ingrese una opcion valida!!!");
                    return;
            }
        }
        else{
            return;
        }

    }
}
