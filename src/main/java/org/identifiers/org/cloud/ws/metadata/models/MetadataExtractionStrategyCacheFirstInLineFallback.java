package org.identifiers.org.cloud.ws.metadata.models;

import org.identifiers.cloud.libapi.models.resolver.ResolvedResource;

import java.util.List;

/**
 * Project: metadata
 * Package: org.identifiers.org.cloud.ws.metadata.models
 * Timestamp: 2018-09-17 18:27
 *
 * @author Manuel Bernal Llinares <mbdebian@gmail.com>
 * ---
 */
public class MetadataExtractionStrategyCacheFirstInLineFallback implements MetadataExtractionStrategy {
    @Override
    public String extractMetadata(List<ResolvedResource> resolvedResources) throws MetadataExtractionStrategyException {
        return null;
    }
}
