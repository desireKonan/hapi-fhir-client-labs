package org.labs;

import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.Extension;
import ca.uhn.fhir.model.api.annotation.ResourceDef;
import org.hl7.fhir.r4.model.DecimalType;
import org.hl7.fhir.r4.model.DomainResource;
import org.hl7.fhir.r4.model.ResourceType;
import org.hl7.fhir.r4.model.StringType;


@ResourceDef(name = "CustomCoverage", profile = "http://hl7.org/fhir/profiles/custom-resource")
public class Coverage extends DomainResource {
    private static final long serialVersionUID = 1L;

    @Child(name = "name", modifier = true)
    @Extension(url = "name.com", isModifier = true)
    private StringType name;

    @Child(name = "description", modifier = true)
    @Extension(url = "description.com", isModifier = true)
    private StringType description;

    @Child(name = "rate", modifier = true)
    @Extension(url = "rate.com", isModifier = true)
    private DecimalType rate;


    public Coverage(String name, String description, double value) {
        this.name = new StringType(name);
        this.description = new StringType(description);
        this.rate = new DecimalType(value);
    }


    public StringType getName() {
        return name;
    }

    public Coverage setName(StringType name) {
        this.name = name;
        return this;
    }

    public StringType getDescription() {
        return description;
    }

    public Coverage setDescription(StringType description) {
        this.description = description;
        return this;
    }

    public DecimalType getRate() {
        return rate;
    }

    public Coverage setRate(DecimalType rate) {
        this.rate = rate;
        return this;
    }

    @Override
    public DomainResource copy() {
        return null;
    }

    @Override
    public ResourceType getResourceType() {
        return ResourceType.Coverage;
    }
}
