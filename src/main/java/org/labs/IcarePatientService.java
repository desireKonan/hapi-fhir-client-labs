package org.labs;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.parser.IParser;
import org.hl7.fhir.r4.model.Bundle;
import org.hl7.fhir.r4.model.Person;

public class IcarePatientService {

     private FhirContext fhirContext;

     public IcarePatientService(FhirContext fhirContext) {
         this.fhirContext = fhirContext;
     }

     public void printBundle(Bundle bundle) {
         // Create a client and post the transaction to the server
         IParser parser = fhirContext.newJsonParser().setPrettyPrint(true);
         String messageEncoded = parser.encodeResourceToString(bundle);
         // Log the response
         System.out.println(messageEncoded);
     }


     public void printPatient(IcarePatient patient) {
         IParser parser = fhirContext.newJsonParser().setPrettyPrint(true);
         String message = parser.encodeResourceToString(patient);
         System.out.println(message);
     }


    public void print(Person person) {
        IParser parser = fhirContext.newJsonParser().setPrettyPrint(true);
        String message = parser.encodeResourceToString(person);
        System.out.println(message);
    }
}
