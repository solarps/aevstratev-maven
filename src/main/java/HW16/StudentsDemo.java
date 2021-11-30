package HW16;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentsDemo {
    static Connection connection = ConnectionUtil.getConnection();

    public static void main(String[] args) {
        System.out.println(getStudentById(4));
        System.out.println(deleteStudentById(4));
        System.out.println(getStudentById(4));
        System.out.println(getAllStudents());
        System.out.println(getStudentListByLastName("Monroe"));
        ConnectionUtil.disconnect();
    }

    public static Student getStudentById(int id) {
        String query = "select * from students where id_student =?";
        Student student = new Student();
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                student.setId(resultSet.getInt("id_student"));
                student.setFIO(resultSet.getString("fio"));
                student.setIdGroup(resultSet.getInt("id_group"));
                student.setYearAdmission(resultSet.getInt("year_admission"));
                return student;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean deleteStudentById(int id) {
        String query = "delete from students where id_student =?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            return statement.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String query = "select * from students";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getInt("id_student"));
                student.setFIO(resultSet.getString("fio"));
                student.setIdGroup(resultSet.getInt("id_group"));
                student.setYearAdmission(resultSet.getInt("year_admission"));
                students.add(student);
            }
            return students;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Student> getStudentListByLastName(String lastName) {
        String query = "select * from students where fio like ?";
        List<Student> students = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, "%" + lastName + "%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getInt("id_student"));
                student.setFIO(resultSet.getString("fio"));
                student.setIdGroup(resultSet.getInt("id_group"));
                student.setYearAdmission(resultSet.getInt("year_admission"));
                students.add(student);
            }
            return students;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
