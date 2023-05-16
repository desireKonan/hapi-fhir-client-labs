package org.labs;

import ca.uhn.fhir.model.api.annotation.*;
import ca.uhn.fhir.model.api.annotation.Extension;
import ca.uhn.fhir.util.ElementUtil;
import org.hl7.fhir.r4.model.*;
import java.util.UUID;

@ResourceDef(name = "Patient", profile="http://example.com/StructureDefinition/IcarePatient")
public class IcarePatient extends Patient {

    private static final long serialVersionUID = 1L;

    @Child(name = "uniqueId", modifier = true)
    @Extension(url = "http://acme.org/uniqueId", definedLocally = false)
    @Description(shortDefinition = "Unique Id for Icare Patient")
    protected UuidType uniqueId;

    @Child(name = "patientType", modifier = true)
    @Extension( url = "http://acme.org/type", definedLocally = false, isModifier = true)
    @Description(shortDefinition = "Icare Patient's type, just for extension.")
    protected CustomPatientType patientType;

    public IcarePatient() {
        super();
    }

    public IcarePatient(UUID uniqueId, IcarePatientType type) {
        super();
        this.uniqueId = new UuidType(uniqueId.toString());
        this.patientType = new CustomPatientType(type);
    }


    public String getUniqueId() {
        return uniqueId.getId();
    }

    public IcarePatient addUniqueId(UUID uniqueId) {
        this.uniqueId = new UuidType(uniqueId.toString());
        return this;
    }

    public CustomPatientType getType() {
        return patientType;
    }

    public IcarePatient addType(IcarePatientType type) {
        this.patientType = new CustomPatientType(type);
        return this;
    }

    @Override
    public boolean isEmpty() {
        return super.isEmpty() && ElementUtil.isEmpty(uniqueId, patientType);
    }

    @Block
    public static class CustomPatientType extends BackboneElement {
        private static final long serialVersionUID = 4522090347756045145L;
        @Child(name = "icarePatientType")
        @Extension(url = "http://acme.org/type", definedLocally = false, isModifier = false)
        private StringType icarePatientType;

        public CustomPatientType(IcarePatientType icarePatientType) {
            this.icarePatientType = new StringType(icarePatientType.getValue());
        }

        public StringType getIcarePatientType() {
            return icarePatientType;
        }

        public void setIcarePatientType(IcarePatientType icarePatientType) {
            this.icarePatientType = new StringType(icarePatientType.getValue());
        }


        @Override
        public boolean isEmpty() {
            return super.isEmpty() && ElementUtil.isEmpty(this.icarePatientType);
        }

        @Override
        public CustomPatientType copy() {
            return new CustomPatientType(IcarePatientType.valueOf(this.icarePatientType.getValue()));
        }
    }
}
