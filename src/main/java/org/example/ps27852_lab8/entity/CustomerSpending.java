package org.example.ps27852_lab8.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerSpending {
    private String fullname;
    private Long quantity;
    private Double total;
}
