package org.identifiers.org.cloud.ws.metadata.models;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author Manuel Bernal Llinares <mbdebian@gmail.com>
 * Project: metadata
 * Package: org.identifiers.org.cloud.ws.metadata.models
 * Timestamp: 2018-02-12 14:31
 * ---
 */
@Component
@Scope("prototype")
public class MetadataFetcherWithJavascript implements MetadataFetcher {
    private Logger logger = LoggerFactory.getLogger(MetadataFetcherWithJavascript.class);

    @Override
    public String fetchMetadataFor(String url) throws MetadataFetcherException {
        return null;
    }
}