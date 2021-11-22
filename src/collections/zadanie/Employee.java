package collections.zadanie;

public class Employee {
        String name = null;
        Employee(String name) {
            this.name = name;
        }
        public String getName() {
            return name;
        }
        public boolean equals(Object o){
            if (o instanceof Employee) {
                Employee e = (Employee) o;
                return this.name.equals(e.name);
            }
            return false;
        }
        public int hashCode() {
            return name.hashCode();
        }
    }

