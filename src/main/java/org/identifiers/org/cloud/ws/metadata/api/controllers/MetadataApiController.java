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
}
