package pl.polsl.mushrooms.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import pl.polsl.mushrooms.application.model.Discovery;

import java.util.Collection;
import java.util.Set;



@Repository
@RepositoryRestResource(exported = false)
public interface DiscoveryRepository extends JpaRepository<Discovery, Long> {

    Set<Discovery> findByMushroomsSpeciesNameIgnoreCaseContaining(String mushroomsSpeciesName);

    Set<Discovery> findByIsPublicAndMushroomsSpeciesNameIgnoreCaseContaining(boolean isPublic,
                                                                             String mushroomsSpeciesName);

    @Query("SELECT d FROM Mushroomer m " +
            "JOIN m.users f " +
            "JOIN f.discoveries d " +
            "JOIN d.mushroomsSpecies ms " +
            "WHERE m.id = :userId AND UPPER(ms.name) LIKE UPPER(CONCAT('%', :speciesName, '%'))")
    Set<Discovery> findByFriends(@Param("userId") long userId, @Param("speciesName") String speciesName);

    Collection<? extends Discovery> findByMushroomerIdAndMushroomsSpeciesNameIgnoreCaseContaining(Long mushroomerId,
                                                                                                  String mushroomsSpeciesName);
}
