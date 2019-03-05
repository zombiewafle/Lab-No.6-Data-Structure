import Classes.Factory;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.nio.file.*;


public class Main {

    public static void main(String[] args) {

        //Manejo de archivos en java: escribir en un archivo de texto (.txt),
        //(Octubre 2011). Extraido de:
        //http://codigoprogramacion.com/cursos/java/130-manejo-de-archivos-en-java-escribir-en-un-archivo-de-texto-txt.html#.XHm8SLi7200

        //--------------------------------------------
        //The creation of various variables
        boolean go1 = false;
        boolean go2 = false;
        boolean contains = false;
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
        Map<String,Integer> cardsQuantity = null;
        Map<String, String> Deck = null;
        Map<String, String> UserDeckOfCards = null;
        Factory<String, String> MappingFactory = new Factory<>();

        Map<String, String> sortedHashMapDeck = new HashMap<>(Deck);
        Map<String, String> sortedTreeMapDeck = new TreeMap<>(Deck);
        Map<String, String> sortedLinkedHashMapDeck = new LinkedHashMap<>(Deck);

        Map<String, String> sortedHashMapUserDeck = new HashMap<>(UserDeckOfCards);
        Map<String, String> sortedTreeMapUserDeck = new TreeMap<>(UserDeckOfCards);
        Map<String, String> sortedLinkedHashMapUserDeck = new LinkedHashMap<>(UserDeckOfCards);
        Integer typeOfMap = 0;

        //---------------------------------------------------------------------------------------------------------------------

        /*---------------------------------------------------------------------------------------------------------------------
        //The first menu, that permits you enter a file.
        String menu = "!!!Welcome to this program, please enter a .txt file" +
                "\n Enter the direction of the file.";
        */

        //---------------------------------------------------------------------------------------------------------------------
        //The second menu, that permits you enter to one of the 3 map methods.
        System.out.println("---------------------------------------------------------------------------------------------------");
        String menu1 = "Choose the method to proceed " +
                "\nMenu:" +
                "\n1. HashMap" +
                "\n2. TreeMap" +
                "\n3. LinkedHashMap" +
                "\n4. Exit";

        //---------------------------------------------------------------------------------------------------------------------
        //The third menu, that permits you to get access to one option.
        System.out.println("---------------------------------------------------------------------------------------------------");
        String menu2 = "\nMenu:" +
                "\n1. Add a card to the deck of cards." +
                "\n2. Show the type of a card,  by the name of the card." +
                "\n3. Show the name, type and quantity of all cards that the user have in his deck ." +
                "\n4. Show the name, type and quantity of all cards, that the user have in his deck, but order by type." +
                "\n5. Show the name and type of all existent cards in the deck." +
                "\n6. Show the name and type of all existent cards, but order by type." +
                "\n7. Exit";

        //---------------------------------------------------------------------------------------------------------------------

        //The file is being reading
        //How to open a text file and save it in ArrayList using Java,(2010). Extracted from: https://www.youtube.com/watch?v=HriXONQBo_U
        BufferedReader input = null;
        List<String> fileName = new ArrayList<String>();
        boolean file = false;
        //A try, catch, if file == null
        //Note: Change the path to the users text path
        try {
            System.out.println("Thanks for using my program");
            input = new BufferedReader(new FileReader("C:\\Users\\André Salazar\\IdeaProjects\\Lab No.6 Data Structure\\src\\lab.txt"));
            String nm;
            while ((nm = input.readLine()) != null) {
                file = true;
                fileName.add(nm);
            }
        } catch (Exception e) {
            file = false;
            System.out.println("No file found");
        }
        //Get the keys and the values from the .txt file and then split them by a ||.
        for(int i = 0; i < fileName.size(); i++){
            String[] keys = fileName.get(i).split(("  ||  "));
            Keys.add(i, keys[0]);
            Values.add(i, keys[1]);
        }

        //Put the keys and the values in the deck
        for (int i = 0; i < Keys.size(); i++){
            Deck.put(Keys.get(i), Values.get(i));
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


        if (file == true) {
            System.out.println("Please enter a valid option ");
            System.out.println("-------------------------------------------------------------");
            System.out.println(" ");
            System.out.println(menu1);
            System.out.println("  ");
            System.out.println("-------------------------------------------------------------");

            System.out.println("  ");
            String op = sc.nextLine();
            System.out.println("  ");

            switch(Integer.parseInt(op)){
                case 1:
                    go1 = true;
                    typeOfMap =1;
                    System.out.println("Please an option");
                    Deck = MappingFactory.SetType("HashMap");
                    UserDeckOfCards = MappingFactory.SetType("HashMap");
                    System.out.println("-------------------------------------------------------------");
                    System.out.println(" ");
                    System.out.println(menu2);
                    System.out.println("  ");
                    System.out.println("-------------------------------------------------------------");
                    break;

                case 2:
                    go1 = true;
                    typeOfMap =2;
                    System.out.println("Please an option");
                    Deck = MappingFactory.SetType("TreeMap");
                    UserDeckOfCards = MappingFactory.SetType("TreeMap");
                    System.out.println("-------------------------------------------------------------");
                    System.out.println(" ");
                    System.out.println(menu2);
                    System.out.println("  ");
                    System.out.println("-------------------------------------------------------------");
                    break;

                case 3:
                    go1 = true;
                    typeOfMap = 3;
                    System.out.println("Please an option");
                    Deck = MappingFactory.SetType("LinkedHashMap");
                    UserDeckOfCards = MappingFactory.SetType("LinkedHashMap");
                    System.out.println("-------------------------------------------------------------");
                    System.out.println(" ");
                    System.out.println(menu2);
                    System.out.println("  ");
                    System.out.println("-------------------------------------------------------------");
                    break;

                case 4:
                    System.out.println("Goodbye");
                    go1 = false;
                    break;

                default:
                    System.out.println("Invalid option");
                    return;
            }

        }
        if(go1 = true){
            System.out.println("  ");
            String op1 = sc.nextLine();
            System.out.println("  ");
            switch (Integer.parseInt(op1)){
                case 1:
                    System.out.println("Please enter the name of the card:");
                    String searchingCard = sc.nextLine();
                    if(Deck.containsKey(searchingCard .toUpperCase())){
                        UserDeckOfCards.put(searchingCard , Deck.get(searchingCard ));
                    }else{
                        System.out.println("That card doesn't exists");
                    }
                    break;

                case 2:
                    System.out.println("Please enter the type of a card");
                    searchingCard = sc.nextLine();
                    if(Deck.containsKey(searchingCard.toUpperCase())){
                        System.out.println("The card: "+ searchingCard.toUpperCase() +" ||Type: " + Deck.get(searchingCard.toUpperCase()));
                    }else{
                        System.out.println("The card doesn't exists");
                    }
                    break;

                case 3:
                    System.out.println("Now Im going to show all the cards that the user have in his deck");
                    for(String card: Deck.keySet()){
                        System.out.println("The card: " + card + "||Type: " + Deck.get(card) + "||Quantity of the cards: " + cardsQuantity.get(card));
                    }
                    break;

                case 4:
                    System.out.println("Now Im going to show all the cards that the user have in his deck, but ordered by type of card");
                    if(typeOfMap == 1){
                        System.out.println(sortedHashMapUserDeck);
                    }
                    else if(typeOfMap == 2){
                        System.out.println(sortedTreeMapUserDeck);
                    }
                    else if(typeOfMap == 3){
                        System.out.println(sortedLinkedHashMapUserDeck);
                    }
                    break;

                case 5:
                    System.out.println("Now Im going to show all existing cards");
                    for(String card: Deck.keySet()){
                        System.out.println("The card: " + card + "||Type: " + Deck.get(card));
                    }
                    break;

                case 6:
                    if(typeOfMap == 1){
                        System.out.println(sortedHashMapDeck);
                    }
                    else if(typeOfMap == 2){
                        System.out.println(sortedTreeMapDeck);
                    }
                    else if(typeOfMap == 3){
                        System.out.println(sortedLinkedHashMapDeck);
                    }
                    break;

                case 7:
                    System.out.println("Goodbye");
                    break;

                default:
                    System.out.println("Invalid option");
                    return;
            }
        }
    }
}