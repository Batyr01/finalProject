package kz.bitlab.finalProject.repository;

import jakarta.transaction.Transactional;
import kz.bitlab.finalProject.model.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface PermissionRepository extends JpaRepository<Permission, Long> {

    Permission findByName(String name);

}
