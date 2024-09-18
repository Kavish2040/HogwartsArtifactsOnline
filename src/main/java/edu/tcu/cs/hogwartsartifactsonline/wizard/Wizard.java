package edu.tcu.cs.hogwartsartifactsonline.wizard;

import edu.tcu.cs.hogwartsartifactsonline.artifact.Artifact;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Wizard implements Serializable {

    // Fields
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "owner")
    // This means that if I save one wizard in the DB using Wizard repo then all the artifacts
    // associated with this wizard will be saved as well
    // Thus we only need to save wizards
    private List<Artifact> artifacts = new ArrayList<>();

    // Constructors
    public Wizard() {
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Artifact> getArtifacts() {
        return artifacts;
    }

    public void setArtifacts(List<Artifact> artifacts) {
        this.artifacts = artifacts;
    }

    public void addArtifact(Artifact artifact) {
        artifact.setOwner(this);
        this.artifacts.add(artifact);
    }

    public Integer getNumberOfArtifacts() {
        return this.artifacts.size();
    }

    public void removeArtifact(Artifact artifact) {
        artifact.setOwner(null);
        this.artifacts.remove(artifact);
    }

    public void removeAllArtifacts() {
        this.artifacts.stream().forEach(artifact -> artifact.setOwner(null));
        this.artifacts = null;
    }
}
