// Course.java
package com.Learning.lms.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;
    
    @Column(columnDefinition = "TEXT")
    private String description;
    
    private String instructor;
    private BigDecimal price;
    private String duration;
    private String category;
    private String imageUrl;
    private Integer availableSeats;
    private LocalDateTime startDate;
    private LocalDateTime createdAt;
}
