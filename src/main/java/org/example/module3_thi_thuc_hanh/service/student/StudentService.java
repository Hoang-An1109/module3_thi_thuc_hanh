package org.example.module3_thi_thuc_hanh.service.student;

import org.example.module3_thi_thuc_hanh.model.Book;
import org.example.module3_thi_thuc_hanh.model.Student;
import org.example.module3_thi_thuc_hanh.service.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentService implements IStudentService{
    private Connection connection= ConnectionDB.getConnection();
    private static final String SELECT_ALL_STUDENT = "select * from student;";
    private static final String SELECT_STUDENT_BY_ID = "select * from student where id = ?;";
    @Override
    public void insertInto(Student student) throws SQLException {

    }

    @Override
    public Student selectById(int id) {
        Student student = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_STUDENT_BY_ID);
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String name = rs.getString("name");
                String classs = rs.getString("class");

                student = new Student(id,name,classs);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return student;
    }

    @Override
    public List<Student> selectAll() {
        List<Student> students = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STUDENT);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String classs = rs.getString("class");

                students.add(new Student(id,name,classs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return students;    }

    @Override
    public boolean deleteById(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Student student) throws SQLException {
        return false;
    }
}
