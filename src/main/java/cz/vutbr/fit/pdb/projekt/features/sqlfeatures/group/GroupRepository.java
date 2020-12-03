package cz.vutbr.fit.pdb.projekt.features.sqlfeatures.group;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<GroupTable, Integer> {

    int countByName(String name);

}
