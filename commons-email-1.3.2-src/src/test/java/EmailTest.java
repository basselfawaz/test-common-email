package org.apache.commons.mail;

import static org.junit.Assert.assertEquals;

import java.sql.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EmailTest {

	private static final String[] TEST_EMAILS = {"cb@dc.com", "a.b@c.org", "abcdefghijklmnopqrst@abcdefghijklmnopqrst.com.bd"};
	private String[] Test_Names = {"basel", "lulu", "hello"};
	private String[] validChars = {" ", "a", "A", "\uc5ec", "0123456789", "01234567890123456789","\n" };
	
	private EmailConcrete email;
	
	@Before
	public void setUpEmailTest() throws Exception {
		
		email = new EmailConcrete();
	}
	
	@After
	public void tearDownEmailTest() throws Exception {
		
	}

	@Test
	public void addBCCTest() throws Exception {
		email.addBcc(TEST_EMAILS[1], "Basel");
		assertEquals(1, email.getBccAddresses().size());
	}
	@Test
	public void testAddCc() throws Exception {
		email.addCc(TEST_EMAILS[0]);
		assertEquals(1, email.getCcAddresses().size());
	}

	@Test
	public void addHeaderTest() throws Exception {
		
		email.addHeader(Test_Names[0] , validChars[3]);
		
		assertEquals(1, email.getHeaders().size());
	}

	@Test
	public void testAddReplyTo() throws Exception {
		
		email.addReplyTo(TEST_EMAILS[1], Test_Names[2]);
		
		assertEquals(1, email.getReplyToAddresses().size());
	}