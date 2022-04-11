package Stepanov.homework.Bookstore.repository;

import Stepanov.homework.Bookstore.entity.Ordering;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderingRepository extends JpaRepository<Ordering, Long> {

}
