package datastructure.hashtable;

public class SimpleHashtable {
    private EmployeeKey[] hashtable;

    public SimpleHashtable() {
        hashtable = new EmployeeKey[10];
    }

    private int hashKey(String key) {
        return key.length() % hashtable.length;
    }

    public void put(String key, Employee employee) {
        int hashedKey = hashKey(key);
        if (isOccupied(hashedKey)) {
            int stopIndex = hashedKey;
            if (hashedKey == hashtable.length - 1) {
                hashedKey = 0;
            } else {
                hashedKey++;
            }
            while (hashedKey != stopIndex && isOccupied(hashedKey)) {
                hashedKey = (hashedKey + 1) % hashtable.length;
            }
        }
        if (isOccupied(hashedKey)) {
            System.out.println("Key is already occupied");
            return ;
        }
        hashtable[hashedKey] = new EmployeeKey(key, employee);
    }

    private int findKey(String key) {
        int hashedKey = hashKey(key);
        if(isOccupied(hashedKey) && hashtable[hashedKey].key.equals(key)) {
           return hashedKey;
        }
        int stopIndex = hashedKey;
        if (hashedKey == hashtable.length - 1) {
            hashedKey = 0;
        } else {
            hashedKey++;
        }
        while (hashtable[hashedKey] != null && hashedKey != stopIndex && !hashtable[hashedKey].key.equals(key)) {
            hashedKey = (hashedKey + 1) % hashtable.length;
        }
        if (stopIndex == hashedKey) {
            return -1;
        }
        return hashedKey;
    }

    public void remove(String key) {
        int keyIndex = findKey(key);
        if (keyIndex == -1) {
            return;
        }
        hashtable[keyIndex] = null;
        EmployeeKey[] oldHashtables = hashtable;
        hashtable = new EmployeeKey[oldHashtables.length];
        // Re-hashing table
        for (EmployeeKey oldHashtable : oldHashtables) {
            if (oldHashtable != null) {
                put(oldHashtable.key, oldHashtable.employee);
            }
        }
    }

    private boolean isOccupied(int key) {
        return hashtable[key] != null;
    }

    public Employee get(String key) {
        int index = findKey(key);
        if (index == -1) return null;
        return hashtable[index].employee;
    }

    public void printHashtable() {
        for (EmployeeKey employeeKey: hashtable) {
            if (employeeKey != null) {
                System.out.println(employeeKey.employee);
            } else {
                System.out.println("empty");
            }
        }
    }
}
