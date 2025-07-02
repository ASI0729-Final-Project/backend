package com.acme.center.platform.quotes.interfaces.rest.transform;

import com.acme.center.platform.quotes.domain.model.commands.CreateQuoteCommand;
import com.acme.center.platform.quotes.interfaces.rest.resources.CreateQuoteResource;

public class CreateQuoteCommandFromResourceAssembler {
    public static CreateQuoteCommand toCommandFromResource(CreateQuoteResource resource) {
        return new CreateQuoteCommand(
                resource.origin(),
                resource.destination(),
                resource.driver(),
                resource.driverImage(),
                resource.price(),
                resource.date(),
                resource.time(),
                resource.seats(),
                resource.licensePlate(),
                resource.carBrand(),
                resource.image()
        );
    }
}
