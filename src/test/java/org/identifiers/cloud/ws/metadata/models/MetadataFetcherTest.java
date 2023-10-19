package org.identifiers.cloud.ws.metadata.models;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author Manuel Bernal Llinares <mbdebian@gmail.com>
 * Project: metadata
 * Package: org.identifiers.cloud.ws.metadata.models
 * Timestamp: 2018-02-12 13:28
 * ---
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MetadataFetcherTest {

    // TODO - Fix this unit test or kill it
    @Autowired
    MetadataFetcher metadataFetcher;

    @Test
    public void testValidMetadata() {
        // NOTE - Possible future extension here to make it more exhaustive
        // This unit test is too dependant on that particular URL to be up, as soon as this is working, I may
        // choose to deactivate this test
        getUrlsWithValidMetadata().parallelStream().forEach(validUrl -> {
            Object metadata = metadataFetcher.fetchMetadataFor(validUrl);
            assertThat(String.format("URL '%s' contains VALID metadata", validUrl), metadata == null, is(false));
        });
    }

    private List<String> getUrlsWithValidMetadata() {
        // TODO: Make port number dynamic after updating java to 17 and dependencies
        return Arrays.asList(
                "http://localhost:8082/page_with_metadata.html",
                "http://localhost:8082/page_with_metadata2.html");
    }
}