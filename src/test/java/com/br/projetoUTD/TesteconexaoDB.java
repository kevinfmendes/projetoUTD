package com.br.projetoUTD;

import java.util.Objects;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TesteconexaoDB {

	  @Autowired
	    private DataSource dataSource;

	  @Test
	    public void testConnection() {
	        Objects.requireNonNull(dataSource);
	        try {
	            dataSource.getConnection().close();
	            System.out.println("Conexão bem-sucedida!");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
}
