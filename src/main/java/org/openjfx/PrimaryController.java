package org.openjfx;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.IntegerStringConverter;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class PrimaryController implements Initializable {

    private String name, eMail, phoneNr;
    private int inDay, inMonth, inYear, day, month, year;
    private boolean successful, dateError;
    private Register register = new Register();
    private ObservableList<Person> peopleList = FXCollections.observableArrayList();
    private ObservableList<String> chkbxList = FXCollections.observableArrayList();
    private Path path = Paths.get("PersonRegister.txt");

    boolean search = false;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        chkbxList.removeAll(chkbxList);
        String chkbx1 = "Name";
        String chkbx2 = "Email";
        String chkbx3 = "Phone";
        String chkbx4 = "Day";
        String chkbx5 = "Month";
        String chkbx6 = "Year";
        chkbxList.addAll(chkbx1, chkbx2, chkbx3, chkbx4, chkbx5, chkbx6);
        chkbxSearch.getItems().addAll(chkbxList);
    }

    @FXML
    private TableView<Person> TVTable;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtPhoneNr;

    @FXML
    private TextField txtDay;

    @FXML
    private TextField txtMonth;

    @FXML
    private TextField txtYear;

    @FXML
    private Label lblErrName;

    @FXML
    private Label lblErrEmail;

    @FXML
    private Label lblErrPhoneNr;

    @FXML
    private Label lblErrDate;

    @FXML
    private Label lblErrChcbx;

    @FXML
    private TableColumn<Person, Integer> TVDay;

    @FXML
    private TableColumn<Person, Integer> TVMonth;

    @FXML
    private TableColumn<Person, Integer> TVYear;

    @FXML
    private void txtNameEdited(TableColumn.CellEditEvent<Person, String> event){
        event.getRowValue().setName(event.getNewValue());
    }

    @FXML
    private void txtEMailEdited(TableColumn.CellEditEvent<Person, String> event){
        event.getRowValue().seteMail(event.getNewValue());
    }

    @FXML
    private void txtPhoneEdited(TableColumn.CellEditEvent<Person, String> event){
        event.getRowValue().setPhoneNr(event.getNewValue());
    }

    @FXML
    private void intDayEdited(TableColumn.CellEditEvent<Person, Integer> event) {
        if(org.openjfx.IntegerStringConverter.conversionSuccessful) {
            if(CheckIntegerInput.dayBoolean(event.getNewValue())) {
                event.getRowValue().setDay(event.getNewValue());
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Feil!");
                alert.setHeaderText("Ugyldig data!");
                alert.setContentText("Du må taste inn et gyldig tall!");
                alert.showAndWait();
                event.getRowValue().setDay(event.getOldValue());

            }
        }
        TVTable.refresh();
    }

    @FXML
    private void intMonthEdited(TableColumn.CellEditEvent<Person, Integer> event) {
        if(org.openjfx.IntegerStringConverter.conversionSuccessful) {
            if(CheckIntegerInput.MonthBoolean(event.getNewValue())) {
                event.getRowValue().setMonth(event.getNewValue());
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Feil!");
                alert.setHeaderText("Ugyldig data!");
                alert.setContentText("Du må taste inn et gyldig tall!");
                alert.showAndWait();
                event.getRowValue().setDay(event.getOldValue());
            }
        }
        TVTable.refresh();
    }

    @FXML
    private void intYearEdited(TableColumn.CellEditEvent<Person, Integer> event) {
        if(org.openjfx.IntegerStringConverter.conversionSuccessful){
            if(CheckIntegerInput.yearBoolean(event.getNewValue())) {
                event.getRowValue().setYear(event.getNewValue());
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Feil!");
                alert.setHeaderText("Ugyldig data!");
                alert.setContentText("Du må taste inn et gyldig tall!");
                alert.showAndWait();
                event.getRowValue().setDay(event.getOldValue());
            }
        }
        TVTable.refresh();
    }

    @FXML
    private ChoiceBox<String> chkbxSearch;


    @FXML
    private TextField txtSearch;

    @FXML
    void btnSearch(javafx.event.ActionEvent event) {

        String chcbxValue = chkbxSearch.getValue();

        if(chcbxValue == null){
            lblErrChcbx.setText("Choose type of search.");
        } else if(chcbxValue.equals("Name")){
            List<Person> list = peopleList.stream().filter(i -> i.getName().equals(txtSearch.getText())).
                    collect(Collectors.toCollection(FXCollections::observableArrayList));
            TVTable.setItems((ObservableList<Person>) list);
            TVTable.refresh();
        } else if(chcbxValue.equals("Email")){
            List<Person> list = peopleList.stream().filter(i -> i.getEMail().equals(txtSearch.getText())).
                    collect(Collectors.toCollection(FXCollections::observableArrayList));
            TVTable.setItems((ObservableList<Person>) list);
            TVTable.refresh();
        } else if(chcbxValue.equals("Phone")){
            List<Person> list = peopleList.stream().filter(i -> i.getPhoneNr().equals(txtSearch.getText())).
                    collect(Collectors.toCollection(FXCollections::observableArrayList));
            TVTable.setItems((ObservableList<Person>) list);
            TVTable.refresh();
        } else if(chcbxValue.equals("Day")){
            try {
                int inSearch = Integer.parseInt(txtSearch.getText());
                List<Person> list = peopleList.stream().filter(i -> i.getDay() == inSearch).
                        collect(Collectors.toCollection(FXCollections::observableArrayList));
                TVTable.setItems((ObservableList<Person>) list);
                TVTable.refresh();
            } catch (NumberFormatException e){
                System.out.println(e.getMessage());
            }

        } else if(chcbxValue.equals("Month")){
            try {
                int inSearch = Integer.parseInt(txtSearch.getText());
                List<Person> list = peopleList.stream().filter(i -> i.getMonth() == inSearch).
                        collect(Collectors.toCollection(FXCollections::observableArrayList));
                TVTable.setItems((ObservableList<Person>) list);
                TVTable.refresh();
            } catch (NumberFormatException e){
                System.out.println(e.getMessage());
            }
        } else if(chcbxValue.equals("Year")){
            try {
                int inSearch = Integer.parseInt(txtSearch.getText());
                List<Person> list = peopleList.stream().filter(i -> i.getYear() == inSearch).
                        collect(Collectors.toCollection(FXCollections::observableArrayList));
                TVTable.setItems((ObservableList<Person>) list);
                TVTable.refresh();
            } catch (NumberFormatException e){
                System.out.println(e.getMessage());
            }
        }

    }

    @FXML
    public void btnRegister(javafx.event.ActionEvent aactionEvent) {


        //Avvikshåndtering
        successful = true;
        dateError = false;
        //String Exception
        //Name
        try {
            name = CheckStringInput.name(txtName.getText());
            lblErrName.setText("");
        } catch (InvalidStringException e){
            successful = false;
            lblErrName.setText(e.getMessage());
        }
        //Email
        try {
            eMail = CheckStringInput.eMail(txtEmail.getText());
            lblErrEmail.setText("");
        } catch (InvalidStringException e){
            successful = false;
            lblErrEmail.setText(e.getMessage());
        }
        //Phone number
        try {
            phoneNr = CheckStringInput.phoneNr(txtPhoneNr.getText());
            lblErrPhoneNr.setText("");
        } catch (InvalidStringException e){
            successful = false;
            lblErrPhoneNr.setText(e.getMessage());
        }


        //Integer Exception
        //Day
        try{
            inDay = Integer.parseInt(txtDay.getText());
            day = CheckIntegerInput.day(inDay);
        } catch (InvalidDateException e){
            dateError = true;
        }
        //Month
        try{
            inMonth = Integer.parseInt(txtMonth.getText());
            month = CheckIntegerInput.month(inMonth);
        } catch (InvalidDateException e){
            dateError = true;
        }
        //Year
        try{
            inYear = Integer.parseInt(txtYear.getText());
            year = CheckIntegerInput.year(inYear);
        } catch (InvalidDateException e){
            dateError = true;
        }
        // Oppretter feilmelding for dato.
        if(dateError){
            lblErrDate.setText("Invalid birthdate.");
            successful = false;
        } else {
            lblErrDate.setText("");
        }

        //Filbehandling
        // Oppretter person og legger inn i registeret.
        Person enPerson = new Person(name, eMail, phoneNr, day, month, year);
        if(successful) {
            register.registrerPerson(enPerson);
        }

        //Forsøker å skrive fra personRegister til tekstfil.
        try {
            WritePerson.writeFile(register.personRegister, path);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        //TableView
        //Forsøker å lese personer fra tekstfil til TableView.

        try {
            peopleList = (ObservableList<Person>) ReadPerson.load(path);
            System.out.println(PersonFormater.formatPeople(peopleList));
                TVTable.setItems(peopleList);
        } catch(IOException e){
            System.err.println(e.getMessage());
        }

        //Kode for å gjøre endringer direkte i TableView
        TVDay.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        TVMonth.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        TVYear.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));

        //Filtrering
    }

}
        /*

        /*

        */

        /*
        // Lager String av arrayet og printer det i Register.
        String ut = "";
        for(Person enPers : register.personRegister){
            ut += enPers+"\n";
        }
        lblRegister.setText(ut);
        */