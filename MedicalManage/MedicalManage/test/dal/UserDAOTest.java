/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package dal;

import model.Role;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author dell
 */
public class UserDAOTest {
    UserDAO dao = new UserDAO();
    public UserDAOTest() {
    }

    @Test
    public void testGetRoleById() {
         Role j = dao.getRoleById(1);
        String name = "Admin";
        assertEquals(name,j.getName());
    }

    
    @Test
    public void testGetMajorById() {
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
    public void testBlockUser() {
        
    }

    @Test
    public void testChangePass() {
    }

    @Test
    public void testGetListByPage() {
    }

    @Test
    public void testChangeRole() {
    }

    @Test
    public void testChangeRole1() {
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
    public void testResetPass() {
    }

    @Test
    public void testCheckUser() {
    }

    @Test
    public void testMain() {
    }
    
}
