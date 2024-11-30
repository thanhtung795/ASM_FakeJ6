package org.example.ps27852_lab8.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Payment {
    private String status;
    private String message;
    private String url;
}
