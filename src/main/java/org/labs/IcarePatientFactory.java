package org.labs;

import org.hl7.fhir.r4.model.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class IcarePatientFactory {

    public static IcarePatient createIcarePatient() {
        IcarePatient patient = new IcarePatient()
                .addUniqueId(UUID.randomUUID())
                .addType(IcarePatientType.ICARE_PATIENT);
        patient.addName()
                .setFamily("Konan")
                .addGiven("Harvey Désiré")
                .addGiven("Rey");
        patient.setGender(Enumerations.AdministrativeGender.MALE);
        patient.setAddress(List.of(new Address().addLine("Abidjan, Cocody Soleil 3")));
        patient.setTelecom(List.of(new ContactPoint().setValue("+225 07-89-84-36-22")));
        patient.setBirthDate(new Date(1999, 01, 13));
        return patient;
    }


    public static Patient createNewPatient() {
        Patient patient = new Patient();
        patient.addIdentifier()
                .setSystem("http://acme.org/mrns")
                .setValue("12345");
        patient.addName()
                .setFamily("Jameson")
                .addGiven("J")
                .addGiven("Jonah");
        patient.setGender(Enumerations.AdministrativeGender.MALE);
        patient.setId(UUID.randomUUID().toString());
        patient.setActive(true);
        return patient;
    }
}
