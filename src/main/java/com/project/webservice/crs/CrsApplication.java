package com.project.webservice.crs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrsApplication.class, args);
	}

}
//Hibernate: select customerre0_.idEntity as identity1_0_0_, customerre0_.ct_acct as ct_acct2_0_0_, customerre0_.id_email as id_email3_0_0_, customerre0_.id_internal as id_inter4_0_0_, customerre0_.password1 as password5_0_0_ from tbid customerre0_ where customerre0_.idEntity=?
