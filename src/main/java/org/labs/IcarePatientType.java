package org.labs;

public enum IcarePatientType {

    ICARE_PATIENT("Icare Patient"),
    CUSTOM_PATIENT("Custom Patient");

    private String value;

    IcarePatientType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
