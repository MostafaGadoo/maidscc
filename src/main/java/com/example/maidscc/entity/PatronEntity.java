package com.example.maidscc.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "\"Patron\"")
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class PatronEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "Contact information is mandatory")
    @Email(message = "Contact information should be a valid email address")
    private String contactInformation;

    @OneToMany(mappedBy = "patron", cascade = CascadeType.ALL)
    private List<BorrowingRecordEntity> borrowingRecords;


    public String getName() {
        return name;
    }

    public String getContactInformation() {
        return contactInformation;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setContactInformation(String contactInformation) {
        this.contactInformation = contactInformation;
    }
}
