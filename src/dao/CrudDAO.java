package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

public interface CrudDAO<T,ID> {
     boolean add(T t) throws SQLException, ClassNotFoundException;
     boolean delete(ID id) throws SQLException, ClassNotFoundException;
     boolean update(T t) throws SQLException, ClassNotFoundException;
    T search(ID id) throws SQLException, ClassNotFoundException;

    ArrayList<T> getAll() throws SQLException, ClassNotFoundException;

    boolean ifCustomerExist(ID id);
}