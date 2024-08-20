package com.tiga.example;

import org.hl7.fhir.r4.model.Bundle.*;
import org.hl7.fhir.r4.model.Organization;

import java.util.Optional;

public class OrganizationSyncer {
;

    public static void main(String[] args) {
        String accessToken = TokenClient.getToken();

        var source = new FhirDataSource(EMPI_SERVER_URL, accessToken);
        var target= new FhirDataSource(CLINICAL_SERVER_URL,accessToken);

        var date = "2024-02-22";

        Optional<Organization> organization = source.getOrganizationById("1831cfbff30-bb907983-1618-4917-9cc1-e89a62a566e0");
        System.out.println("\n*Find organization by id: " + organization.get().getName() + "\n");

        var sourceOrganizations = source.getOrganizationByDate(date);
        for (BundleEntryComponent entry : sourceOrganizations.getEntry()) {
            Organization org = (Organization) entry.getResource();
            System.out.println("\n" + "Organization ID: " + org.getIdElement().getIdPart());
            System.out.println("Organization Name: " + org.getName());
            System.out.println("Last Updated: " + org.getMeta().getLastUpdated()+ "\n");
        }

        var targetOrganizations = target.getOrganizationByDate(date);
        for (BundleEntryComponent entry : sourceOrganizations.getEntry()) {
            if(targetOrganizations.isEmpty()) {
                target.createOrganization((Organization) entry.getResource(), EMPI_SERVER_URL, "12345");
            }
        }
    }
}
