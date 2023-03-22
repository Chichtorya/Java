/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package dal;

import model.User;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author PC
 */
public class UserDAOTest {
    
    public UserDAOTest() {
    }

    @Test
    public void testGetRoleById() {
    }

    @Test
    public void testGetMajorById() {
    }

    @Test
    public void testGetMoneyByMonth() {
    }

    @Test
    public void testGetTotalMoneyByMonth() {
    }

    @Test
    public void testGetTotalByMonth() {
    }

    @Test
    public void testGetTotalByMonthByMajor() {
    }

    @Test
    public void testMain() {
    }

    @Test
    public void testMD5() {
    }

    @Test
    public void testGetUserById() {
    }

    @Test
    public void testGetAllRole() {
    }

    @Test
    public void testGetAllMajor() {
    }

    @Test
    public void testGetAllUser() {
    }

    @Test
    public void testGetAllUserBlock() {
    }

    @Test
    public void testGetTop3User() {
    }

    @Test
    public void testGetNumberByRole() {
    }

    @Test
    public void testGetAllUserByRole() {
    }

    @Test
    public void testUpdatePhoto() {
    }

    @Test
    public void testCheckPhone() {
    }

    @Test
    public void testCheckGmail() {
        UserDAO dao = new UserDAO();
        boolean a = dao.checkGmail("a@gmail.com");
        assertEquals(true,a);
    }

    @Test
    public void testCheckHealthId() {
    }

    @Test
    public void testCheckCitizenId() {
    }

    @Test
    public void testCreateUserByAdmin() {
    }

    @Test
    public void testCreateUserByAdmin1() {
    }

    @Test
    public void testBlockUser() {
    }

    @Test
    public void testChangePass() {
    }

    @Test
    public void testGetListByPage() {
    }

    @Test
    public void testGetAllUserByName() {
    }

    @Test
    public void testGetAllUserByNameAndRole() {
    }

    @Test
    public void testEditUserByCustomer() {
    }

    @Test
    public void testEditUserByAdmin() {
    }

    @Test
    public void testEditUserByAdmin1() {
    }

    @Test
    public void testResetPass() {
    }

    @Test
    public void testCheckUser() {
        UserDAO dao = new UserDAO();
        User u = dao.checkUser("a@gmail.com", "dat123");
        String name = "Doctor Strange";
        assertEquals(name, u.getName());
    }   
}
