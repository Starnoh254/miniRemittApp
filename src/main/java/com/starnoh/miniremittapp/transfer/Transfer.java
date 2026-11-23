package com.starnoh.miniremittapp.transfer;

import com.starnoh.miniremittapp.transfer.TransferStatus;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "transfers")
public class Transfer {

    @Id
    private UUID id;

    private String senderName;
    private String recipientName;

    @Column(precision = 19, scale = 2)
    private BigDecimal amount;

    private String currency;

    @Enumerated(EnumType.STRING)
    private TransferStatus status;

    protected Transfer() {
        // Required by JPA
    }

    public Transfer(
            UUID id,
            String senderName,
            String recipientName,
            BigDecimal amount,
            String currency,
            TransferStatus status
    ) {
        this.id = id;
        this.senderName = senderName;
        this.recipientName = recipientName;
        this.amount = amount;
        this.currency = currency;
        this.status = status;
    }

    public UUID getId() {
        return id;
    }

    public String getSenderName() {
        return senderName;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    public TransferStatus getStatus() {
        return status;
    }
}