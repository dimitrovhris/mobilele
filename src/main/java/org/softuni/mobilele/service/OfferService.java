package org.softuni.mobilele.service;

import org.softuni.mobilele.model.DTO.CreateOfferDTO;

import java.util.UUID;

public interface OfferService {

    UUID createOffer(CreateOfferDTO createOfferDTO);
}
