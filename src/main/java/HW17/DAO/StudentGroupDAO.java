package HW17.DAO;

import HW17.Entity.StudentGroup;
import HW17.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class StudentGroupDAO {
    public StudentGroup get(Integer id) {
        StudentGroup result;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            result = session.get(StudentGroup.class, id);
        }
        return result;
    }

    public List<StudentGroup> getAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String sql = "SELECT group FROM StudentGroup group";
            return session.createQuery(sql, StudentGroup.class).getResultList();
        }
    }

    public StudentGroup saveOrUpdate(StudentGroup studentGroup) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.saveOrUpdate(studentGroup);
            session.getTransaction().commit();
        }
        return studentGroup;
    }
}