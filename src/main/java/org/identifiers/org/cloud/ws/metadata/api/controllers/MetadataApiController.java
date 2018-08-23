package org.identifiers.org.cloud.ws.metadata.api.controllers;

import org.identifiers.org.cloud.ws.metadata.api.models.MetadataApiModel;
import org.identifiers.org.cloud.ws.metadata.api.requests.ServiceRequestFetchMetadataForUrl;
import org.identifiers.org.cloud.ws.metadata.api.responses.ServiceResponseFetchMetadata;
import org.identifiers.org.cloud.ws.metadata.api.responses.ServiceResponseFetchMetadataForUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Manuel Bernal Llinares <mbdebian@gmail.com>
 * Project: metadata
 * Package: org.identifiers.org.cloud.ws.metadata.controllers
 * Timestamp: 2018-02-07 11:29
 * ---
 */
@RestController
public class MetadataApiController {

    @Autowired
    private MetadataApiModel metadataApiModel;

    @RequestMapping(value = "{compactId}", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<?> getMetadataFor(@PathVariable("compactId") String compactIdParameter) {
        // TODO
        ServiceResponseFetchMetadata response = metadataApiModel.getMetadataFor(compactIdParameter);
        return new ResponseEntity<>(response, response.getHttpStatus());
    }

    @RequestMapping(value = "/getMetadataForUrl", method = RequestMethod.POST)
    public ResponseEntity<?> getMetadataForUrl(@RequestBody ServiceRequestFetchMetadataForUrl request) {
        ServiceResponseFetchMetadataForUrl response = metadataApiModel.getMetadataForUrl(request);
        return new ResponseEntity<>(response, response.getHttpStatus());
    }

    // liveness probe
    @RequestMapping(value = "/liveness_check")
    public String livenessCheck() {
        // TODO - This will be refactored out later, it will be the model who will implement the logic to determine
        // TODO - whether the service should be considered "alive" or not, but this code will live here for testing
        // TODO - purposes
        return metadataApiModel.livenessCheck();
    }

    // Readiness check
    @RequestMapping(value = "/readiness_check")
    public String readinessCheck() {
        // TODO - This will be refactored out later, it will be the model who will implement the logic to determine
        // TODO - whether the service should be considered "ready" or not, but this code will live here for testing
        // TODO - purposes
        return metadataApiModel.readinessCheck();
    }

}