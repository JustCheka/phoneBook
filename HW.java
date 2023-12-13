import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;


class PhoneBook {
    private static HashMap<String, ArrayList> phoneBook = new HashMap<>();

    public void add(String name, String phoneNum) {
        if (phoneBook.containsKey(name)) {
            phoneBook.get(name).add(phoneNum);
        } else {
            ArrayList values = new ArrayList();
            values.add(phoneNum);
            phoneBook.put(name, values);
        }
    }

    public void printContacts(){
        ArrayList<Map.Entry<String, ArrayList>>  list =  new ArrayList<>(phoneBook.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, ArrayList>>() {
            @Override
            public int compare(Map.Entry<String,  ArrayList> o, Map.Entry<String, ArrayList> o1) {
            return o1.getValue().size() - o.getValue().size();
        }
        });

        for (Map.Entry<String, ArrayList> entry:list) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

}

public class HW {
    public static void main(String[] args) {
        PhoneBook pb = new PhoneBook();
        pb.add("Ivanov", "432432");
        pb.add("Petrov", "542542");
        pb.add("Ivanov", "32432432");
        pb.add("Petrov", "395495");
        pb.add("Frolov", "3904");
        pb.add("Ivanov", "342322321314");
        pb.printContacts();
        
    }
}