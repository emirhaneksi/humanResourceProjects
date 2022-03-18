package com.example.humanResourcesProject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "permissions")
public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "employeeid")
    private int employeeId;
    @Column(name = "start_date")
    private LocalDate startDate;
    @Column(name = "finish_date")
    private LocalDate finishDate;
    @Column(name = "total_day")
    private int totalDay;
}
