package dao;

import db.DBConnection;
import model.OrderDTO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
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
    public OrderDTO search(String code) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = crudUtil.executeQuery("SELECT oid FROM `Orders` WHERE oid=?", code);
        resultSet.next();
        return new OrderDTO(resultSet.getString("oid"), LocalDate.parse(resultSet.getString("date")),resultSet.getString("customerId"));
    }

    @Override
    public ArrayList<OrderDTO> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }



}
