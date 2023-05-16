package org.labs;

import ca.uhn.fhir.context.FhirContext;
import org.hl7.fhir.r4.model.Person;

public class HapiFhirLabApp {
    public static void main(String[] args) {
        IcarePatient patient = IcarePatientFactory.createIcarePatient();
        Person person = PersonFactory.createIcarePerson();
        FhirContext context = FhirContext.forR4();
        IcarePatientService icarePatientService = new IcarePatientService(context);
        icarePatientService.printPatient(patient);
        icarePatientService.print(person);

        /*MyPatient patient = new MyPatient();
        patient.setPetName(new StringType("Fido"));
        patient.getImportantDates().add(new DateTimeType("2010-01-02"));
        patient.getImportantDates().add(new DateTimeType("2014-01-26T11:11:11"));

        patient.addName().setFamily("Smith").addGiven("John").addGiven("Quincy").addSuffix("Jr");

        IParser p = FhirContext.forR4().newJsonParser().setPrettyPrint(true);
        String messageString = p.encodeResourceToString(patient);

        System.out.println(messageString);*/

    }
}