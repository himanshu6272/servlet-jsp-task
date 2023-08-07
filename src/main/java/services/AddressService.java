package services;

import models.Address;

import java.util.List;

public interface AddressService {

    void saveAddress(Address address);

    List<Address> getAddressByUserId(int userId);

    void deleteAddress(int id);
    void updateAddress(Address address);
}
