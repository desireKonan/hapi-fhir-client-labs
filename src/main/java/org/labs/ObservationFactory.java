package org.labs;

import org.hl7.fhir.r4.model.Observation;
import org.hl7.fhir.r4.model.Patient;
import org.hl7.fhir.r4.model.Quantity;
import org.hl7.fhir.r4.model.Reference;

public class ObservationFactory {

    public static Observation createNewObservation(Patient patient) {
        Observation observation = new Observation();
        observation.setStatus(Observation.ObservationStatus.UNKNOWN);
        observation
                .getCode()
                .addCoding()
                .setSystem("http://loinc.org")
                .setCode("789-8")
                .setDisplay("Erythrocytes [#/volume] in Blood by Automated count");
        observation.setValue(
                new Quantity()
                        .setValue(4.12)
                        .setUnit("10 trillion/L")
                        .setSystem("http://unitsofmeasure.org")
                        .setCode("10*12/L"));
        // The observation refers to the patient using the ID, which is already
        // set to a temporary UUID
        observation.setSubject(new Reference(patient.getIdElement().getValue()));

        return observation;
    }
}
