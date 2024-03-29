package dao;

import model.ItemDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemDAOImpl implements CrudDAO<ItemDTO, String> {
    @Override
    public boolean add(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return crudUtil.executeUpdate("INSERT INTO Item (code, description, unitPrice, qtyOnHand) VALUES (?,?,?,?)", dto.getCode(), dto.getDescription(), dto.getUnitPrice(), dto.getQtyOnHand());
    }

    @Override
    public boolean delete(String code) throws SQLException, ClassNotFoundException {
        return crudUtil.executeUpdate("DELETE FROM Item WHERE code=?", code);
    }

    @Override
    public boolean update(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return crudUtil.executeUpdate("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?", dto.getDescription(), dto.getUnitPrice(), dto.getQtyOnHand(), dto.getCode());
    }

    @Override
    public ItemDTO search(String code) throws SQLException, ClassNotFoundException {
        ResultSet rst = crudUtil.executeQuery("SELECT FROM Item WHERE id=?", code);
        rst.next();
        return new ItemDTO(code, rst.getString("description"), rst.getBigDecimal("unitPrice"), rst.getInt("qtyOnHand"));
    }

    @Override
    public ArrayList<ItemDTO> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<ItemDTO> allItems = new ArrayList<>();
        ResultSet rst = crudUtil.executeQuery("SELECT * FROM Item");
        while (rst.next()) {
            allItems.add(new ItemDTO(rst.getString("code"), rst.getString("description"), rst.getBigDecimal("unitPrice"), rst.getInt("qtyOnHand")));
        }
        return allItems;
    }


     public boolean ifItemExist(String code) throws SQLException, ClassNotFoundException {
       return  crudUtil.executeQuery("SELECT code FROM Item WHERE code=?",code).next();
    }


    public String generateNewId() throws SQLException, ClassNotFoundException {
        ResultSet rst = crudUtil.executeQuery("SELECT code FROM Item ORDER BY code DESC LIMIT 1;");
        if (rst.next()) {
            String id = rst.getString("code");
            int newItemId = Integer.parseInt(id.replace("I", "")) + 1;
            return String.format("I%03d", newItemId);
        } else {
            return "I001";
        }
    }




    //Load all Items to tables--->>
   /* @Override
    public ArrayList<ItemDTO> getAllItem() throws SQLException, ClassNotFoundException {
        ArrayList<ItemDTO> items= new ArrayList<>();
        ResultSet rst = crudUtil.executeQuery("SELECT * FROM Item");

        ItemDAOImpl itemDAO = new ItemDAOImpl();
        itemDAO.getAllItem();
        while (rst.next()) {
            items.add(new ItemDTO(rst.getString("code"), rst.getString("description"), rst.getBigDecimal("unitPrice"), rst.getInt("qtyOnHand")));
        }
        return getAllItem();
    }

    Delete Item
    @Override
    public boolean deleteItem(String code) throws SQLException, ClassNotFoundException {

        return crudUtil.executeUpdate("DELETE FROM Item WHERE code=?", code);
    }


    //Save Items--->>
    @Override
    public boolean saveItem(ItemDTO dto) throws SQLException, ClassNotFoundException {

       return crudUtil.executeUpdate("INSERT INTO Item (code, description, unitPrice, qtyOnHand) VALUES (?,?,?,?)",dto.getCode(),dto.getDescription(),dto.getUnitPrice(), dto.getQtyOnHand());
    }


    //Update Items--->>
    @Override
    public boolean updateItem(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return  crudUtil.executeUpdate("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?",dto.getDescription(),dto.getUnitPrice(),dto.getQtyOnHand(),dto.getCode());
    }

    @Override
    public boolean ifItemExist(String code) throws SQLException, ClassNotFoundException {

        return  crudUtil.executeQuery("SELECT code FROM Item WHERE code=?",code).next();
    }


//    ID Generate-->>
    @Override
    public String generateNewId() throws SQLException, ClassNotFoundException {

        ResultSet rst = crudUtil.executeQuery("SELECT code FROM Item ORDER BY code DESC LIMIT 1;");
        if (rst.next()) {
            String id = rst.getString("code");
            int newItemId = Integer.parseInt(id.replace("I", "")) + 1;
            return String.format("I%03d", newItemId);
        } else {
            return "I001";
        }
    }*/

}
