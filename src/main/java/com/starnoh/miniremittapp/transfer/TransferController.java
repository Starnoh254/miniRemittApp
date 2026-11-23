package com.starnoh.miniremittapp.transfer;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/transfers")
public class TransferController {

    private final TransferService transferService;

    public TransferController(TransferService transferService) {
        this.transferService = transferService;
    }

    @PostMapping
    public ResponseEntity<Transfer> createTransfer(
            @RequestBody TransferRequest request
    ) {
        Transfer transfer = transferService.createTransfer(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(transfer);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transfer> getTransfer(
            @PathVariable UUID id
    ) {
        Transfer transfer = transferService.getTransfer(id);

        if (transfer == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(transfer);
    }
}
