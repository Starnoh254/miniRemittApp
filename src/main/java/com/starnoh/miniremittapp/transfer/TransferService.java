package com.starnoh.miniremittapp.transfer;

import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.UUID;

@Service
public class TransferService {


    private final TransferRepository transferRepository;

    public TransferService(TransferRepository transferRepository) {
        this.transferRepository = transferRepository;
    }

    public Transfer createTransfer(TransferRequest request) {

        if (request.amount() == null ||
                request.amount().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException(
                    "Amount must be greater than zero"
            );
        }

        if (!"KES".equals(request.currency())) {
            throw new IllegalArgumentException(
                    "Only KES is supported"
            );
        }

        UUID id = UUID.randomUUID();

        Transfer transfer = new Transfer(
                id,
                request.senderName(),
                request.recipientName(),
                request.amount(),
                request.currency(),
                TransferStatus.CREATED
        );

        return transferRepository.save(transfer);
    }

    public Transfer getTransfer(UUID id) {
        return transferRepository.findById(id).orElse(null);
    }
}
