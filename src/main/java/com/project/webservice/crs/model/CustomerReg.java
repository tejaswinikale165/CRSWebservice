package com.project.webservice.crs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbid")
public class CustomerReg {
    @Id
    String idEntity;

    @Column(name = "id_email")
    String idEmail;

    @Column(name = "password")
    String password;

    @Column(name = "id_internal")
    String idInternal;

    @Column(name = "ct_acct")
    String ctAcct;




}
