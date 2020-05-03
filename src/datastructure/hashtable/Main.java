package datastructure.hashtable;

public class Main {
    public static void main(String[] args) {
        Employee noi = new Employee("Noi", "Vu", 1);
        Employee thuy = new Employee("Thuy", "Thu", 2);
        Employee nam = new Employee("Nam", "Ha", 3);
        SimpleHashtable hashtable = new SimpleHashtable();
        hashtable.put("Noi", noi);
        hashtable.put("Thuy", thuy);
        hashtable.put("Nam", nam);
        hashtable.printHashtable();
        hashtable.remove("Noi");
        System.out.print("Key Noi" + hashtable.get("Nam"));
    }
}
