package services;

import dao.AddressDao;
import models.Address;
import org.apache.log4j.Logger;
import utils.ConnectionProvider;

public class AddressServiceImpl implements AddressService{

    public static final Logger logger = Logger.getLogger(AddressServiceImpl.class);

    public AddressDao addressDao = new AddressDao(ConnectionProvider.getConnection());
    public void saveAddress(Address address) {
        if (this.addressDao.save(address)){
            logger.info("Address saved successfully");
        }else {
            logger.info("something went wrong while savin address");
        }
    }
}
