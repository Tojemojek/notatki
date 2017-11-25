package pl.sda.javawwa.hibernate.dao;

import pl.sda.javawwa.hibernate.entity.Product;

public interface ProductDao {

    public Product findById(Integer id);


}
