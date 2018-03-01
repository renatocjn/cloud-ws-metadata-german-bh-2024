package org.identifiers.org.cloud.ws.metadata.models;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;

/**
 * @author Manuel Bernal Llinares <mbdebian@gmail.com>
 * Project: metadata
 * Package: org.identifiers.org.cloud.ws.metadata.models
 * Timestamp: 2018-03-01 1:41
 * ---
 */
@Component
public class IdResourceSelectorBasedOnRecommendation implements IdResourceSelector {
    private static Logger logger = LoggerFactory.getLogger(IdResourceSelectorBasedOnRecommendation.class);
    
    @Override
    public ResolverApiResponseResource selectResource(List<ResolverApiResponseResource> resources) throws IdResourceSelectorException {
        resources.sort(Comparator.comparing(resolverApiResponseResource -> resolverApiResponseResource.getRecommendation().getRecommendationIndex()));
        return resources.get(resources.size() - 1);
    }
}
