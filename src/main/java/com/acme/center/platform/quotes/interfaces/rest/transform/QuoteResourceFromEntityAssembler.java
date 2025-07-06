package com.acme.center.platform.quotes.interfaces.rest.transform;

import com.acme.center.platform.quotes.domain.model.aggregates.Quote;
import com.acme.center.platform.quotes.interfaces.rest.resources.QuoteResource;

public class QuoteResourceFromEntityAssembler {
    public static QuoteResource toResourceFromEntity(Quote entity) {
        return new QuoteResource(
                entity.getId(),
                entity.getOrigin(),
                entity.getDestination(),
                entity.getDriver(),
                entity.getDriverImage(),
                entity.getPrice(),
                entity.getDate(),
                entity.getTime(),
                entity.getSeats(),
                entity.getLicensePlate(),
                entity.getCarBrand(),
                entity.getImage()
        );
    }
}
