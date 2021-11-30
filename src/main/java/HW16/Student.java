package HW16;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Student {
    private int id;
    private String FIO;
    private int idGroup;
    private int yearAdmission;
}
