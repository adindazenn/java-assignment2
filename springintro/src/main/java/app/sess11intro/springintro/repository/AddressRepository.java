package app.sess11intro.springintro.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import app.sess11intro.springintro.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {
  
}
