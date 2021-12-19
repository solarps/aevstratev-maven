package HW17.DAO;

import HW17.Entity.Student;
import HW17.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class StudentDAO {

    public Student get(Integer id) {
        Student result;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            result = session.get(Student.class, id);
        }
        return result;
    }

    public Student saveOrUpdate(Student student) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.saveOrUpdate(student);
            session.getTransaction().commit();
        }
        return student;
    }

    public List<Student> getAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String sql = "SELECT st FROM Student st";
            return session.createQuery(sql, Student.class).getResultList();
        }
    }

    public List<Student> findByNameContaining(String partOfFullName) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String partOfName = "%" + partOfFullName + "%";
            String sql = "SELECT st FROM Student st WHERE st.fio LIKE: partOfName";
            return session.createQuery(sql, Student.class).setParameter("partOfName", partOfName).getResultList();
        }
    }
}
