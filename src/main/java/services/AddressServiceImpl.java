package services;

import dao.AddressDao;
import models.Address;
import org.apache.log4j.Logger;
import java.sql.SQLException;
import java.util.List;

public class AddressServiceImpl implements AddressService{

    public static final Logger logger = Logger.getLogger(AddressServiceImpl.class);

    public AddressDao addressDao = new AddressDao();
    public void saveAddress(Address address) throws SQLException {
        if (this.addressDao.save(address)){
            logger.info("Address saved successfully");
        }else {
            logger.info("something went wrong while savin address");
        }
    }


    public List<Address> getAddressByUserId(int userId) throws SQLException {
        List<Address> addresses = this.addressDao.getByUserId(userId);
        return addresses;
    }


    public void deleteAddress(int id) throws SQLException {
        if (this.addressDao.delete(id)){
            logger.info("Address deleted successfully");
        }else {
            logger.info("something went wrong");
        }
    }


    public void updateAddress(Address address) throws SQLException {
        if (this.addressDao.update(address)){
            logger.info("address updated");
        }else {
            logger.error("something went wrong");
        }
    }
}
