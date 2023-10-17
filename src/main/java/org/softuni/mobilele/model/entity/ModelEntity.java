package org.softuni.mobilele.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.softuni.mobilele.enums.ModelCategory;

@Entity
@Table(name = "models")
@Getter
@Setter
public class ModelEntity extends BaseEntity{

    @Column
    private String name;

    @Enumerated(EnumType.STRING)
    private ModelCategory category;

    @ManyToOne
    private BrandEntity brand;
}
