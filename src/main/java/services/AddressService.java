package services;

import models.Address;

import java.util.List;

public interface AddressService {

    void saveAddress(Address address);

    List<Address> getAddressByUserId(int userId);
}
