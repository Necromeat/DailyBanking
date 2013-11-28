/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import DTO.AccountDTO;
import DTO.CustomerDTO;
import DTO.UserDTO;
import contract.BankDataInterface;
import entities.AccountDetail;
import entities.AccountDetailPK;
import entities.CustomerDetail;
import java.util.ArrayList;
import java.util.Collection;
import javax.ejb.embeddable.EJBContainer;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Andrew
 */
public class BusinessDataBeanTest {
      
         BusinessDataBean db;
      private Collection<CustomerDTO> customerList;
      private Collection<AccountDTO> accountDTOList;
        
    public BusinessDataBeanTest() {
    }
    
    @BeforeClass
    public void setUpClass() {
       
        
    }
    
    @AfterClass
    public  void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        customerList = new ArrayList();
        customerList = db.getCustomers();
        accountDTOList = new ArrayList();
        accountDTOList = db.getAccounts();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addCustomer method, of class BusinessDataBean.
     */
    @Test
    public void testAddCustomer() throws Exception {
        System.out.println("addCustomer");
        CustomerDTO customer = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        BankDataInterface instance = (BankDataInterface)container.getContext().lookup("java:global/classes/BusinessDataBean");
        instance.addCustomer(customer);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkUserEmail method, of class BusinessDataBean.
     */
    @Test
    public void testCheckUserEmail() throws Exception {
        System.out.println("checkUserEmail");
        String email = "";
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        BankDataInterface instance = (BankDataInterface)container.getContext().lookup("java:global/classes/BusinessDataBean");
        String expResult = "";
        String result = instance.checkUserEmail(email);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCustomerByEmail method, of class BusinessDataBean.
     */
    @Test
    public void testGetCustomerByEmail() throws Exception {
        System.out.println("getCustomerByEmail");
        String email = "";
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        BankDataInterface instance = (BankDataInterface)container.getContext().lookup("java:global/classes/BusinessDataBean");
        CustomerDTO expResult = null;
        CustomerDTO result = instance.getCustomerByEmail(email);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        
    }

    /**
     * Test of getAccount method, of class BusinessDataBean.
     */
    @Test
    public void testGetAccount() throws Exception {
        System.out.println("getAccount");
        long id = 0L;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        BankDataInterface instance = (BankDataInterface)container.getContext().lookup("java:global/classes/BusinessDataBean");
        AccountDTO expResult = null;
        AccountDTO result = instance.getAccount(id);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAccounts method, of class BusinessDataBean.
     */
    @Test
    public void testGetAccounts() throws Exception {
        System.out.println("getAccounts");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        BankDataInterface instance = (BankDataInterface)container.getContext().lookup("java:global/classes/BusinessDataBean");
        Collection<AccountDTO> expResult = null;
        Collection<AccountDTO> result = instance.getAccounts();
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCustomers method, of class BusinessDataBean.
     */
    @Test
    public void testGetCustomers() throws Exception {
        System.out.println("getCustomers");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        BankDataInterface instance = (BankDataInterface)container.getContext().lookup("java:global/classes/BusinessDataBean");
        Collection<CustomerDTO> expResult = null;
        Collection<CustomerDTO> result = instance.getCustomers();
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addAccount method, of class BusinessDataBean.
     */
    @Test
    public void testAddAccount() throws Exception {
        System.out.println("addAccount");
        Long custID = null;
        AccountDTO account = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        BankDataInterface instance = (BankDataInterface)container.getContext().lookup("java:global/classes/BusinessDataBean");
        instance.addAccount(custID, account);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of newTransfer method, of class BusinessDataBean.
     */
    @Test
    public void testNewTransfer() throws Exception {
        System.out.println("newTransfer");
        long custID = 0L;
        long fromID = 0L;
        long toID = 0L;
        double amount = 0.0;
        String message = "";
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        BankDataInterface instance = (BankDataInterface)container.getContext().lookup("java:global/classes/BusinessDataBean");
        instance.newTransfer(custID, fromID, toID, amount, message);
        
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveEditedCustomer method, of class BusinessDataBean.
     */
    @Test
    public void testSaveEditedCustomer() throws Exception {
        System.out.println("saveEditedCustomer");
        CustomerDTO cust = null;
        CustomerDTO temp = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        BankDataInterface instance = (BankDataInterface)container.getContext().lookup("java:global/classes/BusinessDataBean");
        instance.saveEditedCustomer(cust, temp);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUser method, of class BusinessDataBean.
     */
    @Test
    public void testGetUser() throws Exception {
        System.out.println("getUser");
        String email = "";
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        BankDataInterface instance = (BankDataInterface)container.getContext().lookup("java:global/classes/BusinessDataBean");
        UserDTO expResult = null;
        UserDTO result = instance.getUser(email);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addUser method, of class BusinessDataBean.
     */
    @Test
    public void testAddUser() throws Exception {
        System.out.println("addUser");
        String pw = "";
        String Email = "";
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        BankDataInterface instance = (BankDataInterface)container.getContext().lookup("java:global/classes/BusinessDataBean");
        instance.addUser(pw, Email);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCustomerByPrincipal method, of class BusinessDataBean.
     */
    @Test
    public void testGetCustomerByPrincipal() throws Exception {
        System.out.println("getCustomerByPrincipal");
        BusinessDataBean instance = new BusinessDataBean();
        CustomerDTO expResult = null;
        CustomerDTO result = instance.getCustomerByPrincipal();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
