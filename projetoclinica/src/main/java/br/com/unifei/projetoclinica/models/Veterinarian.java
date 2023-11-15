package br.com.unifei.projetoclinica.models;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "VETERINARIAN")
public class Veterinarian {

    @Column(name = "VETERINARIAN_ID")
    @Id
    @UuidGenerator
    private String id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PHONE")
    private String phone;

    @Column(name = "SPECIALTY")
    private String specialty;

    @ManyToOne
    @JoinColumn(name = "CLINIC_ID")
    private Clinic clinic;

    @OneToMany(mappedBy = "veterinarian")
    private List<Scheduling> schedulings = new ArrayList<>();

    @OneToMany(mappedBy = "veterinarian")
    private List<Consulting> consultings = new ArrayList<>();
}
