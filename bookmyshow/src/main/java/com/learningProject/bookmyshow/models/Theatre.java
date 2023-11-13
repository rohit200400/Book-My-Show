package com.learningProject.bookmyshow.models;

import com.learningProject.bookmyshow.models.constants.BaseModel;
import com.learningProject.bookmyshow.models.constants.City;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Theatre extends BaseModel {
    private String name;
    private String address;
    @Enumerated(EnumType.STRING)
    private City city;

    @OneToMany(mappedBy = "theatre")
    @Cascade(CascadeType.ALL)
    private List<Auditorium> auditoriums;
}
