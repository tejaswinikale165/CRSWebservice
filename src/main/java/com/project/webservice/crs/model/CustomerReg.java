package com.project.webservice.crs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbid")
public class CustomerReg {
    @Id
    @Column(name ="id_entity")
    String idEntity;

    @Column(name = "id_email")
    String idEmail;

    @Column(name = "password1")
    String password;

    @Column(name = "id_internal")
    String idInternal;

    @Column(name = "ct_acct")
    String ctAcct;


    @Override
    public String toString() {
        return "CustomerReg{" +
                "idEntity='" + idEntity + '\'' +
                ", idEmail='" + idEmail + '\'' +
                ", password='" + password + '\'' +
                ", idInternal='" + idInternal + '\'' +
                ", ctAcct='" + ctAcct + '\'' +
                '}';
    }

    public String getIdEntity() {
        return idEntity;
    }

    public void setIdEntity(String idEntity) {
        this.idEntity = idEntity;
    }

    public String getIdEmail() {
        return idEmail;
    }

    public void setIdEmail(String idEmail) {
        this.idEmail = idEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdInternal() {
        return idInternal;
    }

    public void setIdInternal(String idInternal) {
        this.idInternal = idInternal;
    }

    public String getCtAcct() {
        return ctAcct;
    }

    public void setCtAcct(String ctAcct) {
        this.ctAcct = ctAcct;
    }
}
