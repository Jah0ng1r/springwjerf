package uz.tuitfb.spring2.web.rest;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.tuitfb.spring2.domain.Transaction;
import uz.tuitfb.spring2.service.TransactionService;

@RestController
@RequestMapping("/api")
public class TransactionResource {


    private final TransactionService transactionService;

    public TransactionResource(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/transactions")
    public ResponseEntity getMsg() {
        return ResponseEntity.ok(transactionService.getAll());
    }
    @PostMapping("/transactions")
    public ResponseEntity create(@RequestBody Transaction transaction){
        return ResponseEntity.ok(transactionService.saveExch(transaction));
    }
    @PutMapping("/transactions")
    public ResponseEntity update(@RequestBody Transaction transaction){
        return ResponseEntity.ok(transactionService.update(transaction));
    }

}
