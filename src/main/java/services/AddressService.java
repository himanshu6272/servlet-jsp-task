package services;

import models.Address;

import java.io.Serializable;
import java.util.List;

public interface AddressService extends Serializable {

    void saveAddress(Address address);

    List<Address> getAddressByUserId(int userId);

    void deleteAddress(int id);
    void updateAddress(Address address);
}
