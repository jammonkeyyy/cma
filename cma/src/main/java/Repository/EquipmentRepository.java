package Repository;

import com.example.demo.Model.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
/**
 * @author yxp
 */
public interface EquipmentRepository extends CrudRepository<Equipment, Long> {
    Equipment findById(Integer id);
}