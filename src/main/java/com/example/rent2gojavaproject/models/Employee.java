package com.example.rent2gojavaproject.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.SQLDelete;
import java.util.List;

@Entity
@Table(name = "employees")
@Getter
@Setter
@AllArgsConstructor
@SQLDelete(sql = "update employees SET IS_ACTIVE = false WHERE id=?")
//@Where(clause = "IS_ACTIVE=true")
@FilterDef(name="isActiveFilterEmployee", parameters=@ParamDef( name="isActive", type=Boolean.class ))
@Filter(name="isActiveFilterEmployee", condition="IS_ACTIVE = :isActive")
public class Employee extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "salary", nullable = false)
    private double salary;

    @ManyToOne(optional = true)
    @JoinColumn(name = "user_id", columnDefinition = "integer default 1",nullable = false)
    private User user;

    /*@ManyToOne(optional = true)
    @JoinColumn(name = "department_id", columnDefinition = "integer default 1",nullable = false)
    private Department department;

    @ManyToOne(optional = true)
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

    @ManyToOne(optional = true)
    @JoinColumn(name = "county_id", nullable = false)
    private County county;*/

    @OneToMany(mappedBy = "employee")
    @JsonIgnore
    private List<Rental> rentals;


   //  Created empty constructor for default value.
    public Employee() {
        this.user = new User(1);
    }
}
