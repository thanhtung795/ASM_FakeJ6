package org.example.ps27852_lab8.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.ps27852_lab8.enums.OrderStatus;
import org.example.ps27852_lab8.enums.PaymentMethod;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "username", referencedColumnName = "username")
    private Account account;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "address")
    private String address;

    // Sử dụng Enum để quản lý trạng thái
    @Enumerated(EnumType.STRING) // Lưu dạng chuỗi trong database (PENDING, PAID, CANCELLED)
    @Column(name = "status")
    private OrderStatus status;

    @Enumerated(EnumType.STRING) // Lưu dạng chuỗi trong database (CASH, BANK_TRANSFER)
    @Column(name = "payment_method")
    private PaymentMethod paymentMethod;

    @OneToMany(mappedBy = "order")
    private Set<OrderDetail> orderDetails;

}
