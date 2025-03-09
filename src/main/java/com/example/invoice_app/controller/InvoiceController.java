package com.example.invoice_app.controller;

import com.example.invoice_app.model.Invoice;
import com.example.invoice_app.service.PdfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/invoice")
public class InvoiceController {

    @Autowired
    private PdfService pdfService;

    @PostMapping("/generate")
    public ResponseEntity<byte[]> generateInvoice(@RequestBody Invoice invoice) throws IOException {
        byte[] pdfBytes = pdfService.generatePdf(invoice);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"invoice.pdf\"")
                .body(pdfBytes);
    }
}