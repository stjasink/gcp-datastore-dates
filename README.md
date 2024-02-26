# GCP Datastore Date Test

This repo contains a test that saves a `LocalDate` using the GCP Datastore flavour of Spring Data.  Reading the 
`LocalDate` back, it is translated to a different date depending on the time zone of the process that loads it. 

Since this is a date only with no time or time zone associated with it, the time zone should make no difference to
the date value, and it should always load as the same.  So the assertion in the test fails.

To run this you will need to be authenticated to Google Cloud using a project that has Datastore enabled.
