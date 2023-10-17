package org.softuni.mobilele.model.entity;

import com.fasterxml.jackson.databind.ser.Serializers;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "brands")
@Getter
@Setter
public class BrandEntity extends BaseEntity {

    @Column(unique = true, nullable = false)
    private String brand;
}
