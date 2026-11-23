package com.starnoh.miniremittapp.transfer;

import java.math.BigDecimal;

public record TransferRequest(
        String senderName,
        String recipientName,
        BigDecimal amount,
        String currency
) {}