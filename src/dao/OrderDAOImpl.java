package dao;

import model.OrderDTO;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

public class  OrderDAOImpl implements CrudDAO<OrderDTO, String> {

    @Override
    public boolean add(OrderDTO orderDTO) throws SQLException, ClassNotFoundException {
        return crudUtil.executeUpdate("INSERT INTO `Orders` (oid, date, customerID) VALUES (?,?,?)", orderDTO.getOrderId(), orderDTO.getOrderDate());

    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(OrderDTO orderDTO) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public OrderDTO search(String s) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<OrderDTO> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

}
