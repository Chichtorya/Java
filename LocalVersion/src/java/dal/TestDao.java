/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import model.PatientTest;
import model.BloodTests;
import model.BiochemistryTests;
import model.ImmunoassTest;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.sql.Statement;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 *
 * @author chich
 */
public class TestDao extends DbContext {
// get name of colums in a table

    public  Map<String, String>  getTest(String table,int id)  {
      int theId=  getlatestId(id, table);
       
 Map<String, String> dict = new HashMap();
         try {
                   PreparedStatement stmt = connection.prepareStatement("SELECT * FROM " + table + " where id = ?  ");
            stmt.setInt(1, theId);
        ResultSet rs = stmt.executeQuery();
        ResultSetMetaData meta = rs.getMetaData();
        int columnCount = meta.getColumnCount();
        
    
        while (rs.next()) {
            for (int i = 1; i <= columnCount; i++) {
                dict.put(meta.getColumnName(i) , rs.getString(i));
           
            }

        }
         } catch (SQLException e) {
        }
return dict;
    }

    

    // get number row in table blood test
    public int getMaxID(String table) {
        int max;

        String sql = " SELECT COUNT(*) FROM  " + table;
        try {
            PreparedStatement st = connection.prepareStatement(sql);

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

    public List<BloodTests> getBloodTestses(int idTest) {
        List<BloodTests> list = new ArrayList<>();
        String sql = "select * from Blood_Test where Medical_Test_Id = ? ; ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, idTest);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                BloodTests BlT = new BloodTests();
                BlT.setBlID(rs.getInt("Id"));
                //    BlT.setMedical_Test_Id(rs.getInt("Medical_Test_Id"));
                BlT.setRed_Blood_Cell(rs.getInt("Red_Blood_Cell"));
                BlT.setWhite_Blood_Cell(rs.getInt("White_Blood_Cell"));
                BlT.setPlatelets(rs.getInt("Platelets"));
                BlT.setHemoglobin(rs.getInt("Hemoglobin"));
                BlT.setHemattocrit(rs.getInt("Hematocrit"));
                BlT.setMean_Corpuscular_Volume(rs.getInt("Mean_Corpuscular_Volume"));

                list.add(BlT);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;

    }

    // add Blood_Tests table - Tested - - not catching exception 
    public void addBloodyTestdata(BloodTests bloodTests) {
        
        String sql = "INSERT INTO Blood_Test values(0,?,?,?,?,?,?,?) ;;";
        try {
            PreparedStatement st = connection.prepareStatement(sql);

           st.setInt(1, bloodTests.getid_user());
            st.setDouble(2, bloodTests.getRed_Blood_Cell());
            st.setDouble(3, bloodTests.getWhite_Blood_Cell());
            st.setDouble(4, bloodTests.getPlatelets());
            st.setFloat(5, bloodTests.getHemoglobin());
            st.setFloat(6, bloodTests.getHemattocrit());
            st.setInt(7, bloodTests.getMean_Corpuscular_Volume());

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
//            st.setInt(1, bl.getMedical_Test_Id());
            st.setInt(2, bl.getBlID());
            return st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return 0;
    }

    // update a row in Blood_Tests table - tested-- not catching exception 
    public void UpdateBloodyTestdata(BloodTests bloodTests) {
        String sql = "UPDATE blood_test SET Red_Blood_Cell = ?, White_Blood_Cell = ?,Platelets= ?,Hemoglobin= ?,Hematocrit= ?,Mean_Corpuscular_Volume= ? WHERE id_user = ? and Id = ?;";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(8, bloodTests.getid_user());
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

    public List<BiochemistryTests> getBiochemistryTestses(int idTest) {
        List<BiochemistryTests> list = new ArrayList<>();
        String sql = "select * from Biochemistry where Medical_Test_Id = ? ; ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, idTest);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                BiochemistryTests BiT = new BiochemistryTests();
                BiT.setBioID(rs.getInt("Id"));
//                BiT.setMedicalTestId(rs.getInt("Medical_Test_Id"));
                BiT.setFasting(rs.getInt("Fasting"));
                BiT.setPp(rs.getInt("PP"));
                BiT.setUrea(rs.getInt("Urea"));
                BiT.setS_Creatinine(rs.getInt("S_Creatinine"));
                BiT.setSodium(rs.getInt("Sodium"));
                BiT.setPotassium(rs.getInt("Potassium"));
                BiT.setChloride(rs.getInt("Chloride"));
                BiT.setTotalCalcium(rs.getInt("Total_Calcium"));
                BiT.setUricAcid(rs.getInt("UricAcid"));
                BiT.setTotalBilirubin(rs.getInt("Total_Bilirubin"));
                BiT.setAlkalinePhosphate(rs.getInt("Alkaline_Phosphate"));

                BiT.setTotalProtein(rs.getInt("Total_Protein"));
                BiT.setAlbumin(rs.getInt("Albumin"));
                BiT.setTotalCholesterol(rs.getInt("Total_Cholesterol"));
                BiT.setTriglyceride(rs.getInt("Triglyceride"));

                BiT.setADA(rs.getInt("ADA"));

                list.add(BiT);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;

    }
    // add Biochemistry table -  - - not catching exception 

    public void addBiochemistryTestdata(BiochemistryTests biTest) {
        String sql = "INSERT INTO Biochemistry_Test values(0,?  ,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ;;";
        try {
            PreparedStatement st = connection.prepareStatement(sql);

           st.setInt(1, biTest.getid_user());
            st.setFloat(2, biTest.getFasting());
            st.setFloat(3, biTest.getPp());
            st.setFloat(4, biTest.getUrea());
            st.setFloat(5, biTest.getS_Creatinine());
            st.setFloat(6, biTest.getSodium());
            st.setFloat(7, biTest.getPotassium());
            st.setFloat(8, biTest.getChloride());
            st.setFloat(9, biTest.getTotalCalcium());
            st.setFloat(10, biTest.getS_Calcium());
            
            st.setFloat(11, biTest.getUricAcid());
            st.setFloat(12, biTest.getTotalBilirubin());
            st.setFloat(13, biTest.getAlkalinePhosphate());
            st.setFloat(14, biTest.getTotalProtein());
            st.setFloat(15, biTest.getAlbumin());
            st.setFloat(16, biTest.getTotalCholesterol());
            st.setFloat(17, biTest.getTriglyceride());
            st.setFloat(18, biTest.getADA());

            st.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    // delete a row in Biochemistry table -  - not catching exception 
    public int deleteBiochemistryTestdata(BiochemistryTests biTest) {
        String sql = "delete from Biochemistry_Test where Medical_Test_Id= ? and Id = ? ;";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
//            st.setInt(1, biTest.getMedicalTestId());
            st.setInt(2, biTest.getBioID());
            return st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return 0;
    }

    // update a row in Biochemistry table - -- not catching exception 
    public void UpdateBiochemistryTestdata(BiochemistryTests biTest) {
        String sql = "UPDATE Biochemistry SET Fasting= ?, pp= ?,Urea= ?,S_Creatinine= ?,Sodium= ?,Potassium= ?,Choloride=?,Total_Calcium=?,UricAcid =?,Total_Bilirubin = ?,Alkaline_Phosphate = ?,Total_Protein = ?,Albumin = ?,Total_Cholesterol =?,Triglyceride =?,ADA = ? WHERE id_user = ? and Id = ? ;";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(18, getMaxID("Biochemistry_Test"));
            st.setInt(17, biTest.getid_user());
            st.setFloat(1, biTest.getFasting());
            st.setFloat(2, biTest.getPp());
            st.setFloat(3, biTest.getUrea());
            st.setFloat(4, biTest.getS_Creatinine());
            st.setFloat(5, biTest.getSodium());
            st.setFloat(6, biTest.getPotassium());
            st.setFloat(7, biTest.getChloride());
            st.setFloat(8, biTest.getTotalCalcium());
            st.setFloat(9, biTest.getUricAcid());
            st.setFloat(10, biTest.getTotalBilirubin());
            st.setFloat(11, biTest.getAlkalinePhosphate());

            st.setFloat(12, biTest.getTotalProtein());
            st.setFloat(13, biTest.getAlbumin());
            st.setFloat(14, biTest.getTotalCholesterol());
            st.setFloat(15, biTest.getTriglyceride());
            st.setFloat(16, biTest.getADA());

            st.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    public List<ImmunoassTest> getImmunoassTestses(int idTest) {
        List<ImmunoassTest> list = new ArrayList<>();
        String sql = "select * from Immunoass_Test where Medical_Test_Id = ? ; ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, idTest);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                ImmunoassTest Imt = new ImmunoassTest();
                Imt.setImID(rs.getInt("Id"));
                Imt.setid_user(rs.getInt("Medical_Test_Id"));
                Imt.setDigoxin(rs.getInt("Digoxin"));
                Imt.setEstradiol(rs.getInt("Estradiol"));
                Imt.setFerritin(rs.getInt("Ferritin"));
                Imt.setFolicAcid(rs.getInt("Folic_Acid"));
                Imt.setProgesterone(rs.getInt("Progesterone"));
                Imt.setProlactin(rs.getInt("Prolactin"));
                Imt.setTroponinT(rs.getInt("Troponin_T"));
                Imt.setTestosterone(rs.getInt("Testosterone"));
                Imt.setTotalPSA(rs.getInt("Total_PSA"));

                list.add(Imt);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;

    }

    // add Immunoass table -  - - not catching exception 
    public void addImmunoassTestdata(ImmunoassTest ImTest) {
        String sql = "INSERT INTO Immunoass_Test values(0,?,?,?,?,?,?,?,?,?,?) ;;";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            
            st.setInt(1, ImTest.getid_user());
            st.setFloat(2, ImTest.getDigoxin());
            st.setFloat(3, ImTest.getEstradiol());
            st.setFloat(4, ImTest.getFerritin());
            st.setFloat(5, ImTest.getFolicAcid());
            st.setFloat(6, ImTest.getProgesterone());
            st.setFloat(7, ImTest.getProlactin());
            st.setFloat(8, ImTest.getTroponinT());
            st.setFloat(9, ImTest.getTestosterone());
            st.setFloat(10, ImTest.getTotalPSA());

            st.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    // delete a row in Immunoass table -  - not catching exception 
    public int deleteImmunoassTestdata(ImmunoassTest ImTest) {
        String sql = "delete from Immunoass_Test where Medical_Test_Id= ? and Id = ? ;";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, ImTest.getid_user());
            st.setInt(2, ImTest.getImID());
            return st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return 0;
    }

    // update a row in Immunoass table - -- not catching exception 
    public void UpdateImmunoassTestdata(ImmunoassTest ImTest) {
        String sql = "UPDATE Immunoass_Test SET Digoxin= ?, Estradiol= ?,Ferritin= ?,Folic_Acid= ?,Progesterone= ?,Prolactin= ?,Troponin_T=?,Testosterone=?,Total_PSA =? WHERE id_user = ? and Id = ? ;";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(11, getMaxID("Immunoass_Test"));
            st.setInt(10, ImTest.getid_user());
            st.setFloat(1, ImTest.getDigoxin());
            st.setFloat(2, ImTest.getEstradiol());
            st.setFloat(3, ImTest.getFerritin());
            st.setFloat(4, ImTest.getFolicAcid());
            st.setFloat(5, ImTest.getProgesterone());
            st.setFloat(6, ImTest.getProlactin());
            st.setFloat(7, ImTest.getTroponinT());
            st.setFloat(8, ImTest.getTestosterone());
            st.setFloat(9, ImTest.getTotalPSA());

            st.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }

    }
    

    public void addTest(PatientTest PaTest) {
        String sql = "INSERT INTO test values(0,?,?,?,?,?,?,?,?) ;;";
        try {
            PreparedStatement st = connection.prepareStatement(sql);

            st.setInt(1, PaTest.getUser_Id());
            st.setInt(2, PaTest.getId_bio());
            st.setInt(3, PaTest.getId_blood());
            st.setInt(4, PaTest.getId_Immu());
            st.setInt(5, PaTest.getDoctor());
            st.setString(6, PaTest.getDescription());
            st.setString(7, PaTest.getResult());

            st.setDouble(8, PaTest.getPrice());

            st.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }

    }
// chua fix theo database moi

    public List<PatientTest> getPatientTestsByDoc(int doctor) {
        List<PatientTest> list = new ArrayList<>();
        String sql = "select * from Medical_Test where Doctor_In_Charge = ? ; ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, doctor);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                PatientTest PaT = new PatientTest();
                PaT.setPaID(rs.getInt("Id"));
                PaT.setUser_Id(rs.getInt("Medical_Test_Id"));
                PaT.setId_bio(rs.getInt("Id_bio"));
                PaT.setId_blood(rs.getInt("Id_blood"));
                PaT.setId_Immu(rs.getInt("Id_immu"));

                PaT.setDoctor(rs.getInt("Doctor_In_Charge"));
                PaT.setDescription(rs.getString("Description"));

                PaT.setPrice(rs.getDouble("Price"));

                list.add(PaT);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    // chua fix theo database moi

    public List<PatientTest> getPatientTestsById(int id) {
        List<PatientTest> list = new ArrayList<>();
        String sql = "select * from Medical_Test where Medical_Test_Id = ? ; ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                PatientTest PaT = new PatientTest();
              PaT.setPaID(rs.getInt("Id"));
                PaT.setUser_Id(rs.getInt("Medical_Test_Id"));
                PaT.setId_bio(rs.getInt("Id_bio"));
                PaT.setId_blood(rs.getInt("Id_blood"));
                PaT.setId_Immu(rs.getInt("Id_immu"));

                PaT.setDoctor(rs.getInt("Doctor_In_Charge"));
                PaT.setDescription(rs.getString("Description"));

                PaT.setPrice(rs.getDouble("Price"));

                list.add(PaT);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public void UpdateTest(PatientTest PaTest) {
        String sql = "UPDATE test SET Id_bio= ?, Id_bio= ?,Id_bio= ?,Doctor_In_Charge= ?,Description= ?,Result= ?,Price=? WHERE id_user = ? and Id = ? ;";
        try {
            PreparedStatement st = connection.prepareStatement(sql);

            st.setInt(8, PaTest.getUser_Id());
            st.setInt(1, PaTest.getId_bio());
            st.setInt(2, PaTest.getId_blood());
            st.setInt(3, PaTest.getId_Immu());
            st.setInt(4, PaTest.getDoctor());
            st.setString(5, PaTest.getDescription());
            st.setString(6, PaTest.getResult());

            st.setDouble(7, PaTest.getPrice());
            st.setInt(9, PaTest.getPaID());

            st.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }

    }
public int  getlatestId(int id_user,String table){
    int id = -1;
    String sql = "select id from "+table+" where id_user =? ORDER BY id DESC LIMIT 1;";
    
     try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id_user);
               ResultSet rs = st.executeQuery();
            while (rs.next()) {
                id = rs.getInt(1);
                return id;
            }
  } catch (SQLException e) {
            System.out.println(e);
        }
    
    return id;
}

    public static void main(String[] args)  {
        List<String> b = new ArrayList<>();
        TestDao t = new TestDao();
        BloodTests bl = new BloodTests();
//        bl.setBlID(1);
//        bl.setid_user(1);
//        bl.setHemoglobin((float) 9);
//        bl.setPlatelets(9);
//        bl.setRed_Blood_Cell(9);
//        bl.setMean_Corpuscular_Volume(9);
//
//t.UpdateBloodyTestdata(bl);
        //List<BloodTests>
        PatientTest pt = new PatientTest(0,1 ,0,0,0,"DuyAnh", "all right", 10);
                t.addTest(pt);
//System.out.println(t.getlatestId(1, "Blood_Test"));
//        Map<String, String> a = t.getTest("Blood_Test",1);
//    
//      for (Map.Entry<String, String> entry : a.entrySet()) {
//            String key = entry.getKey();
//            String value = entry.getValue();
//            System.out.println(key + " => " + value);
//        }
    }
}