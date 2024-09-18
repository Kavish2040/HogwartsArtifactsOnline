package edu.tcu.cs.hogwartsartifactsonline.artifact;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtifactRepository extends JpaRepository<Artifact, String> {

}


// By extending this we get the most relevant crud methods
// for standard date access available in a standard repository