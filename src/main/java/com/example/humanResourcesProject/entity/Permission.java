package com.example.humanResourcesProject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

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
    private String employeeId;
    @Column(name = "start_date")
    private Date startDate;
    @Column(name = "finish_date")
    private Date finishDate;
    @Column(name = "total_day")
    private int totalDay;
}
