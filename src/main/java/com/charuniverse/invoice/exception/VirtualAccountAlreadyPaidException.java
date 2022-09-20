package com.charuniverse.invoice.exception;

public class VirtualAccountAlreadyPaidException extends Exception {

    public VirtualAccountAlreadyPaidException() {
    }

    public VirtualAccountAlreadyPaidException(String message) {
        super(message);
    }

    public VirtualAccountAlreadyPaidException(String companyId, String accountNumber, String providerCode) {
        super("VA [" + companyId + "/" + accountNumber + "-" + providerCode + "] already paid");
    }
}
