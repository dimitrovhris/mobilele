package org.softuni.mobilele.model.entity;

import com.fasterxml.jackson.databind.ser.Serializers;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.softuni.mobilele.enums.EngineEnum;
import org.softuni.mobilele.enums.Transmission;

import java.math.BigDecimal;
import java.sql.Types;
import java.util.UUID;

@Entity
@Table(name = "offers")
@Getter
@Setter
public class OfferEntity extends BaseEntity {

    @JdbcTypeCode(Types.VARCHAR)
    private UUID uuid;

    private String description;

    private EngineEnum engine;

    private Transmission transmission;

    private String imageUrl;

    private Long mileage;

    private BigDecimal price;

    @ManyToOne
    private ModelEntity model;
}
