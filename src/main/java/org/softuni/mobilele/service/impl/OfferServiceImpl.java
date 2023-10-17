package org.softuni.mobilele.service.impl;

import org.softuni.mobilele.model.DTO.CreateOfferDTO;
import org.softuni.mobilele.service.OfferService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OfferServiceImpl implements OfferService {
    private final OfferService offerService;

    public OfferServiceImpl(OfferService offerService) {
        this.offerService = offerService;
    }

    @Override
    public UUID createOffer(CreateOfferDTO createOfferDTO) {

        throw new UnsupportedOperationException("Coming soon!");
    }
}
