package org.labs;

import org.hl7.fhir.r4.model.*;
import org.hl7.fhir.r4.model.Enumerations.AdministrativeGender;

import java.util.UUID;

public class PersonFactory {


    public static Person createIcarePerson() {
        Person person = new Person()
                .addIdentifier(new Identifier()
                        .setValue(UUID.randomUUID().toString())
                )
                .addAddress(new Address()
                        .setCountry("Côte d'Ivoire")
                        .setCity("Abidjan")
                        .setDistrict("Abidjan").setText("Cocody Angré Soleil 3")
                )
                .addTelecom(new ContactPoint()
                        .setValue("+225 07 89 84 36 22"))
                .setGender(AdministrativeGender.MALE)
                .setActive(true);
        person.addName(new HumanName().setFamily("Konan").addGiven("Harvey Désiré"));
        return person;
    }
}
