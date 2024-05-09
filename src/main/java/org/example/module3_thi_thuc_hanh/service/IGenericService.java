package org.example.module3_thi_thuc_hanh.service;

import java.sql.SQLException;
import java.util.List;

public interface IGenericService<Generic> {
    public void insertInto(Generic generic) throws SQLException;

    public Generic selectById(int id);

    public List<Generic> selectAll();

    public boolean deleteById(int id) throws SQLException;

    public boolean update(Generic generic) throws SQLException;
}
