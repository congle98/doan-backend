package com.shoppingbackend.services.address;
import com.shoppingbackend.models.Address;
import java.util.Optional;

public interface IAddressService {
    Iterable<Address> findAll();
    Optional<Address> findById(Long id);
    Address save(Address address);
    Address update(Address address);
    void delete(Long id);
}
