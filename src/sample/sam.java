package sample;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.controlsfx.control.textfield.AutoCompletionBinding;
import org.controlsfx.control.textfield.TextFields;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

import static sample.Controller.connection;

/**
 * Created by ashwith on 1/22/2019.
 */
public class sam implements Initializable {
    public TextField a;
    public TextField b;
    public TextField c;
    public TextField d;
    public TextField first;
    public TextField last;

    public TextField id;
    public TextField first1;
    public TextField last1;
    public TextField phone;
    public TextArea address;
    public TextField gender;
    public Pane pane;
    public TextField usn;
    public Pane addpane;
    public Pane scorepane;
    public TextField usn1;
    public TextField course1;
    public TextField grade1;
    public TextField perc;
    public TextField resu;
    public Pane scorepane3;


    public Pane activepane;
    public TextField usn3;
    public TextField sports3;
    public TextField cultu3;
    public TextField feast3;
    public DatePicker date3;
    public Pane activitypane4;
    public DatePicker dob;
    public ChoiceBox choice;
    public ChoiceBox subject;
    public TextField search;
    public AnchorPane sub;
    public Pane searchpane;
    public TextField addid;
    public TextField scoreid;
    public TextField actid;
    public TextField searchscore;
    public TextField actsearch;
    public Pane subscore;
    public TextField subid;
    public TextField subusn;
    public TextField sub1;
    public TextField sub2;
    public TextField sub3;
    public TextField sub4;
    public TextField sub6;
    public ChoiceBox subbranch;
    public TextField total;
    public TextField sub5;
    public TextField subperc;
    public Pane makspane;
    public TextField marksearch;
    public TextField sub11;
    public TextField grade2;
    public TextField resu2;
    public Pane dash;
    public TextField number;


    private int incidArray;

    public void submit(ActionEvent actionEvent) throws Exception {
        Connection connection = null;
        connection = DBConnect.getConnection();
        int k = 0;
        //refresh_reg();

        if (first.getText().isEmpty()) {
            Alert alert0 = new Alert((Alert.AlertType.ERROR));
            alert0.setContentText("Please Enter Firstname");
            alert0.showAndWait();
        } else if (last.getText().isEmpty()) {
            Alert alert = new Alert((Alert.AlertType.ERROR));
            alert.setContentText("Please Enter Lastname");
            alert.showAndWait();
        } else if (a.getText().isEmpty()) {
            Alert alert = new Alert((Alert.AlertType.ERROR));
            alert.setContentText("Please Enter Username");
            alert.showAndWait();
        } else if (b.getText().isEmpty()) {
            Alert alert3 = new Alert(Alert.AlertType.ERROR);
            alert3.setContentText("Enter Password");
            alert3.showAndWait();

        } else if (c.getText().isEmpty()) {
            Alert alert4 = new Alert(Alert.AlertType.ERROR);
            alert4.setContentText("Enter Address");
            alert4.showAndWait();

        } else if (d.getText().isEmpty()) {
            Alert alert5 = new Alert(Alert.AlertType.ERROR);
            alert5.setContentText("Enter PhoneNumber");
            alert5.showAndWait();

        } else {
            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
            alert1.setContentText("You Have Signed Up Succesfully");
            alert1.showAndWait();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("sample.fxml"));

            Stage stage = new Stage();
            stage.setTitle("New User Registartion");
            Parent root1 = (Parent) fxmlLoader.load();
            stage.setScene(new Scene(root1));
            stage.show();


            int i, j;
            String query2 = "Insert into register(firstname,lastname,Username,Password,Phone_number,Address)" + "values(?,?,?,?,?,?)";
            PreparedStatement s = connection.prepareStatement(query2);
            s.setString(1, first.getText().trim());
            s.setString(2, last.getText().trim());
            s.setString(3, a.getText().trim());
            s.setString(4, b.getText().trim());
            s.setString(5, c.getText().trim());
            s.setString(6, d.getText().trim());

            i = s.executeUpdate();
            String query3 = "Insert into login(Username,Password) values(?,?)";
            PreparedStatement p = connection.prepareStatement(query3);
            p.setString(1, a.getText().trim());
            p.setString(2, b.getText().trim());
            j = p.executeUpdate();
        }
    }

    public void add1(ActionEvent actionEvent) throws Exception {
        try {
            Connection connection = null;
            connection = DBConnect.getConnection();
            if (usn.getText().isEmpty()) {
                Alert alert0 = new Alert((Alert.AlertType.ERROR));
                alert0.setContentText("Please Enter a Valid University Seat Number");
                alert0.showAndWait();
            } else if (first1.getText().isEmpty()) {
                Alert alert = new Alert((Alert.AlertType.ERROR));
                alert.setContentText("Please Enter First Name");
                alert.showAndWait();
            } else if (last1.getText().isEmpty()) {
                Alert alert4 = new Alert(Alert.AlertType.ERROR);
                alert4.setContentText("Please Enter Last Name");
                alert4.showAndWait();
        } else if (phone.getText().isEmpty()) {
                Alert alert5 = new Alert(Alert.AlertType.ERROR);
                alert5.setContentText("Please Enter PhoneNumber");
                alert5.showAndWait();
            }else if (address.getText().isEmpty()) {
                Alert alert5 = new Alert(Alert.AlertType.ERROR);
                alert5.setContentText("Please Enter a Valid Address");
                alert5.showAndWait();
        } else {

                String query5 = "Insert into addition(usn,firstname,lastname,dates,phonenumber,address,gender) values(?,?,?,?,?,?,?)";
                PreparedStatement prepareStat = connection.prepareStatement(query5);
                prepareStat.setString(1, usn.getText().trim());
                prepareStat.setString(2, first1.getText().trim());
                prepareStat.setString(3, last1.getText().trim());
                prepareStat.setString(4, dob.getValue() + " ' ");
                prepareStat.setString(5, phone.getText().trim());
                prepareStat.setString(6, address.getText().trim());
                prepareStat.setString(7, choice.getValue().toString().trim().equalsIgnoreCase("Select Gender") ? "" : choice.getValue().toString());
                int i = prepareStat.executeUpdate();
                refresh_addition();
                if (i > 0) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setContentText("Student Details Added succesfully");
                    alert.showAndWait();
                }
            }

            } catch(Exception e){
                e.printStackTrace();
            }

        finally{
                try {

                    if (connection != null)
                        connection.close();

                } catch (Exception e) {
                    e.printStackTrace();
                    StringWriter sw = new StringWriter();
                    e.printStackTrace(new PrintWriter(sw));
                    String exceptionAsString = sw.toString();

                }
            }
        }

    private void refresh_addition() {
        usn.clear();
        first1.clear();
        last1.clear();
        phone.clear();
        address.clear();
        choice.hide();
    }


    public void view(ActionEvent actionEvent) throws Exception {
        Connection connection = null;
        connection = DBConnect.getConnection();
        String query6 = "select * from addition";
        LoadingTableViewDataSelectedRowName.Welcome(query6, pane, 374, 873);
        pane.setVisible(true);
        addpane.setVisible(true);
        scorepane.setVisible(false);
        scorepane3.setVisible(false);
        activepane.setVisible(false);
        activitypane4.setVisible(false);
        makspane.setVisible(false);
        subscore.setVisible(false);
        dash.setVisible(false);

    }

    public void delete(ActionEvent actionEvent) throws Exception {
        ObservableList oa=LoadingTableViewDataSelectedRowName.selectItem();

        ArrayList aa=new ArrayList();
        aa.add(oa.get(0));

        ArrayList newArray=new ArrayList();
        newArray =aa;
        String old=String.valueOf(newArray.get(0));
        ArrayList<String> bb=new ArrayList<>();

        old=old.replace("[","");
        old=old.replace("]","");

        String log[]=old.split(",");
        String log1[]=old.split(",");

        bb.add(log1[0]);
        try{
            bb.add(log1[1]);

        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("pls select");
            alert.showAndWait();

        }
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("sure to delete");


        Optional<ButtonType> result=alert.showAndWait();

        if((result.isPresent()) && (result.get()==ButtonType.OK)){
            try{
                connection=DBConnect.getConnection();
                int c_id=Integer.parseInt(bb.get(0));
                String query3="select * from addition where id='" +c_id+ "'";
                ResultSet rs=connection.createStatement().executeQuery(query3);
                while (rs.next()){
                    rs.getString("id");
                    rs.getString("usn");
                    rs.getString("firstname");
                    rs.getString("lastname");
                    rs.getString("dates");
                    rs.getString("phonenumber");
                    rs.getString("address");


                }
                String query="delete from addition where id='"+c_id+"'";
                PreparedStatement ps =connection.prepareStatement(query);
                int i=ps.executeUpdate();

                if(i>0){
                    Alert a = new Alert(Alert.AlertType.INFORMATION);
                    a.setContentText("deleted successfully");
                    a.showAndWait();
                    pane.setVisible(true);
                    view(actionEvent);
                }else{
                    Alert a = new Alert(Alert.AlertType.INFORMATION);
                    a.setContentText("error in deleting");
                    a.showAndWait();
                }
            }catch (Exception e){
                e.printStackTrace();
                StringWriter sw =new StringWriter();
                e.printStackTrace(new PrintWriter(sw));
                String exceptionAsString=sw.toString();
              //  logger.log(exceptionAsString);
            }
        }


    }

    public void add2(ActionEvent actionEvent) {
        addpane.setVisible(true);
        pane.setVisible(false);
        scorepane.setVisible(false);
        scorepane3.setVisible(false);
        activepane.setVisible(false);
        activitypane4.setVisible(false);
        makspane.setVisible(false);
        subscore.setVisible(false);
        dash.setVisible(false);
    }


    public void add3(ActionEvent actionEvent) {
        addpane.setVisible(false);
        pane.setVisible(false);
        scorepane.setVisible(true);
        scorepane3.setVisible(false);
        activepane.setVisible(false);
        activitypane4.setVisible(false);
        makspane.setVisible(false);
        subscore.setVisible(false);
        dash.setVisible(false);
    }

    public void add4(ActionEvent actionEvent) throws Exception {
        Connection connection = null;
        connection = DBConnect.getConnection();
        String query6 = "select * from scores";
        LoadingTableViewDataSelectedRowName.Welcome(query6, scorepane3, 400, 800);
        pane.setVisible(false);
        addpane.setVisible(false);
        scorepane.setVisible(true);
        scorepane3.setVisible(true);
        activepane.setVisible(false);
        activitypane4.setVisible(false);
        makspane.setVisible(false);
        subscore.setVisible(false);
        dash.setVisible(false);

    }

    public void add5(ActionEvent actionEvent) {
        try {
            Connection connection = null;
            connection = DBConnect.getConnection();


            String query9 = "Insert into scores(usn,course,grade,percentage,result) values(?,?,?,?,?)";
            PreparedStatement prepareStat = connection.prepareStatement(query9);
            //  prepareStat.setString(1, id.getText().trim());
            prepareStat.setString(1, usn1.getText().trim());
            prepareStat.setString(2, subject.getValue().toString().trim().equalsIgnoreCase("select subject") ? "" : subject.getValue().toString());
            prepareStat.setString(3, grade1.getText().trim());
            prepareStat.setString(4, perc.getText().trim());
            prepareStat.setString(5, resu.getText().trim());
            //prepareStat.setString(6, gender.getText().trim());


            int i = prepareStat.executeUpdate();

            if (i > 0) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("added succesfully");
                alert.showAndWait();
            }
            

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // String exceptionAsString = sw.toString();

        finally {
            try {

                if (connection != null)
                    connection.close();

            } catch (Exception e) {
                e.printStackTrace();
                StringWriter sw = new StringWriter();
                e.printStackTrace(new PrintWriter(sw));
                String exceptionAsString = sw.toString();

            }
        }
    }

    public void activityadd(ActionEvent actionEvent) {
        pane.setVisible(false);
        addpane.setVisible(false);
        scorepane.setVisible(false);
        scorepane3.setVisible(false);
        activepane.setVisible(true);
        activitypane4.setVisible(true);
        makspane.setVisible(false);
        subscore.setVisible(false);
        dash.setVisible(false);


    }

    public void activeadd(ActionEvent actionEvent) {
        try {
            Connection connection = null;
            connection = DBConnect.getConnection();


            String query9 = "Insert into event(usn,sports,cultural,feast,dates) values(?,?,?,?,?)";
            PreparedStatement prepareStat = connection.prepareStatement(query9);
            //  prepareStat.setString(1, id.getText().trim());
            prepareStat.setString(1, usn3.getText().trim());
            prepareStat.setString(2, sports3.getText().trim());
            prepareStat.setString(3, cultu3.getText().trim());
            prepareStat.setString(4, feast3.getText().trim());
            prepareStat.setString(5, date3.getValue() + "'");
            //prepareStat.setString(6, gender.getText().trim());


            int i = prepareStat.executeUpdate();

            if (i > 0) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("added succesfully");
                alert.showAndWait();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        // String exceptionAsString = sw.toString();

        finally {
            try {

                if (connection != null)
                    connection.close();

            } catch (Exception e) {
                e.printStackTrace();
                StringWriter sw = new StringWriter();
                e.printStackTrace(new PrintWriter(sw));
                String exceptionAsString = sw.toString();

            }
        }
    }
    public void viewactive(ActionEvent actionEvent) throws Exception {
        Connection connection = null;
        connection = DBConnect.getConnection();
        String query7 = "select * from event";
        LoadingTableViewDataSelectedRowName.Welcome(query7, activitypane4, 400, 800);
        pane.setVisible(false);
        addpane.setVisible(false);
        scorepane.setVisible(false);
        scorepane3.setVisible(false);
        activepane.setVisible(true);
        activitypane4.setVisible(true);
        makspane.setVisible(false);
        subscore.setVisible(false);
        dash.setVisible(false);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {


            choice.getItems().removeAll(choice.getItems());
            choice.getItems().addAll("Male", "Female");
            choice.getSelectionModel().select("Select Gender");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {


            subject.getItems().removeAll(subject.getItems());
            subject.getItems().addAll("ME", "CSE", "ECE", "ISE", "AERONOTICAL", "TCE", "BTE", "GTE");
            subject.getSelectionModel().select("select type");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {


            subbranch.getItems().removeAll(subject.getItems());
            subbranch.getItems().addAll("ME", "CSE", "ECE", "ISE", "AERONOTICAL", "TCE", "BTE", "GTE");
            subbranch.getSelectionModel().select(" select type");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void search1(KeyEvent keyEvent) throws SQLException {
        try {
            connection = DBConnect.getConnection();
            if (!search.getText().trim().isEmpty()) {
                String query10 = "select * from addition where usn like '%" + search.getText().trim().toUpperCase() + "%'";
                LoadingTableViewDataSelectedRowName.Welcome(query10, pane, 374, 873);
                if (connection.isClosed()) {
                    connection = DBConnect.getConnection();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            // P.loggerLoader(e);

        } finally {
            if (!connection.isClosed()) {
                connection.close();
            }
        }
    }

    public void editadd(ActionEvent actionEvent) {

        ObservableList oa = LoadingTableViewDataSelectedRowName.selectItem();

        ArrayList aa = new ArrayList();
        aa.add(oa.get(0));

        ArrayList newArray = new ArrayList();
        newArray = aa;
        String old = String.valueOf(newArray.get(0));
        ArrayList<String> bb = new ArrayList<>();
        int check = 0;

        old = old.replace("[", "");
        old = old.replace("]", "");

        String log[] = old.split(",");
        String log1[] = old.split(",");

        bb.add(log1[0].trim());
        try {
            bb.add(log1[1].trim());
            //pane.setVisible(true);
        } catch (Exception e) {

            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("PLEASE SELECT ");
            a.showAndWait();
            check++;
        }
        if (check == 0) {
            try {
                connection = DBConnect.getConnection();

                int s_id = Integer.parseInt(bb.get(0).trim());

                String query = "Select id,usn,firstname,lastname,phonenumber,address,gender from addition where id='" + s_id + "'";

                ResultSet rs = connection.createStatement().executeQuery(query);

                while (rs.next()) {
                    addid.setText(rs.getString("id"));
                    usn.setText(rs.getString("usn"));
                    first1.setText(rs.getString("firstname"));
                    last1.setText(rs.getString("lastname"));
                    //dob.setValue(LocalDate.parse(rs.getString("dates")));
                    phone.setText(rs.getString("phonenumber"));
                    address.setText(rs.getString("address"));
                    choice.setValue(rs.getString("gender"));

                }

            } catch (Exception e) {
                e.printStackTrace();
                P.loggerLoader(e);
            }
        }

    }

    public void addedit(ActionEvent actionEvent) throws SQLException {
        try {

            connection = DBConnect.getConnection();

            PreparedStatement ps = connection.prepareStatement
                    ("update addition set " +
                            "usn='" + usn.getText().trim() + "', " +
                            "firstname='" + first1.getText().trim() + "'," +
                            "lastname='" + last1.getText().trim() + "', " +
                            " phonenumber='" + phone.getText().trim() + "'," +
                            "address='" + address.getText().trim() + "'," +
                            "gender='" + choice.getValue() + "'" +
                            "where id = " + addid.getText().trim());


            int i = ps.executeUpdate();

            if (i > 0) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("MEMBER INFORMATION UPDATED SUCCESSFULLY");
                alert.showAndWait();

                refresh_category();
                pane.setVisible(true);
                view(actionEvent);
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("ERROR IN SAVING MEMBER INFORMATION");
                alert.showAndWait();
            }
        } catch (Exception e) {
            e.printStackTrace();
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            String exceptionAsString = sw.toString();
            // Logger.log(exceptionAsString);

        } finally {
            if (connection != null)
                connection.close();
        }
    }

    private void refresh_category() {
        usn.clear();
        first1.clear();
        last1.clear();
        phone.clear();
        address.clear();


    }

    public void scoreedit(ActionEvent actionEvent) {
        ObservableList oa = LoadingTableViewDataSelectedRowName.selectItem();

        ArrayList aa = new ArrayList();
        aa.add(oa.get(0));

        ArrayList newArray = new ArrayList();
        newArray = aa;
        String old = String.valueOf(newArray.get(0));
        ArrayList<String> bb = new ArrayList<>();
        int check = 0;

        old = old.replace("[", "");
        old = old.replace("]", "");

        String log[] = old.split(",");
        String log1[] = old.split(",");

        bb.add(log1[0].trim());
        try {
            bb.add(log1[1].trim());
            //pane.setVisible(true);
        } catch (Exception e) {

            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("PLEASE SELECT ");
            a.showAndWait();
            check++;
        }
        if (check == 0) {
            try {
                connection = DBConnect.getConnection();

                int s_id = Integer.parseInt(bb.get(0).trim());

                String query = "Select id,usn,course,grade,percentage,result from scores where id='" + s_id + "'";

                ResultSet rs = connection.createStatement().executeQuery(query);

                while (rs.next()) {
                    scoreid.setText(rs.getString("id"));
                    usn1.setText(rs.getString("usn"));
                    subject.setValue(rs.getString("course"));
                    grade1.setText(rs.getString("grade"));
                    //dob.setValue(LocalDate.parse(rs.getString("dates")));
                    perc.setText(rs.getString("percentage"));
                    resu.setText(rs.getString("result"));
                    //choice.setValue(rs.getString("gender"));

                }

            } catch (Exception e) {
                e.printStackTrace();
                P.loggerLoader(e);
            }
        }
    }

    public void scoreupdate(ActionEvent actionEvent) throws SQLException {
        try {

            connection = DBConnect.getConnection();

            PreparedStatement pp = connection.prepareStatement
                    ("update scores set " +
                            "usn='" + usn1.getText().trim() + "', " +
                            "course ='" + subject.getValue() + "'," +
                            "grade='" + grade1.getText().trim() + "', " +
                            " percentage='" + perc.getText().trim() + "'," +
                            "result='" + resu.getText().trim() + "'" +
                            // "gender='" + choice.getValue()+"'" +
                            "where id = " + scoreid.getText().trim());


            int i = pp.executeUpdate();

            if (i > 0) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("MEMBER INFORMATION UPDATED SUCCESSFULLY");
                alert.showAndWait();

                refresh_category1();
                scorepane3.setVisible(true);
                add4(actionEvent);
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("ERROR IN SAVING MEMBER INFORMATION");
                alert.showAndWait();
            }
        } catch (Exception e) {
            e.printStackTrace();
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            String exceptionAsString = sw.toString();
            // Logger.log(exceptionAsString);

        } finally {
            if (connection != null)
                connection.close();
        }
    }

    private void refresh_category1() {
        usn1.clear();
        grade1.clear();
        perc.clear();
        resu.clear();
    }

    public void actedit(ActionEvent actionEvent) {
        ObservableList oa = LoadingTableViewDataSelectedRowName.selectItem();

        ArrayList aa = new ArrayList();
        aa.add(oa.get(0));

        ArrayList newArray = new ArrayList();
        newArray = aa;
        String old = String.valueOf(newArray.get(0));
        ArrayList<String> bb = new ArrayList<>();
        int check = 0;

        old = old.replace("[", "");
        old = old.replace("]", "");

        String log[] = old.split(",");
        String log1[] = old.split(",");

        bb.add(log1[0].trim());
        try {
            bb.add(log1[1].trim());
            //pane.setVisible(true);
        } catch (Exception e) {

            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("PLEASE SELECT ");
            a.showAndWait();
            check++;
        }
        if (check == 0) {
            try {
                connection = DBConnect.getConnection();

                int d_id = Integer.parseInt(bb.get(0).trim());

                String query = "Select id,usn,sports,cultural,feast from event where id='" + d_id + "'";

                ResultSet rs = connection.createStatement().executeQuery(query);

                while (rs.next()) {
                    actid.setText(rs.getString("id"));
                    usn3.setText(rs.getString("usn"));
                    sports3.setText(rs.getString("sports"));
                    cultu3.setText(rs.getString("cultural"));
                    //dob.setValue(LocalDate.parse(rs.getString("dates")));
                    feast3.setText(rs.getString("feast"));
                    //  resu.setText(rs.getString("result"));
                    //choice.setValue(rs.getString("gender"));

                }

            } catch (Exception e) {
                e.printStackTrace();
                P.loggerLoader(e);
            }
        }
    }

    public void actupdate(ActionEvent actionEvent) throws SQLException {
        try {

            connection = DBConnect.getConnection();

            PreparedStatement pt = connection.prepareStatement
                    ("update event set " +
                            "usn='" + usn3.getText().trim() + "', " +
                            "sports ='" + sports3.getText().trim() + "'," +
                            "cultural ='" + cultu3.getText().trim() + "', " +
                            " feast='" + feast3.getText().trim() + "'" +
                            "where id = " + actid.getText().trim());


            int i = pt.executeUpdate();

            if (i > 0) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("MEMBER INFORMATION UPDATED SUCCESSFULLY");
                alert.showAndWait();

                refresh_category3();
                activepane.setVisible(true);
                viewactive(actionEvent);
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("ERROR IN SAVING MEMBER INFORMATION");
                alert.showAndWait();
            }
        } catch (Exception e) {
            e.printStackTrace();
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            String exceptionAsString = sw.toString();
            // Logger.log(exceptionAsString);

        } finally {
            if (connection != null)
                connection.close();
        }
    }

    private void refresh_category3() {
        usn3.clear();
        sports3.clear();
        cultu3.clear();
        feast3.clear();
    }

    public void studid(MouseEvent mouseEvent) throws Exception {
        int i = 0;
        try {
            connection = DBConnect.getConnection();
            String empidis = "";
            Statement stm1 = connection.createStatement();

            ResultSet rs = stm1.executeQuery("select max(id) as id from addition");
            while (rs.next()) {
                empidis = rs.getString("id");
                i++;
            }
            if (empidis != null && 1 > 0) {
                incidArray = (Integer.parseInt(empidis) + 1);
                addid.setText(String.valueOf(incidArray));

            } else {
                addid.setText(String.valueOf(1));
            }

        } catch (Exception e) {
            e.printStackTrace();
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            String ExceptionAsString = sw.toString();
            // lodder.log(exceptionAsString);

        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
                StringWriter sw = new StringWriter();
                e.printStackTrace(new PrintWriter(sw));
                String exceptionAsString = sw.toString();

            }
        }
    }

    public void actid(MouseEvent mouseEvent) {
        int i = 0;
        try {
            connection = DBConnect.getConnection();
            String empidis = "";
            Statement stm1 = connection.createStatement();

            ResultSet rs = stm1.executeQuery("select max(id) as id from event");
            while (rs.next()) {
                empidis = rs.getString("id");
                i++;
            }
            if (empidis != null && 1 > 0) {
                incidArray = (Integer.parseInt(empidis) + 1);
                actid.setText(String.valueOf(incidArray));

            } else {
                actid.setText(String.valueOf(1));
            }

        } catch (Exception e) {
            e.printStackTrace();
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            String ExceptionAsString = sw.toString();
            // lodder.log(exceptionAsString);

        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
                StringWriter sw = new StringWriter();
                e.printStackTrace(new PrintWriter(sw));
                String exceptionAsString = sw.toString();

            }
        }
    }

    public void scoreid(MouseEvent mouseEvent) {
        int i = 0;
        try {
            connection = DBConnect.getConnection();
            String empidis = "";
            Statement stm1 = connection.createStatement();

            ResultSet rs = stm1.executeQuery("select max(id) as id from scores");
            while (rs.next()) {
                empidis = rs.getString("id");
                i++;
            }
            if (empidis != null && 1 > 0) {
                incidArray = (Integer.parseInt(empidis) + 1);
                scoreid.setText(String.valueOf(incidArray));

            } else {
                scoreid.setText(String.valueOf(1));
            }

        } catch (Exception e) {
            e.printStackTrace();
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            String ExceptionAsString = sw.toString();
            // lodder.log(exceptionAsString);

        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
                StringWriter sw = new StringWriter();
                e.printStackTrace(new PrintWriter(sw));
                String exceptionAsString = sw.toString();

            }
        }
    }

    public void searchscore(KeyEvent keyEvent) throws SQLException {
        try {
            connection = DBConnect.getConnection();
            if (!searchscore.getText().trim().isEmpty()) {
                String query10 = "select * from scores where usn like '%" + searchscore.getText().trim().toUpperCase() + "%'";
                LoadingTableViewDataSelectedRowName.Welcome(query10, scorepane3, 286, 860);
                if (connection.isClosed()) {
                    connection = DBConnect.getConnection();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            // P.loggerLoader(e);

        } finally {
            if (!connection.isClosed()) {
                connection.close();
            }
        }
    }

    public void actsearch(KeyEvent keyEvent) throws SQLException {
        try {
            connection = DBConnect.getConnection();
            if (!actsearch.getText().trim().isEmpty()) {
                String query10 = "select * from event where usn like '%" + actsearch.getText().trim().toUpperCase() + "%'";
                LoadingTableViewDataSelectedRowName.Welcome(query10, activitypane4, 400, 800);
                if (connection.isClosed()) {
                    connection = DBConnect.getConnection();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            // P.loggerLoader(e);

        } finally {
            if (!connection.isClosed()) {
                connection.close();
            }
        }
    }

    public void scoredelete(ActionEvent actionEvent) {
        ObservableList oa=LoadingTableViewDataSelectedRowName.selectItem();

        ArrayList aa=new ArrayList();
        aa.add(oa.get(0));

        ArrayList newArray=new ArrayList();
        newArray =aa;
        String old=String.valueOf(newArray.get(0));
        ArrayList<String> bb=new ArrayList<>();

        old=old.replace("[","");
        old=old.replace("]","");

        String log[]=old.split(",");
        String log1[]=old.split(",");

        bb.add(log1[0]);
        try{
            bb.add(log1[1]);

        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("pls select");
            alert.showAndWait();

        }
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("sure ta delete");


        Optional<ButtonType> result=alert.showAndWait();

        if((result.isPresent()) && (result.get()==ButtonType.OK)){
            try{
                connection=DBConnect.getConnection();
                int c_id=Integer.parseInt(bb.get(0));
                String query3="select * from scores where id='" +c_id+ "'";
                ResultSet rs=connection.createStatement().executeQuery(query3);
                while (rs.next()){
                    rs.getString("id");
                    rs.getString("usn");
                    rs.getString("course");
                    rs.getString("grade");
                    rs.getString("percentage");
                    rs.getString("result");
                    //rs.getString("address");


                }
                String query="delete from scores where id='"+c_id+"'";
                PreparedStatement ps =connection.prepareStatement(query);
                int i=ps.executeUpdate();

                if(i>0){
                    Alert a = new Alert(Alert.AlertType.INFORMATION);
                    a.setContentText("deleted successfully");
                    a.showAndWait();
                    scorepane3.setVisible(true);
                    add4(actionEvent);
                } else
                    {
                    Alert a = new Alert(Alert.AlertType.INFORMATION);
                    a.setContentText("error in deleting");
                    a.showAndWait();
                }
            }catch (Exception e){
                e.printStackTrace();
                StringWriter sw =new StringWriter();
                e.printStackTrace(new PrintWriter(sw));
                String exceptionAsString=sw.toString();
                //  logger.log(exceptionAsString);
            }
        }

    }

    public void actdelete(ActionEvent actionEvent) {
        ObservableList oa=LoadingTableViewDataSelectedRowName.selectItem();

        ArrayList aa=new ArrayList();
        aa.add(oa.get(0));

        ArrayList newArray=new ArrayList();
        newArray =aa;
        String old=String.valueOf(newArray.get(0));
        ArrayList<String> bb=new ArrayList<>();

        old=old.replace("[","");
        old=old.replace("]","");

        String log[]=old.split(",");
        String log1[]=old.split(",");

        bb.add(log1[0]);
        try{
            bb.add(log1[1]);

        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("pls select");
            alert.showAndWait();

        }
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("sure ta delete");


        Optional<ButtonType> result=alert.showAndWait();

        if((result.isPresent()) && (result.get()==ButtonType.OK)){
            try{
                connection=DBConnect.getConnection();
                int c_id=Integer.parseInt(bb.get(0));
                String query3="select * from event where id='" +c_id+ "'";
                ResultSet rs=connection.createStatement().executeQuery(query3);
                while (rs.next()){
                    rs.getString("id");
                    rs.getString("usn");
                    rs.getString("sports");
                    rs.getString("cultural");
                    rs.getString("feast");
                    rs.getString("dates");
                    //rs.getString("address");


                }
                String query="delete from event where id='"+c_id+"'";
                PreparedStatement ps =connection.prepareStatement(query);
                int i=ps.executeUpdate();

                if(i>0){
                    Alert a = new Alert(Alert.AlertType.INFORMATION);
                    a.setContentText("deleted successfully");
                    a.showAndWait();
                    activitypane4.setVisible(true);
                    viewactive(actionEvent);
                }else{
                    Alert a = new Alert(Alert.AlertType.INFORMATION);
                    a.setContentText("error in deleting");
                    a.showAndWait();
                }
            }catch (Exception e){
                e.printStackTrace();
                StringWriter sw =new StringWriter();
                e.printStackTrace(new PrintWriter(sw));
                String exceptionAsString=sw.toString();
                //  logger.log(exceptionAsString);
            }
        }

    }

    public void subadd(ActionEvent actionEvent) {
        try {
            Connection connection = null;
            connection = DBConnect.getConnection();


            String query5 = "Insert into marks(usn,course,sub1,sub2,sub3,sub4,sub5,sub6,total,percentage,grade,result) values(?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement prepareStat = connection.prepareStatement(query5);
            //  prepareStat.setString(1, id.getText().trim());
            prepareStat.setString(1, subusn.getText().trim());
            prepareStat.setString(2, subbranch.getValue().toString().trim().equalsIgnoreCase("select choice") ? "" : subbranch.getValue().toString());
            prepareStat.setString(3, sub1.getText().trim());
            prepareStat.setString(4, sub2.getText().trim());
            prepareStat.setString(5, sub3.getText().trim());
            prepareStat.setString(6, sub4.getText().trim());
            prepareStat.setString(7, sub5.getText().trim());
            prepareStat.setString(8, sub6.getText().trim());
            prepareStat.setString(9, total.getText().trim());
            prepareStat.setString(10, subperc.getText().trim());
            prepareStat.setString(11, grade2.getText().trim());
            prepareStat.setString(12, resu2.getText().trim());

            int i = prepareStat.executeUpdate();

            if (i > 0) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("added succesfully");
                alert.showAndWait();
                subview(actionEvent);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        // String exceptionAsString = sw.toString();

        finally {
            try {

                if (connection != null)
                    connection.close();

            } catch (Exception e) {
                e.printStackTrace();
                StringWriter sw = new StringWriter();
                e.printStackTrace(new PrintWriter(sw));
                String exceptionAsString = sw.toString();

            }
        }
    }

    public void subview(ActionEvent actionEvent) throws Exception {
        Connection connection = null;
        connection = DBConnect.getConnection();
        String query7 = "select * from marks";
        LoadingTableViewDataSelectedRowName.Welcome(query7,makspane, 400, 600);
        pane.setVisible(false);
        addpane.setVisible(false);
        scorepane.setVisible(false);
        scorepane3.setVisible(false);
        activepane.setVisible(false);
        activitypane4.setVisible(false);
        subscore.setVisible(true);
        makspane.setVisible(true);
        dash.setVisible(false);
    }

    public void addmarks(ActionEvent actionEvent) {
        pane.setVisible(false);
        addpane.setVisible(false);
        scorepane.setVisible(false);
        scorepane3.setVisible(false);
        activepane.setVisible(false);
        activitypane4.setVisible(false);
        subscore.setVisible(true);
        makspane.setVisible(true);
        dash.setVisible(false);
    }

    public void marksedit(ActionEvent actionEvent) {
        ObservableList oa = LoadingTableViewDataSelectedRowName.selectItem();

        ArrayList aa = new ArrayList();
        aa.add(oa.get(0));

        ArrayList newArray = new ArrayList();
        newArray = aa;
        String old = String.valueOf(newArray.get(0));
        ArrayList<String> bb = new ArrayList<>();
        int check = 0;

        old = old.replace("[", "");
        old = old.replace("]", "");

        String log[] = old.split(",");
        String log1[] = old.split(",");

        bb.add(log1[0].trim());
        try {
            bb.add(log1[1].trim());
            //pane.setVisible(true);
        } catch (Exception e) {

            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("PLEASE SELECT ");
            a.showAndWait();
            check++;
        }
        if (check == 0) {
            try {
                connection = DBConnect.getConnection();

                int d_id = Integer.parseInt(bb.get(0).trim());

                String query = "Select id,usn,course,sub1,sub2,sub3,sub4,sub5,sub6,total,percentage,grade,result from marks where id='" + d_id + "'";

                ResultSet rs = connection.createStatement().executeQuery(query);

                while (rs.next()) {
                    subid.setText(rs.getString("id"));
                    subusn.setText(rs.getString("usn"));
                    subbranch.setValue(rs.getString("course"));
                    sub1.setText(rs.getString("sub1"));
                    sub2.setText(rs.getString("sub2"));
                    sub3.setText(rs.getString("sub3"));
                    sub4.setText(rs.getString("sub4"));
                    sub5.setText(rs.getString("sub5"));
                    sub6.setText(rs.getString("sub6"));
                    //dob.setValue(LocalDate.parse(rs.getString("dates")));
                    total.setText(rs.getString("total"));
                    subperc.setText(rs.getString("percentage"));
                    grade2.setText(rs.getString("percentage"));
                    resu2.setText(rs.getString("percentage"));
                    //choice.setValue(rs.getString("gender"));

                }

            } catch (Exception e) {
                e.printStackTrace();
                P.loggerLoader(e);
            }
        }
    }

    public void marksupdate(ActionEvent actionEvent) throws SQLException {
        try {

            connection = DBConnect.getConnection();

            PreparedStatement pt = connection.prepareStatement
                    ("update marks set " +
                            "usn='" + subusn.getText().trim() + "', " +
                            "course ='" + subbranch.getValue() + "'," +
                            "sub1 ='" + sub1.getText().trim() + "', " +
                            "sub2 ='" + sub2.getText().trim() + "', " +
                            "sub3 ='" + sub3.getText().trim() + "', " +
                            "sub4 ='" + sub4.getText().trim() + "', " +
                            "sub5 ='" + sub5.getText().trim() + "', " +
                            "sub6 ='" + sub6.getText().trim() + "', " +
                            "total ='" + total.getText().trim() + "', " +
                            "percentage='" + subperc.getText().trim() + "'," +
                            "grade='" + grade2.getText().trim() + "'," +
                            "result='" + resu2.getText().trim() + "'" +
                            "where id = " + subid.getText().trim());


            int i = pt.executeUpdate();

            if (i > 0) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("MEMBER INFORMATION UPDATED SUCCESSFULLY");
                alert.showAndWait();

                refresh_category4();
                makspane.setVisible(true);
                subview(actionEvent);
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("ERROR IN SAVING MEMBER INFORMATION");
                alert.showAndWait();
            }
        } catch (Exception e) {
            e.printStackTrace();
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            String exceptionAsString = sw.toString();
            // Logger.log(exceptionAsString);

        } finally {
            if (connection != null)
                connection.close();
        }
    }

    private void refresh_category4() {
        subid.clear();
        subusn.clear();
        sub1.clear();
        sub2.clear();
        sub3.clear();
        sub4.clear();
        sub5.clear();
        sub6.clear();
        total.clear();
        subperc.clear();
        resu2.clear();
        grade2.clear();
    }

    public void marksdelete(ActionEvent actionEvent) {
        ObservableList oa=LoadingTableViewDataSelectedRowName.selectItem();

        ArrayList aa=new ArrayList();
        aa.add(oa.get(0));

        ArrayList newArray=new ArrayList();
        newArray =aa;
        String old=String.valueOf(newArray.get(0));
        ArrayList<String> bb=new ArrayList<>();

        old=old.replace("[","");
        old=old.replace("]","");

        String log[]=old.split(",");
        String log1[]=old.split(",");

        bb.add(log1[0]);
        try{
            bb.add(log1[1]);

        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("pls select");
            alert.showAndWait();

        }
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("sure ta delete");


        Optional<ButtonType> result=alert.showAndWait();

        if((result.isPresent()) && (result.get()==ButtonType.OK)){
            try{
                connection=DBConnect.getConnection();
                int c_id=Integer.parseInt(bb.get(0));
                String query3="select * from marks where id='" +c_id+ "'";
                ResultSet rs=connection.createStatement().executeQuery(query3);
                while (rs.next()){
                    rs.getString("id");
                    rs.getString("usn");
                    rs.getString("course");
                    rs.getString("sub1");
                    rs.getString("sub2");
                    rs.getString("sub3");
                    rs.getString("sub4");
                    rs.getString("sub5");
                    rs.getString("sub6");
                    rs.getString("total");
                    rs.getString("percentage");
                    rs.getString("grade");
                    rs.getString("result");


                }
                String query="delete from marks where id='"+c_id+"'";
                PreparedStatement ps =connection.prepareStatement(query);
                int i=ps.executeUpdate();

                if(i>0){
                    Alert a = new Alert(Alert.AlertType.INFORMATION);
                    a.setContentText("deleted successfully");
                    a.showAndWait();
                    makspane.setVisible(true);
                    subview(actionEvent);
                }else{
                    Alert a = new Alert(Alert.AlertType.INFORMATION);
                    a.setContentText("error in deleting");
                    a.showAndWait();
                }
            }catch (Exception e){
                e.printStackTrace();
                StringWriter sw =new StringWriter();
                e.printStackTrace(new PrintWriter(sw));
                String exceptionAsString=sw.toString();
                //  logger.log(exceptionAsString);
            }
        }

    }


    public void subidinc(MouseEvent mouseEvent) {
        int i = 0;
        try {
            connection = DBConnect.getConnection();
            String empidis = "";
            Statement stm1 = connection.createStatement();

            ResultSet rs = stm1.executeQuery("select max(id) as id from marks");
            while (rs.next()) {
                empidis = rs.getString("id");
                i++;
            }
            if (empidis != null && 1 > 0) {
                incidArray = (Integer.parseInt(empidis) + 1);
                subid.setText(String.valueOf(incidArray));

            } else {
                subid.setText(String.valueOf(1));
            }

        } catch (Exception e) {
            e.printStackTrace();
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            String ExceptionAsString = sw.toString();
            // lodder.log(exceptionAsString);

        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
                StringWriter sw = new StringWriter();
                e.printStackTrace(new PrintWriter(sw));
                String exceptionAsString = sw.toString();

            }
        }
    }

    public void markssearch(KeyEvent keyEvent) throws SQLException {
        try {
            connection = DBConnect.getConnection();
            if (!marksearch.getText().trim().isEmpty()) {
                String query10 = "select * from marks where usn like '%" + marksearch.getText().trim().toUpperCase() + "%'";
                LoadingTableViewDataSelectedRowName.Welcome(query10, makspane, 400, 800);
                if (connection.isClosed()) {
                    connection = DBConnect.getConnection();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            // P.loggerLoader(e);

        } finally {
            if (!connection.isClosed()) {
                connection.close();
            }
        }
    }

    public void sub1(KeyEvent keyEvent) {
        double total1=0,sub11=0,sub22=0,sub33=0,sub44=0,sub55=0,sub66=0 ,percentage=0;
        if (!sub1.getText().trim().isEmpty()) {
            sub11 = Double.parseDouble((sub1.getText()));
        }
          if(!sub2.getText().trim().isEmpty()) {
              sub22 = Double.parseDouble((sub2.getText()));
          }
        if(!sub3.getText().trim().isEmpty()) {
            sub33 = Double.parseDouble((sub3.getText()));
        }
        if(!sub4.getText().trim().isEmpty()) {
            sub44 = Double.parseDouble((sub4.getText()));
        }
        if(!sub5.getText().trim().isEmpty()) {
            sub55 = Double.parseDouble((sub5.getText()));
        }
        if(!sub6.getText().trim().isEmpty()){
            sub66=Double.parseDouble((sub6.getText()));
        }
        total1=sub11+sub22+sub33+sub44+sub55+sub66;
        total.setText(String.valueOf(total1));
        percentage=100*total1/600;
subperc.setText(String.valueOf(percentage));
        String grade=" ",result=" ";
        if(percentage >= 75 && percentage<100){
            grade ="A";result="PASS";
        }
        else if(percentage>=65 && percentage<75){
            grade="B"; result="PASS";

        }
        else if(percentage>40 && percentage<65){
            grade="C";result="PASS";

        }
        else {
            grade="F";result="FAIL";
        }
        grade2.setText(String.valueOf(grade));


        resu2.setText(String.valueOf(result));

    }

    public void sub2(KeyEvent keyEvent) {
        double total1=0,sub11=0,sub22=0,sub33=0,sub44=0,sub55=0,sub66=0 ,percentage=0;
        if (!sub1.getText().trim().isEmpty()) {
            sub11 = Double.parseDouble((sub1.getText()));
        }
        if(!sub2.getText().trim().isEmpty()) {
            sub22 = Double.parseDouble((sub2.getText()));
        }
        if(!sub3.getText().trim().isEmpty()) {
            sub33 = Double.parseDouble((sub3.getText()));
        }
        if(!sub4.getText().trim().isEmpty()) {
            sub44 = Double.parseDouble((sub4.getText()));
        }
        if(!sub5.getText().trim().isEmpty()) {
            sub55 = Double.parseDouble((sub5.getText()));
        }
        if(!sub6.getText().trim().isEmpty()){
            sub66=Double.parseDouble((sub6.getText()));
        }
        total1=sub11+sub22+sub33+sub44+sub55+sub66;
        total.setText(String.valueOf(total1));
        percentage=100*total1/600;
        subperc.setText(String.valueOf(percentage));
        String grade=" ",result=" ";
        if(percentage >= 75 && percentage<100){
            grade ="A"; result="PASS";
        }
        else if(percentage>=65 && percentage<75){
            grade="B";result="PASS";

        }
        else if(percentage>40 && percentage<65){
            grade="C";result="PASS";

        }
        else {
            grade="F";result="FAIL";
        }
        grade2.setText(String.valueOf(grade));
        resu2.setText(String.valueOf(result));
    }

    public void sub3(KeyEvent keyEvent) {
        double total1=0,sub11=0,sub22=0,sub33=0,sub44=0,sub55=0,sub66=0 ,percentage=0;
        if (!sub1.getText().trim().isEmpty()) {
            sub11 = Double.parseDouble((sub1.getText()));
        }
        if(!sub2.getText().trim().isEmpty()) {
            sub22 = Double.parseDouble((sub2.getText()));
        }
        if(!sub3.getText().trim().isEmpty()) {
            sub33 = Double.parseDouble((sub3.getText()));
        }
        if(!sub4.getText().trim().isEmpty()) {
            sub44 = Double.parseDouble((sub4.getText()));
        }
        if(!sub5.getText().trim().isEmpty()) {
            sub55 = Double.parseDouble((sub5.getText()));
        }
        if(!sub6.getText().trim().isEmpty()){
            sub66=Double.parseDouble((sub6.getText()));
        }
        total1=sub11+sub22+sub33+sub44+sub55+sub66;
        total.setText(String.valueOf(total1));
        percentage=100*total1/600;
        subperc.setText(String.valueOf(percentage));
        String grade=" ",result=" ";
        if(percentage >= 75 && percentage<100){
            grade ="A"; result="PASS";
        }
        else if(percentage>=65 && percentage<75){
            grade="B";result="PASS";

        }
        else if(percentage>40 && percentage<65){
            grade="C";result="PASS";

        }
        else {
            grade="F";result="FAIL";
        }
        grade2.setText(String.valueOf(grade));
        resu2.setText(String.valueOf(result));
    }

    public void sub4(KeyEvent keyEvent) {
        double total1=0,sub11=0,sub22=0,sub33=0,sub44=0,sub55=0,sub66=0 ,percentage=0;
        if (!sub1.getText().trim().isEmpty()) {
            sub11 = Double.parseDouble((sub1.getText()));
        }
        if(!sub2.getText().trim().isEmpty()) {
            sub22 = Double.parseDouble((sub2.getText()));
        }
        if(!sub3.getText().trim().isEmpty()) {
            sub33 = Double.parseDouble((sub3.getText()));
        }
        if(!sub4.getText().trim().isEmpty()) {
            sub44 = Double.parseDouble((sub4.getText()));
        }
        if(!sub5.getText().trim().isEmpty()) {
            sub55 = Double.parseDouble((sub5.getText()));
        }
        if(!sub6.getText().trim().isEmpty()){
            sub66=Double.parseDouble((sub6.getText()));
        }
        total1=sub11+sub22+sub33+sub44+sub55+sub66;
        total.setText(String.valueOf(total1));
        percentage=100*total1/600;
        subperc.setText(String.valueOf(percentage));
        String grade=" ",result=" ";
        if(percentage >= 75 && percentage<100){
            grade ="A"; result="PASS";
        }
        else if(percentage>=65 && percentage<75){
            grade="B";result="PASS";

        }
        else if(percentage>40 && percentage<65){
            grade="C";result="PASS";

        }
        else {
            grade="F";result="FAIL";
        }
        grade2.setText(String.valueOf(grade));
        resu2.setText(String.valueOf(result));
    }

    public void sub6(KeyEvent keyEvent) {
        double total1=0,sub11=0,sub22=0,sub33=0,sub44=0,sub55=0,sub66=0 ,percentage=0;
        if (!sub1.getText().trim().isEmpty()) {
            sub11 = Double.parseDouble((sub1.getText()));
        }
        if(!sub2.getText().trim().isEmpty()) {
            sub22 = Double.parseDouble((sub2.getText()));
        }
        if(!sub3.getText().trim().isEmpty()) {
            sub33 = Double.parseDouble((sub3.getText()));
        }
        if(!sub4.getText().trim().isEmpty()) {
            sub44 = Double.parseDouble((sub4.getText()));
        }
        if(!sub5.getText().trim().isEmpty()) {
            sub55 = Double.parseDouble((sub5.getText()));
        }
        if(!sub6.getText().trim().isEmpty()){
            sub66=Double.parseDouble((sub6.getText()));
        }
        total1=sub11+sub22+sub33+sub44+sub55+sub66;
        total.setText(String.valueOf(total1));
        percentage=100*total1/600;
        subperc.setText(String.valueOf(percentage));
        String grade=" ",result=" ";
        if(percentage >= 75 && percentage<100){
            grade ="A"; result="PASS";
        }
        else if(percentage>=65 && percentage<75){
            grade="B";result="PASS";

        }
        else if(percentage>40 && percentage<65){
            grade="C";result="PASS";

        }
        else {
            grade="F";result="FAIL";
        }
        grade2.setText(String.valueOf(grade));
        resu2.setText(String.valueOf(result));
    }

    public void sub5(KeyEvent keyEvent) {
        double total1=0,sub11=0,sub22=0,sub33=0,sub44=0,sub55=0,sub66=0 ,percentage=0;
        if (!sub1.getText().trim().isEmpty()) {
            sub11 = Double.parseDouble((sub1.getText()));
        }
        if(!sub2.getText().trim().isEmpty()) {
            sub22 = Double.parseDouble((sub2.getText()));
        }
        if(!sub3.getText().trim().isEmpty()) {
            sub33 = Double.parseDouble((sub3.getText()));
        }
        if(!sub4.getText().trim().isEmpty()) {
            sub44 = Double.parseDouble((sub4.getText()));
        }
        if(!sub5.getText().trim().isEmpty()) {
            sub55 = Double.parseDouble((sub5.getText()));
        }
        if(!sub6.getText().trim().isEmpty()){
            sub66=Double.parseDouble((sub6.getText()));
        }
        total1=sub11+sub22+sub33+sub44+sub55+sub66;
        total.setText(String.valueOf(total1));
        percentage=100*total1/600;
        subperc.setText(String.valueOf(percentage));
        String grade=" ",result=" ";
        if(percentage >= 75 && percentage<100){
            grade ="A"; result="PASS";
        }
        else if(percentage>=65 && percentage<75){
            grade="B";result="PASS";

        }
        else if(percentage>40 && percentage<65){
            grade="C";result="PASS";

        }
        else {
            grade="F";result="FAIL";
        }
        grade2.setText(String.valueOf(grade));
        resu2.setText(String.valueOf(result));
    }



    public void total(KeyEvent keyEvent) {
        double total1=0,sub11=0,sub22=0,sub33=0,sub44=0,sub55=0,sub66=0 ,percentage=0;
        if (!sub1.getText().trim().isEmpty()) {
            sub11 = Double.parseDouble((sub1.getText()));
        }
        if(!sub2.getText().trim().isEmpty()) {
            sub22 = Double.parseDouble((sub2.getText()));
        }
        if(!sub3.getText().trim().isEmpty()) {
            sub33 = Double.parseDouble((sub3.getText()));
        }
        if(!sub4.getText().trim().isEmpty()) {
            sub44 = Double.parseDouble((sub4.getText()));
        }
        if(!sub5.getText().trim().isEmpty()) {
            sub55 = Double.parseDouble((sub5.getText()));
        }
        if(!sub6.getText().trim().isEmpty()){
            sub66=Double.parseDouble((sub6.getText()));
        }
        total1=sub11+sub22+sub33+sub44+sub55+sub66;
        total.setText(String.valueOf(total1));
        percentage=100*total1/600;
        subperc.setText(String.valueOf(percentage));
        String grade=" ",result=" ";
        if(percentage >= 75 && percentage<100){
            grade ="A"; result="PASS";
        }
        else if(percentage>=65 && percentage<75){
            grade="B";result="PASS";

        }
        else if(percentage>40 && percentage<65){
            grade="C";result="PASS";

        }
        else {
            grade="F";result="FAIL";
        }
        grade2.setText(String.valueOf(grade));
        resu2.setText(String.valueOf(result));
    }

    public void perctge(KeyEvent keyEvent) {
        double total1=0,sub11=0,sub22=0,sub33=0,sub44=0,sub55=0,sub66=0 ,percentage=0;
        if (!sub1.getText().trim().isEmpty()) {
            sub11 = Double.parseDouble((sub1.getText()));
        }
        if(!sub2.getText().trim().isEmpty()) {
            sub22 = Double.parseDouble((sub2.getText()));
        }
        if(!sub3.getText().trim().isEmpty()) {
            sub33 = Double.parseDouble((sub3.getText()));
        }
        if(!sub4.getText().trim().isEmpty()) {
            sub44 = Double.parseDouble((sub4.getText()));
        }
        if(!sub5.getText().trim().isEmpty()) {
            sub55 = Double.parseDouble((sub5.getText()));
        }
        if(!sub6.getText().trim().isEmpty()){
            sub66=Double.parseDouble((sub6.getText()));
        }
        total1=sub11+sub22+sub33+sub44+sub55+sub66;
        total.setText(String.valueOf(total1));
        percentage=100*total1/600;
        subperc.setText(String.valueOf(percentage));
        String grade=" ",result=" ";
        if(percentage >= 75 && percentage<100){
            grade ="A"; result="PASS";
        }
        else if(percentage>=65 && percentage<75){
            grade="B";result="PASS";

        }
        else if(percentage>35 && percentage<65){
            grade="C";result="PASS";

        }
        else {
            grade="F";result="FAIL";
        }
        grade2.setText(String.valueOf(grade));
        resu2.setText(String.valueOf(result));
    }

    public void ashwith(KeyEvent keyEvent) throws Exception {
        AutoCompletionBinding<String> autoCompletionBinding= TextFields.bindAutoCompletion(usn1,LiveSearchMe.makeSearch("select distinct(usn)from marks ","usn"));
        Connection connection=null;
        try {
            connection = DBConnect.getConnection();
            if (!usn1.getText().trim().isEmpty()) {
                String query10 = "select * from marks where usn like '%" + usn1.getText().trim().toUpperCase() + "%'";
                LoadingTableViewDataSelectedRowName.Welcome(query10, makspane, 300, 600);


                if (connection.isClosed()) {
                    connection = DBConnect.getConnection();
                }
                ResultSet set2 = connection.createStatement().executeQuery(query10 + "limit 1");
                if (set2.next()) {
                    perc.setText(set2.getString("percentage"));
                    subject.setValue(set2.getString("course"));
                    grade1.setText(set2.getString("grade"));
                    resu.setText(set2.getString("result"));
                } else {
                    perc.setText("0");
                    subject.setValue("0");
                    grade1.setText("0");
                    resu.setText("0");
                }
                
            }

               


        } catch (Exception e) {
            e.printStackTrace();
            // P.loggerLoader(e);

        } finally {
            if (!connection.isClosed()) {
                connection.close();
            }
        }
    }


    public void logout(ActionEvent actionEvent) throws IOException {
        ((Node) actionEvent.getSource()).getScene().getWindow().hide();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("sample.fxml"));

        Stage stage = new Stage();
        stage.setTitle("new user login");
        Parent root2 = (Parent) fxmlLoader.load();
        stage.setScene(new Scene(root2));
        stage.show();
        sub.setVisible(false);
    }

    public void dashboard(ActionEvent actionEvent) throws Exception {
        Connection connection = null;
        connection = DBConnect.getConnection();
        //PreparedStatement pt =connection.prepareStatement("select count(*) as total_number_of_student from addition"+number.getText().trim());

         String query6 = "select count(*) as TOTAL_NUMBER_OF_STUDENT from addition";
       LoadingTableViewDataSelectedRowName.Welcome(query6, dash, 60, 300);
        pane.setVisible(false);
        addpane.setVisible(false);
        scorepane.setVisible(false);
        scorepane3.setVisible(false);
        activepane.setVisible(false);
        activitypane4.setVisible(false);
        makspane.setVisible(false);
        subscore.setVisible(false);
        dash.setVisible(true);
    }
}





