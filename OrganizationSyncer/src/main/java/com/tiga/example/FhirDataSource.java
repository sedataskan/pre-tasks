package com.tiga.example;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.rest.client.api.IGenericClient;
import ca.uhn.fhir.rest.client.interceptor.BearerTokenAuthInterceptor;
import ca.uhn.fhir.rest.param.DateRangeParam;
import org.hl7.fhir.r4.model.Bundle;
import org.hl7.fhir.r4.model.Organization;

import java.util.Optional;

public class FhirDataSource {

    private final IGenericClient fhirClient;

    public FhirDataSource(String baseUrl, String token) {
        FhirContext fhirContext = FhirContext.forR4();
        fhirClient = fhirContext.newRestfulGenericClient(baseUrl);
        this.fhirClient.registerInterceptor(new BearerTokenAuthInterceptor(token));
    }

    public Optional<Organization> getOrganizationById(String id) {
        var organization =  fhirClient
                .read()
                .resource(Organization.class)
                .withId(id)
                .execute();

        if (organization == null) {
            return Optional.empty();
        }
        return Optional.of(organization);
    }

    public Bundle getOrganizationByDate(String startDate) {
       var query = fhirClient
               .search()
               .forResource(Organization.class)
               .lastUpdated(new DateRangeParam(startDate, "2024-02-28"))
               .returnBundle(Bundle.class);
        return query.execute();
    }

    public void createOrganization(Organization organization, String system, String value) {
        organization.setName("snt");

        organization
                .addIdentifier()
                .setSystem(system)
                .setValue(value);

        var org = fhirClient
                .create()
                .resource(organization)
                .execute();
    }
}
