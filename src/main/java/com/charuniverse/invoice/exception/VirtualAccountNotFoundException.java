package com.charuniverse.invoice.exception;

public class VirtualAccountNotFoundException extends Exception {

    public VirtualAccountNotFoundException() {
    }

    public VirtualAccountNotFoundException(String message) {
        super(message);
    }

    public VirtualAccountNotFoundException(String companyId, String accountNumber, String providerCode) {
        super("VA [" + companyId + "/" + accountNumber + "-" + providerCode + "] not found");
    }
}
