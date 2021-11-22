package collections.hashMap;

public class Employee {
    String name = null;
    public Employee(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public boolean equals(Object o){
        if (o instanceof Employee) {
            Employee e = (Employee) o;
            return this.name.equals(e.name);
        } else {
            return false;
        }
    }
    public int hashCode() {
        return name.hashCode();
    }
}
