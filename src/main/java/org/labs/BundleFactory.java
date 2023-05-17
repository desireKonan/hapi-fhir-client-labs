package org.labs;

import org.hl7.fhir.r4.model.Bundle;

public class BundleFactory {


    public static Bundle createNewBundle() {
        // Create a bundle that will be used as a transaction
        Bundle bundle = new Bundle();
        bundle.setType(Bundle.BundleType.DOCUMENT);
        return bundle;
    }
}
