package HW17.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "`groups`")
@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class StudentGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_group")
    private Integer Id;

    @Column(name = "group_code")
    private String group_code;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "studentGroup")
    private List<Student> studentsInGroup;

    @Override
    public String toString() {
        return "StudentGroup{" + "Id=" + Id +
                ", group_code='" + group_code + '\'' +
                '}';
    }
}
