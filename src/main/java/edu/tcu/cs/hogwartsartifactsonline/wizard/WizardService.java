package edu.tcu.cs.hogwartsartifactsonline.wizard;

import edu.tcu.cs.hogwartsartifactsonline.artifact.Artifact;
import edu.tcu.cs.hogwartsartifactsonline.artifact.ArtifactRepository;
import edu.tcu.cs.hogwartsartifactsonline.artifact.utils.IdWorker;
import edu.tcu.cs.hogwartsartifactsonline.system.exception.ObjectNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class WizardService {

    private final WizardRepository wizardRepository;
    private final ArtifactRepository artifactRepository;
    private final IdWorker idWorker;

    // Constructor
    public WizardService(WizardRepository wizardRepository, ArtifactRepository artifactRepository, IdWorker idWorker) {
        this.wizardRepository = wizardRepository;
        this.artifactRepository = artifactRepository;
        this.idWorker = idWorker;
    }


    public Wizard findById(Integer wizardId){
        return this.wizardRepository.findById(wizardId)
                .orElseThrow(() -> new ObjectNotFoundException("wizard", wizardId));
    }

    public List<Wizard> findAll(){
        return this.wizardRepository.findAll();
    }

    public Wizard save(Wizard newWizard) {
        return this.wizardRepository.save(newWizard);
    }

    public Wizard update(Integer wizardId, Wizard update) {
        return this.wizardRepository.findById(wizardId)
                .map(oldWizard -> {
                    oldWizard.setName(update.getName());
                    return this.wizardRepository.save(oldWizard);
                })
                .orElseThrow(() -> new ObjectNotFoundException("wizard", wizardId));
    }

    public void delete(Integer wizardId) {
        Wizard wizard = this.wizardRepository.findById(wizardId)
                .orElseThrow(() -> new ObjectNotFoundException("wizard", wizardId));
        wizard.removeAllArtifacts();

        this.wizardRepository.deleteById(wizardId);
    }

    public void assignArtifact(Integer wizardId, String artifactId){
        // Find artifact
        Artifact artifact = this.artifactRepository.findById(artifactId)
                .orElseThrow(() -> new ObjectNotFoundException("artifact", artifactId));

        // Find wizard
        Wizard wizard = this.wizardRepository.findById(wizardId)
                .orElseThrow(() -> new ObjectNotFoundException("wizard", wizardId));

        // Assigning Artifact to Wizard
        if (artifact.getOwner() != null) {
            artifact.getOwner().removeArtifact(artifact);
        }
        wizard.addArtifact(artifact);
    }
}

