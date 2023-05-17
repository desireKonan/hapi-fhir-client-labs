package org.labs;

import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.Extension;
import ca.uhn.fhir.model.api.annotation.ResourceDef;
import org.hl7.fhir.r4.model.DomainResource;
import org.hl7.fhir.r4.model.ResourceType;
import org.hl7.fhir.r4.model.StringType;


@ResourceDef(name = "Condition")
public class Condition extends DomainResource {
    private static final long serialVersionUID = 1L;
    @Child(name = "name", modifier = true)
    @Extension(url = "", isModifier = true)
    private StringType name;

    @Child(name = "description", modifier = true)
    @Extension(url = "", isModifier = true)
    private StringType description;


    public Condition(String name, String description) {
        super();
        this.name = new StringType(name);
        this.description = new StringType(description);
    }


    public StringType getName() {
        return name;
    }

    public void setName(String name) {
        this.name = new StringType(name);
    }

    public StringType getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = new StringType(description);
    }

    @Override
    public DomainResource copy() {
        return null;
    }

    @Override
    public ResourceType getResourceType() {
        return ResourceType.Condition;
    }
}
