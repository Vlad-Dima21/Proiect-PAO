package com.proiect.services;

import com.proiect.services.io.AuditingIO;

public class AuditingService {
    private AuditingIO auditingIo = new AuditingIO();

    public void registerLog(String nameOfAction) {
        auditingIo.logAction(nameOfAction);
    }
}
