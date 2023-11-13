package com.learningProject.bookmyshow.models;

import com.learningProject.bookmyshow.models.constants.BaseModel;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Actor extends BaseModel {
    private String name;
}
