package com.Service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.entities.Admin;
import com.entities.Books;
import com.entities.BooksOrder;
import com.entities.DamagedBooks;
import com.entities.Users;
import com.repository.AdminRepository;
import com.repository.BooksOrderRepository;
import com.repository.BooksRepository;
import com.repository.DamagedBooksRepository;
import com.repository.UsersRepository;
@SpringBootTest
class AdminServiceImpTest {
@Autowired
AdminService adminservice;
@MockBean
AdminRepository adminrepo;
	@Test
	void testAddAdminDetails() {
		Admin ad=new Admin();
		ad.setAdminId(1);
		ad.setAdminName("Jahnavi");
		ad.setAdminPassword("jahnavi@1499");
		Mockito.when(adminrepo.save(ad)).thenReturn(ad);
		assertThat(adminservice.addAdminDetails(ad)).isEqualTo(ad);
	}	
}
