package Stepanov.homework.Bookstore.repository;

import Stepanov.homework.Bookstore.entity.BookWarehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookWarehouseRepository extends JpaRepository<BookWarehouse, Long> {

}
