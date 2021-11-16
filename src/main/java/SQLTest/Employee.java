package SQLTest;

import lombok.Data;

@Data
public class Employee {
    private int id;
    private String name;
    private String last_name;
    private int dep_id;

    public Employee(int id, String name, String last_name, int dep_id) {
        this.id = id;
        this.name = name;
        this.last_name = last_name;
        this.dep_id = dep_id;
    }
}
