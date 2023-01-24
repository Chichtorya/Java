/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.TestObj.BloodTests;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.sql.Statement;

/**
 *
 * @author chich
 */
public class TestDao extends DbContext {
// get name of colums in a table

    public void getNameBlTest(String table) {
        String sql = "SELECT * FROM ?";
        try {

            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, table);
            ResultSet rs = st.executeQuery();
            ResultSetMetaData metaData = rs.getMetaData();
            int count = metaData.getColumnCount(); //number of column
            String columnName[] = new String[count-1];

            for (int i = 1; i <= count; i++) {
                columnName[i-1] = metaData.getColumnLabel(i);
                System.out.println(columnName[i - 1]);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    // get number row in table blood test
    public int getMaxID(String table) {
        int max;
        String sql = " SELECT COUNT(*) FROM  ? ;" ;
        try {
            PreparedStatement st = connection.prepareStatement(sql);
               st.setString(1, table);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                max = rs.getInt(1);
                return max;
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return 99;
    }

    // add Blood_Tests table - Tested - - not catching exception 
    public void addBloodyTestdata(BloodTests bloodTests) {
        String sql = "INSERT INTO Blood_Test values(?,?,?,?,?,?,?,?) ;;";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, bloodTests.getBlID());
            st.setInt(2, bloodTests.getMedical_Test_Id());
            st.setDouble(3, bloodTests.getRed_Blood_Cell());
            st.setDouble(4, bloodTests.getWhite_Blood_Cell());
            st.setDouble(5, bloodTests.getPlatelets());
            st.setFloat(6, bloodTests.getHemoglobin());
            st.setFloat(7, bloodTests.getHemattocrit());
            st.setInt(8, bloodTests.getMean_Corpuscular_Volume());

            st.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    // delete a row in Blood_Tests table - Tested - not catching exception 
    public int deleteBloodyTestdata(BloodTests bl) {
        String sql = "delete from blood_test where Medical_Test_Id= ? and Id = ? ;";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, bl.getMedical_Test_Id());
            st.setInt(2, bl.getBlID());
            return st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return 0;
    }

    // update a row in Blood_Tests table - tested-- not catching exception 
    public void UpdateBloodyTestdata(BloodTests bloodTests) {
        String sql = "UPDATE blood_test SET Red_Blood_Cell = ?, White_Blood_Cell = ?,Platelets= ?,Hemoglobin= ?,Hematocrit= ?,Mean_Corpuscular_Volume= ? WHERE Medical_Test_Id = ? and Id = ?;";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(8, bloodTests.getMedical_Test_Id());
            st.setInt(7, bloodTests.getBlID());
            st.setDouble(1, bloodTests.getRed_Blood_Cell());
            st.setDouble(2, bloodTests.getWhite_Blood_Cell());
            st.setDouble(3, bloodTests.getPlatelets());
            st.setFloat(4, bloodTests.getHemoglobin());
            st.setFloat(5, bloodTests.getHemattocrit());
            st.setInt(6, bloodTests.getMean_Corpuscular_Volume());

            st.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    public static void main(String[] args) {
        List<String> b = new ArrayList<>();
        TestDao t = new TestDao();
        BloodTests bl = new BloodTests();
        bl.setHemoglobin((float)5);
        bl.setPlatelets(5);
        bl.setRed_Blood_Cell(5);
                bl.setMean_Corpuscular_Volume(5);
bl.setBlID(5);
bl.setMedical_Test_Id(5);
        t.addBloodyTestdata(bl);

    }
}
