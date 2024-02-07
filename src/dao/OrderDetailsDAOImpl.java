package dao;

import model.OrderDetailDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDetailsDAOImpl implements CrudDAO<OrderDetailDTO, String> {

    @Override
    public boolean add(OrderDetailDTO orderDetailDTO) throws SQLException, ClassNotFoundException {
        return crudUtil.executeUpdate("INSERT INTO OrderDetails (oid, itemCode, unitPrice, qty) VALUES (?,?,?,?)",orderDetailDTO.getOid(),orderDetailDTO.getItemCode(),orderDetailDTO.getUnitPrice(),orderDetailDTO.getQty());
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(OrderDetailDTO orderDetailDTO) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public OrderDetailDTO search(String s) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<OrderDetailDTO> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

}
