package services;

import models.Address;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

public interface AddressService extends Serializable {

    void saveAddress(Address address) throws SQLException;

    List<Address> getAddressByUserId(int userId) throws SQLException;

    void deleteAddress(int id) throws SQLException;
    void updateAddress(Address address) throws SQLException;
}
