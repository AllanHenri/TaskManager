package com.allan.taskmanager.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "tasks")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120)
    private String title;

    @Column(length = 500)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private TaskStatus status;

   @Column(nullable = false)
   private LocalDateTime createdAt;

   @Column(nullable = false)
   private LocalDateTime updatedAt;

   @PrePersist
    void prePersist(){
       var now = LocalDateTime.now();
       createdAt = now;
       updatedAt = now;
       if (status == null) status = TaskStatus.TODO;
   }

   @PreUpdate
    void preUpdate(){
       updatedAt = LocalDateTime.now();
   }
}
