package org.labs;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.parser.IParser;
import ca.uhn.fhir.rest.client.api.IGenericClient;
import org.hl7.fhir.r4.model.Bundle;
import org.hl7.fhir.r4.model.Person;

public class IcarePatientService {

     private FhirContext fhirContext;

     public IcarePatientService(FhirContext fhirContext) {
         this.fhirContext = fhirContext;
     }

     public void printBundle(Bundle bundle) {
         // Create a client and post the transaction to the server
         IGenericClient client = this.fhirContext.newRestfulGenericClient("http://hapi.fhir.org/baseR4");
         Bundle resp = client
                 .transaction()
                 .withBundle(bundle)
                 .execute();
         IParser parser = fhirContext.newJsonParser().setPrettyPrint(true);
         String messageEncoded = parser.encodeResourceToString(resp);
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
