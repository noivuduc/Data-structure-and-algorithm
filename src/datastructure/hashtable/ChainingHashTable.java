package datastructure.hashtable;

import java.util.Arrays;
import java.util.LinkedList;

public class ChainingHashTable {
    LinkedList<EmployeeKey>[] hashtable;
    public ChainingHashTable() {
        hashtable = new LinkedList[10];
        Arrays.fill(hashtable, new LinkedList<EmployeeKey>());
    }

    private int hashKey(String key) {
        return Math.abs(key.hashCode() % hashtable.length);
    }

    public void put(String key, Employee employee) {
        int index = hashKey(key);
        hashtable[index].add(new EmployeeKey(key, employee));
    }

    public Employee get(String key) {
        int index = hashKey(key);
        LinkedList<EmployeeKey> employeeKeys = hashtable[index];
        EmployeeKey employeeKey = null;
        for (EmployeeKey item: employeeKeys) {
            if (item.key.equals(key)) {
                employeeKey = item;
                break;
            }
        }
        if (employeeKey == null) {
            return null;
        }
        return employeeKey.employee;
    }

    public Employee remove(String key) {
        int index = hashKey(key);
        LinkedList<EmployeeKey> employeeKeys = hashtable[index];
        EmployeeKey employeeKey = null;
        for (EmployeeKey item: employeeKeys) {
            if (item.key.equals(key)) {
                employeeKey = item;
                break;
            }
        }
        if (employeeKey == null) {
            return null;
        }
        employeeKeys.remove(employeeKey);
        return employeeKey.employee;
    }


}
