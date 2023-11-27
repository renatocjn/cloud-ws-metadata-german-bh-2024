package org.identifiers.cloud.ws.metadata.models;

/**
 * @author Manuel Bernal Llinares <mbdebian@gmail.com>
 * Project: metadata
 * Package: org.identifiers.cloud.ws.metadata.models
 * Timestamp: 2018-02-08 11:54
 * ---
 */
public interface MetadataFetcher {
    Object fetchMetadataFor(String url) throws MetadataFetcherException;
}
