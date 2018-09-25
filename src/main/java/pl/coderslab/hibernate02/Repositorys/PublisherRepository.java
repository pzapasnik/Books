package pl.coderslab.hibernate02.Repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.hibernate02.Entitys.Publisher;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {

    Publisher findByNip(String nip);

    Publisher findByRegon(String regon );
}
