package dao;

import model.CustomerDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerDAOImpl implements CustomerDAO{

    @Override
    public boolean add(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        return crudUtil.executeUpdate("INSERT INTO Customer (id,name, address) VALUES (?,?,?)", dto.getId(), dto.getName(), dto.getAddress());
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return crudUtil.executeUpdate("DELETE FROM Customer WHERE id=?", id);
    }

    @Override
    public boolean update(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        return crudUtil.executeUpdate("UPDATE Customer SET name=?, address=? WHERE id=?", dto.getName(), dto.getAddress(), dto.getId());
    }

    @Override
    public CustomerDTO search(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = crudUtil.executeQuery("SELECT FROM Customer WHERE id=?", id);
        rst.next();
        return new CustomerDTO(id, rst.getString("name"), rst.getString("address"));

    }

    @Override
    public ArrayList<CustomerDTO> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<CustomerDTO> allCustomers = new ArrayList();
        crudUtil.executeQuery("SELECT * FROM Customer");
        ResultSet rst = crudUtil.executeQuery("SELECT * FROM Customer");
        while (rst.next()) {
            allCustomers.add(new CustomerDTO(rst.getString("id"), rst.getString("name"), rst.getString("address")));
        }
        return allCustomers;
    }

    @Override
     public boolean ifCustomerExist(String id) throws SQLException, ClassNotFoundException {
      return  crudUtil.executeQuery("SELECT id FROM Customer WHERE id=?",id).next();
  }

    @Override
    public String generateNewId() throws SQLException, ClassNotFoundException {
        ResultSet rst = crudUtil.executeQuery("SELECT id FROM Customer ORDER BY id DESC LIMIT 1;");
        if (rst.next()) {
            String id = rst.getString("id");
            int newCustomerId = Integer.parseInt(id.replace("C", "")) + 1;
            return String.format("C%03d", newCustomerId);
        } else {
            return "C001";
        }
    }
}




   /* @Override
    public boolean add(Objects ob) {


        return false;
    }

    @Override
    public boolean delete(Objects ob) {
        return false;
    }

    @Override
    public boolean update(Objects ob) {
        return false;
    }

    @Override
    public Objects search(Objects ob) {
        return null;
    }

    @Override
    public ArrayList<Objects> getAll() {
        return null;
    }*/


/*

    Load all customers to tables--->>
    @Override
    public ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException {

        ArrayList<CustomerDTO> allCustomers = new ArrayList();
        crudUtil.executeQuery("SELECT * FROM Customer");
        ResultSet rst = crudUtil.executeQuery("SELECT * FROM Customer");
        while (rst.next()) {
            allCustomers.add(new CustomerDTO(rst.getString("id"), rst.getString("name"), rst.getString("address")));
        }

        return allCustomers;
    }


    Save customer--->>
    @Override
    public boolean addCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException {

        return crudUtil.executeUpdate("INSERT INTO Customer (id,name, address) VALUES (?,?,?)",dto.getId(),dto.getName(),dto.getAddress());


  }


  Update customer--->>
  @Override
  public boolean updateCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException {

      return crudUtil.executeUpdate("UPDATE Customer SET name=?, address=? WHERE id=?",dto.getName(),dto.getAddress(),dto.getId());
  }


    Delete Customer----->>>
  @Override
  public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException {
      return crudUtil.executeUpdate("DELETE FROM Customer WHERE id=?",id);
  }
  //
  @Override
  public boolean ifCustomerExist(String id) throws SQLException, ClassNotFoundException {

      return  crudUtil.executeQuery("SELECT id FROM Customer WHERE id=?",id).next();
  }


    ID Generate-->>
  @Override
  public String generateId() throws SQLException, ClassNotFoundException {
      ResultSet rst = crudUtil.executeQuery("SELECT id FROM Customer ORDER BY id DESC LIMIT 1;");
      if (rst.next()) {
          String id = rst.getString("id");
          int newCustomerId = Integer.parseInt(id.replace("C", "")) + 1;
          return String.format("C%03d", newCustomerId);
      } else {
          return "C001";
      }
  }*/


