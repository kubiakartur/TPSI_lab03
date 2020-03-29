/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 *
 * @author Moya
 */
public class Lab03 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Zadanie 1
        System.out.println("Zadanie1:");
        Set<String> zbiorDni = new TreeSet<>();
        zbiorDni.add("poniedziałek");
        zbiorDni.add("wtorek");
        zbiorDni.add("środa");
        zbiorDni.add("czwartek");
        zbiorDni.add("piątek");
        zbiorDni.add("sobota");
        zbiorDni.add("niedziela");        
        
        for(String dzien : zbiorDni) {
            System.out.println(dzien);
        }
        
        // Odpowiedzi na pytania:
        // 1. Hash używa struktury tablicy mieszanej, Tree używa struktury drzewa, więc jest wolniejszy
        //    Różnią się złożonościa obliczeniowa (jednak tutaj jej nie zobaczymy), oraz TreeSet posiada dodatkowe metody.  
        // 2. Np. HashSet nie gwarantuje jakiejkolwiek kolejności zapisu danych, podczas gdy dane w TreeSet sa względnie posortowane.
        // 3. W tym przypadku nie były wymagane zmiany w kodzie poza obiektem.
        
        // Zadanie 2
        System.out.println("\nPierwsza część zadania2:");
        Map<String, Teacher> nauczyciele = new HashMap<>();
        nauczyciele.put("programowanie obiektowe", new Teacher("Jan", "Kowalski", "Kowalski@gmail.com"));
        nauczyciele.put("etyka", new Teacher("Zenon", "Nowak", "Nowak@wp.pl"));
        nauczyciele.put("fizyka", new Teacher("Tomasz", "Gorący", "tomek999@wp.pl"));
        
        for(String przedmiot : nauczyciele.keySet()) {
            Teacher dane = nauczyciele.get(przedmiot);
            if (przedmiot == "programowanie obiektowe")
            {
                System.out.println(przedmiot + " - " + dane);
            }            
        }
        System.out.println("\nDruga cześć zadania2:");
        
        List<Student> grupa30 = new ArrayList<>();
        grupa30.add(new Student("Tom", "Hanks", "Hanks@gmail.com", "id30"));
        grupa30.add(new Student("Mike", "Tyson", "Tyson@gmail.com", "id30"));
        
        List<Student> grupa31 = new ArrayList<>();
        grupa31.add(new Student("Patryk", "Poprawa", "Poprawa@wp.pl", "id31"));
        grupa31.add(new Student("Michał", "Tyśkiewicz", "michał992@gmail.com", "id31"));
        
        List<Student> grupa32 = new ArrayList<>();
        grupa32.add(new Student("Pawel", "Dreichal", "Dreichal@onet.pl", "id32"));
        grupa32.add(new Student("Artur", "Ziemkiewicz", "tytka222@gmail.com", "id32"));       

        Map<Integer, List<Student>> grupy = new HashMap<>();
        grupy.put(30, grupa30);
        grupy.put(31, grupa31);
        grupy.put(32, grupa32);
        
        for (Integer nr_grupy : grupy.keySet())
        {            
            if (nr_grupy == 32)
            {
                System.out.println(nr_grupy + ": "+ grupy.get(nr_grupy));
            }
        }
        
        // Zadanie 3               
        System.out.println("\nZadanie 3:");
       
        try(BufferedReader in = new BufferedReader(new FileReader("produkty.txt"))) 
        {
            List <Product> lista_produktow = new ArrayList<>();
            Map <Integer, Product> mapa_produktowID = new HashMap<>();            
            Map<String, List<Product>> mapa_kategorii = new HashMap<>();
                       
            String linia = in.readLine();
            while(linia!=null)
            {                
                String[] pola = linia.split(";");
                int ID = Integer.parseInt(pola[0]);
                double Price = Double.parseDouble(pola[3]);
                Product produkt_linia = new Product(ID ,pola[1], Price, pola[2]);
                lista_produktow.add(produkt_linia);
                //mapa produktow po ID     
                mapa_produktowID.put(ID, produkt_linia);              
                //tworzy kategorie
                mapa_kategorii.put(produkt_linia.getCategory(), new ArrayList<Product>()); 
                                
                linia = in.readLine();
            }
            for (Product temp: lista_produktow)
            {
                List <Product> lista_produktow_z_kategorii = new ArrayList<>(); //tworzy nowa liste
                lista_produktow_z_kategorii = mapa_kategorii.get(temp.getCategory()); //pobiera juz istniejacych produktow z kategorii
                lista_produktow_z_kategorii.add(temp); //dodaje do niej nowy produkt tempa
                mapa_kategorii.put(temp.getCategory(), lista_produktow_z_kategorii); //dodaje do mapy         
            }
            // wszystkie produkty
            System.out.println(lista_produktow);
            // wyszukiwanie, dwa ostatanie punkty
            Product szukany_produkt = mapa_produktowID.get(110); // przez numer ID
            System.out.println("\nSzukany produkt: " + szukany_produkt);
            List<Product> szukana_kategoria = mapa_kategorii.get("oprogramowanie"); // przez nazwe kategorii
            System.out.println("Szukany kategoria: " + szukana_kategoria);
        } 
        catch (IOException ex) 
        {
            ex.printStackTrace();
        }
        
        
    }   
}