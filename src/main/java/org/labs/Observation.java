package org.labs;

import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.Extension;
import ca.uhn.fhir.model.api.annotation.ResourceDef;
import org.hl7.fhir.r4.model.DomainResource;
import org.hl7.fhir.r4.model.ResourceType;
import org.hl7.fhir.r4.model.StringType;

@ResourceDef(name = "CustomObservation")
public class Observation extends DomainResource {

    @Child(name = "name")
    @Extension(url = "name.com", isModifier = true)
    private StringType name;

    @Child(name = "description")
    @Extension(url = "description.com", isModifier = true)
    private StringType description;

    public Observation(String name, String description) {
        super();
        this.name = new StringType(name);
        this.description = new StringType(description);
    }

    public StringType getName() {
        return name;
    }

    public void setName(StringType name) {
        this.name = name;
    }

    public StringType getDescription() {
        return description;
    }

    public void setDescription(StringType description) {
        this.description = description;
    }

    @Override
    public DomainResource copy() {
        return null;
    }

    @Override
    public ResourceType getResourceType() {
        return ResourceType.Observation;
    }
}
