package br.com.bellato.domain;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "TB_ENROLLMENT")
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "enroll_seq")
    @SequenceGenerator(name = "enroll_seq", sequenceName = "sq_enroll", initialValue = 1, allocationSize = 1)
    private long id;

    @Column(name = "CODE", length = 10, nullable = false, unique = true)
    private String code;

    @Column(name = "DATE_ENROLLMENT", nullable = false)
    private Instant dateEnrollment;

    @Column(name = "VALUE", nullable = false)
    private Double value;

    @Column(name = "STATUS", nullable = false)
    private String status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Instant getDateEnrollment() {
        return dateEnrollment;
    }

    public void setDateEnrollment(Instant dateEnrollment) {
        this.dateEnrollment = dateEnrollment;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
