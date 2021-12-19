package HW17;

import HW17.DAO.StudentDAO;
import HW17.DAO.StudentGroupDAO;
import HW17.Entity.Student;
import HW17.Entity.StudentGroup;

public class Main {
    public static void main(String[] args) {
        StudentDAO studentDAO = new StudentDAO();
        StudentGroupDAO studentGroupDAO = new StudentGroupDAO();
        System.out.println(studentDAO.getAll() + "\n");
        System.out.println(studentDAO.get(2) + "\n");
        studentDAO.saveOrUpdate(new Student(null, "Alesha", studentGroupDAO.get(0), 2002));
        System.out.println(studentDAO.get(8) + "\n");
        System.out.println(studentDAO.findByNameContaining("Alesha") + "\n");
        System.out.println(studentGroupDAO.getAll() + "\n");
        studentGroupDAO.saveOrUpdate(new StudentGroup(3, "groupOfAlesh", null));
        System.out.println(studentGroupDAO.get(3));
    }
}
