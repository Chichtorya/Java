/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.BiochemistryTests;
import model.BloodTests;
import model.ImmunoassTest;

/**
 *
 * @author chich
 */
public class TestDao extends DbContext {

    public static void main(String[] args) {
        TestDao tdao = new TestDao();
        BiochemistryTests t = tdao.getBioTestByExamId(6);
        System.out.println(t);
    }

    public BloodTests getBloodTestByIdSchedule(int idSchedule) {
        UserDAO dao = new UserDAO();
        ExamDAO edao = new ExamDAO();
        String sql = "select b.* from Blood_Test b\n"
                + "inner join Examination e on b.id_exam = e.id \n"
                + "inner join Schedule s on e.id = s.id_exam where s.id = ?;";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, idSchedule);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return new BloodTests(rs.getInt("Id"),
                        dao.getUserById(rs.getInt("id_user")),
                        edao.getExamById(rs.getInt("id_exam")),
                        rs.getFloat("Red_Blood_Cell"),
                        rs.getFloat("White_Blood_Cell"),
                        rs.getFloat("Platelets"),
                        rs.getFloat("Hemoglobin"),
                        rs.getFloat("Hematocrit"),
                        rs.getInt("Mean_Corpuscular_Volume")
                );

            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
    public BloodTests getBloodTestByExamId(int id_exam) {
        UserDAO dao = new UserDAO();
        ExamDAO edao = new ExamDAO();
        String sql = "select * from Blood_Test where id_exam = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id_exam);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return new BloodTests(rs.getInt("Id"),
                        dao.getUserById(rs.getInt("id_user")),
                        edao.getExamById(rs.getInt("id_exam")),
                        rs.getFloat("Red_Blood_Cell"),
                        rs.getFloat("White_Blood_Cell"),
                        rs.getFloat("Platelets"),
                        rs.getFloat("Hemoglobin"),
                        rs.getFloat("Hematocrit"),
                        rs.getInt("Mean_Corpuscular_Volume")
                );

            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public BiochemistryTests getBioTestByIdSchedule(int idSchedule) {
        UserDAO dao = new UserDAO();
        ExamDAO edao = new ExamDAO();
        String sql = "select b.* from Biochemistry_Test b\n"
                + "inner join Examination e on b.id_exam = e.id \n"
                + "inner join Schedule s on e.id = s.id_exam where s.id = ?;";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, idSchedule);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return new BiochemistryTests(rs.getInt("Id"),
                        dao.getUserById(rs.getInt("id_user")),
                        edao.getExamById(rs.getInt("id_exam")),
                        rs.getFloat("Fasting"),
                        rs.getFloat("pp"),
                        rs.getFloat("Urea"),
                        rs.getFloat("S_Creatinine"),
                        rs.getFloat("Sodium"),
                        rs.getFloat("Potassium"),
                        rs.getFloat("Chloride"),
                        rs.getFloat("Total_Calcium"),
                        rs.getFloat("S_Calcium"),
                        rs.getFloat("Uric_Acid"),
                        rs.getFloat("Total_Bilirubin"),
                        rs.getFloat("Alkaline_Phosphate"),
                        rs.getFloat("Total_Protein"),
                        rs.getFloat("Albumin"),
                        rs.getFloat("Total_Cholesterol"),
                        rs.getFloat("Triglyceride"),
                        rs.getFloat("ADA"),
                        rs.getString("result")
                );

            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
    public BiochemistryTests getBioTestByExamId(int id_exam) {
        UserDAO dao = new UserDAO();
        ExamDAO edao = new ExamDAO();
        String sql = "select * from Biochemistry_Test where id_exam = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id_exam);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return new BiochemistryTests(rs.getInt("Id"),
                        dao.getUserById(rs.getInt("id_user")),
                        edao.getExamById(rs.getInt("id_exam")),
                        rs.getFloat("Fasting"),
                        rs.getFloat("pp"),
                        rs.getFloat("Urea"),
                        rs.getFloat("S_Creatinine"),
                        rs.getFloat("Sodium"),
                        rs.getFloat("Potassium"),
                        rs.getFloat("Chloride"),
                        rs.getFloat("Total_Calcium"),
                        rs.getFloat("S_Calcium"),
                        rs.getFloat("Uric_Acid"),
                        rs.getFloat("Total_Bilirubin"),
                        rs.getFloat("Alkaline_Phosphate"),
                        rs.getFloat("Total_Protein"),
                        rs.getFloat("Albumin"),
                        rs.getFloat("Total_Cholesterol"),
                        rs.getFloat("Triglyceride"),
                        rs.getFloat("ADA"),
                        rs.getString("result")
                );

            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public ImmunoassTest getImmuTestByIdSchedule(int idSchedule) {
        UserDAO dao = new UserDAO();
        ExamDAO edao = new ExamDAO();
        String sql = "select b.* from Immunoass_Test b\n"
                + "inner join Examination e on b.id_exam = e.id \n"
                + "inner join Schedule s on e.id = s.id_exam where s.id = ?;";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, idSchedule);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return new ImmunoassTest(rs.getInt("Id"),
                        dao.getUserById(rs.getInt("id_user")),
                        edao.getExamById(rs.getInt("id_exam")),
                        rs.getFloat("Digoxin"),
                        rs.getFloat("Estradiol"),
                        rs.getFloat("Ferritin"),
                        rs.getFloat("Folic_Acid"),
                        rs.getFloat("Progesterone"),
                        rs.getFloat("Prolactin"),
                        rs.getFloat("Troponin_T"),
                        rs.getFloat("Testosterone"),
                        rs.getFloat("Total_PSA"),
                        rs.getString("result"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
    public ImmunoassTest getImmuTestByExamId(int id_exam) {
        UserDAO dao = new UserDAO();
        ExamDAO edao = new ExamDAO();
        String sql = "select * from Immunoass_Test where id_exam = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id_exam);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return new ImmunoassTest(rs.getInt("Id"),
                        dao.getUserById(rs.getInt("id_user")),
                        edao.getExamById(rs.getInt("id_exam")),
                        rs.getFloat("Digoxin"),
                        rs.getFloat("Estradiol"),
                        rs.getFloat("Ferritin"),
                        rs.getFloat("Folic_Acid"),
                        rs.getFloat("Progesterone"),
                        rs.getFloat("Prolactin"),
                        rs.getFloat("Troponin_T"),
                        rs.getFloat("Testosterone"),
                        rs.getFloat("Total_PSA"),
                        rs.getString("result"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    // add Blood_Tests table - Tested - - not catching exception 
    public void createBloodTest(BloodTests b) {
        String sql = "INSERT INTO Blood_Test values(0,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, b.getId_doctor().getId());
            ps.setInt(2, b.getId_exam().getId());
            ps.setFloat(3, b.getRed_Blood_Cell());
            ps.setFloat(4, b.getWhite_Blood_Cell());
            ps.setFloat(5, b.getPlatelets());
            ps.setFloat(6, b.getHemoglobin());
            ps.setFloat(7, b.getHemattocrit());
            ps.setFloat(8, b.getMean_Corpuscular_Volume());
            ps.setString(9, b.getResult());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    // delete a row in Blood_Tests table - Tested - not catching exception 
    public int deleteBloodyTestdata(BloodTests bl) {
        String sql = "delete from blood_test where id_exam = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, bl.getId_exam().getId());
            return st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return 0;
    }

    // update a row in Blood_Tests table - tested-- not catching exception 
    public void UpdateBloodyTestdata(BloodTests bloodTests) {
        String sql = "UPDATE blood_test SET Red_Blood_Cell = ?, White_Blood_Cell = ?,Platelets= ?,Hemoglobin= ?,Hematocrit= ?,Mean_Corpuscular_Volume= ?,result = ? WHERE id_exam = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(8, bloodTests.getId_exam().getId());
            st.setString(7, bloodTests.getResult());
            st.setFloat(1, bloodTests.getRed_Blood_Cell());
            st.setFloat(2, bloodTests.getWhite_Blood_Cell());
            st.setFloat(3, bloodTests.getPlatelets());
            st.setFloat(4, bloodTests.getHemoglobin());
            st.setFloat(5, bloodTests.getHemattocrit());
            st.setInt(6, bloodTests.getMean_Corpuscular_Volume());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }

    }
    // add Biochemistry table -  - - not catching exception 

    public int createBioTest(BiochemistryTests biTest) {
        String sql = "INSERT INTO `g62`.`Biochemistry_Test` (`id_user`, `id_exam`, `Fasting`, `PP`, `Urea`, `S_Creatinine`, \n"
                + "`Sodium`, `Potassium`, `Chloride`, `Total_Calcium`, `S_Calcium`, `Uric_Acid`, `Total_Bilirubin`, \n"
                + "`Alkaline_Phosphate`, `Total_Protein`, `Albumin`, `Total_Cholesterol`,"
                + " `Triglyceride`, `ADA`, `result`) "
                + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
        try {
            PreparedStatement st = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

            st.setInt(1, biTest.getId_doctor().getId());
            st.setInt(2, biTest.getId_exam().getId());
            st.setFloat(3, biTest.getFasting());
            st.setFloat(4, biTest.getPp());
            st.setFloat(5, biTest.getUrea());
            st.setFloat(6, biTest.getS_Creatinine());
            st.setFloat(7, biTest.getSodium());
            st.setFloat(8, biTest.getPotassium());
            st.setFloat(9, biTest.getChloride());
            st.setFloat(10, biTest.getTotalCalcium());
            st.setFloat(11, biTest.getS_Calcium());

            st.setFloat(12, biTest.getUricAcid());
            st.setFloat(13, biTest.getTotalBilirubin());
            st.setFloat(14, biTest.getAlkalinePhosphate());
            st.setFloat(15, biTest.getTotalProtein());
            st.setFloat(16, biTest.getAlbumin());
            st.setFloat(17, biTest.getTotalCholesterol());
            st.setFloat(18, biTest.getTriglyceride());
            st.setFloat(19, biTest.getADA());
            st.setString(20, biTest.getResutl());
            st.executeUpdate();
             ResultSet rs = st.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return 0;
    }

    // delete a row in Biochemistry table -  - not catching exception 
    public int deleteBiochemistryTestdata(BiochemistryTests biTest) {
        String sql = "delete from Biochemistry_Test where id_exam = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, biTest.getId_exam().getId());
            return st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return 0;
    }

    // update a row in Biochemistry table - -- not catching exception 
    public void UpdateBiochemistryTestdata(BiochemistryTests biTest) {
        String sql = "UPDATE Biochemistry SET Fasting= ?, pp= ?,Urea= ?,"
                + "S_Creatinine= ?,Sodium= ?,Potassium= ?,Choloride=?,"
                + "Total_Calcium=?,S_Calcium= ?,Uric_Acid =?,Total_Bilirubin = ?,"
                + "Alkaline_Phosphate = ?,Total_Protein = ?,Albumin = ?,"
                + "Total_Cholesterol =?,Triglyceride =?,ADA = ? ,result =?"
                + "WHERE id_exam = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);

            st.setFloat(1, biTest.getFasting());
            st.setFloat(2, biTest.getPp());
            st.setFloat(3, biTest.getUrea());
            st.setFloat(4, biTest.getS_Creatinine());
            st.setFloat(5, biTest.getSodium());
            st.setFloat(6, biTest.getPotassium());
            st.setFloat(7, biTest.getChloride());
            st.setFloat(8, biTest.getTotalCalcium());
            st.setFloat(9, biTest.getS_Calcium());
            st.setFloat(10, biTest.getUricAcid());
            st.setFloat(11, biTest.getTotalBilirubin());
            st.setFloat(12, biTest.getAlkalinePhosphate());

            st.setFloat(13, biTest.getTotalProtein());
            st.setFloat(14, biTest.getAlbumin());
            st.setFloat(15, biTest.getTotalCholesterol());
            st.setFloat(16, biTest.getTriglyceride());
            st.setInt(19, biTest.getId_exam().getId());
            st.setString(18, biTest.getResutl());
            st.setFloat(17, biTest.getADA());
            st.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }

    }
//
//    public List<ImmunoassTest> getImmunoassTestses(int idTest) {
//        List<ImmunoassTest> list = new ArrayList<>();
//        String sql = "select * from Immunoass_Test where Medical_Test_Id = ? ; ";
//        try {
//            PreparedStatement st = connection.prepareStatement(sql);
//            st.setInt(1, idTest);
//            ResultSet rs = st.executeQuery();
//            while (rs.next()) {
//                ImmunoassTest Imt = new ImmunoassTest();
//                Imt.setImID(rs.getInt("Id"));
//                Imt.setid_user(rs.getInt("Medical_Test_Id"));
//                Imt.setDigoxin(rs.getInt("Digoxin"));
//                Imt.setEstradiol(rs.getInt("Estradiol"));
//                Imt.setFerritin(rs.getInt("Ferritin"));
//                Imt.setFolicAcid(rs.getInt("Folic_Acid"));
//                Imt.setProgesterone(rs.getInt("Progesterone"));
//                Imt.setProlactin(rs.getInt("Prolactin"));
//                Imt.setTroponinT(rs.getInt("Troponin_T"));
//                Imt.setTestosterone(rs.getInt("Testosterone"));
//                Imt.setTotalPSA(rs.getInt("Total_PSA"));
//
//                list.add(Imt);
//            }
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
//        return list;
//
//    }

    // add Immunoass table -  - - not catching exception 
    public void addImmunoassTestdata(ImmunoassTest ImTest) {
        String sql = "INSERT INTO `g62`.`Immunoass_Test` (`id_exam`, `id_user`, `Digoxin`, `Estradiol`, `Ferritin`,\n"
                + " `Folic_Acid`, `Progesterone`, `Prolactin`, `Troponin_T`, `Testosterone`, `Total_PSA`, `result`)"
                + " values(?,?,?,?,?,?,?,?,?,?,?,?);";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(2, ImTest.getId_doctor().getId());
            st.setInt(1, ImTest.getId_exam().getId());
            st.setFloat(3, ImTest.getDigoxin());
            st.setFloat(4, ImTest.getEstradiol());
            st.setFloat(5, ImTest.getFerritin());
            st.setFloat(6, ImTest.getFolicAcid());
            st.setFloat(7, ImTest.getProgesterone());
            st.setFloat(8, ImTest.getProlactin());
            st.setFloat(9, ImTest.getTroponinT());
            st.setFloat(10, ImTest.getTestosterone());
            st.setFloat(11, ImTest.getTotalPSA());
            st.setString(12, ImTest.getResult());
            st.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    // delete a row in Immunoass table -  - not catching exception 
    public int deleteImmunoassTestdata(ImmunoassTest ImTest) {
        String sql = "delete from Immunoass_Test where id_exam =? ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, ImTest.getId_exam().getId());
            return st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return 0;
    }

    // update a row in Immunoass table - -- not catching exception 
    public void UpdateImmunoassTestdata(ImmunoassTest ImTest) {
        String sql = "UPDATE Immunoass_Test SET Digoxin= ?, Estradiol= ?,"
                + "Ferritin= ?,Folic_Acid= ?,Progesterone= ?,Prolactin= ?,"
                + "Troponin_T=?,Testosterone=?,Total_PSA =?,result = ?"
                + " WHERE id_exam = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(11, ImTest.getId_exam().getId());
            st.setString(10, ImTest.getResult());
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

}
