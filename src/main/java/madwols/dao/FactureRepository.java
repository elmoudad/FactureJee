package madwols.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;




import madwols.entities.Facture;

public interface FactureRepository extends JpaRepository<Facture , Integer> {
	@Query("select f from Facture f where nomSoc like :x ")
	public Page<Facture> findBySocName(@Param("x") String motCle,Pageable pageable );
	
	
	@Query("select f from Facture f where numero like :x ")
	public List<Facture> getFactureByID(@Param("x") Integer numero); 

	

}
