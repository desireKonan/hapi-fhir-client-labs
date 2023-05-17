package org.labs;

import ca.uhn.fhir.context.FhirContext;
import org.hl7.fhir.r4.model.Bundle;
import org.hl7.fhir.r4.model.Person;

public class HapiFhirLabApp {
    public static void main(String[] args) {
        IcarePatient patient = IcarePatientFactory.createIcarePatient();
        Person person = PersonFactory.createIcarePerson();
        Coverage coverage = new Coverage("Couverture maladie universelle", "ça concerne la couverture maladie universelle.", 0.15);
        Condition condition = new Condition("Conditionnement des médicaments", "Conditionnement des médicaments");
        Bundle bundle = BundleFactory.createNewBundle();

        bundle.addEntry()
                .setFullUrl(patient.getIdElement().getValue())
                .setResource(patient)
                .getRequest()
                .setUrl("Patient")
                .setIfNoneExist("identifier=http://acme.org/mrns|12345")
                .setMethod(Bundle.HTTPVerb.POST);

        bundle.addEntry()
                .setResource(person)
                .getRequest()
                .setUrl("Observation")
                .setMethod(Bundle.HTTPVerb.POST);

        bundle.addEntry()
                .setResource(coverage)
                .getRequest()
                .setUrl("CustomCoverage")
                .setMethod(Bundle.HTTPVerb.POST);

        bundle.addEntry()
                .setResource(condition)
                .getRequest()
                .setUrl("Condition")
                .setMethod(Bundle.HTTPVerb.POST);

        FhirContext context = FhirContext.forR4();
        //context.registerCustomType(Coverage.class);
        //context.registerCustomType(Condition.class);

        IcarePatientService icarePatientService = new IcarePatientService(context);
        icarePatientService.printBundle(bundle);
    }
}