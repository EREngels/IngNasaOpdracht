package nl.ing.nasa.persistence;

import nl.ing.nasa.persistence.dto.CallDto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CallRepository extends CrudRepository<CallDto, Integer>{

}
