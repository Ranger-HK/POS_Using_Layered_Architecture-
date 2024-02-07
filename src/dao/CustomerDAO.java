package dao;

import model.CustomerDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Created By Ravindu Prathibha
 * @created 2/7/2024 - 12:26 PM
 * @project Layered_Architecture
 */
public interface CustomerDAO extends CrudDAO<CustomerDTO, String> {

     boolean ifCustomerExist(String id) throws SQLException, ClassNotFoundException;

     String generateNewId() throws SQLException, ClassNotFoundException;

