package org.openjfx;

import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class PrimaryController {

    private String name, eMail, phoneNr;
    private int inDay, inMonth, inYear, day, month, year;
    private boolean successful, dateError;
    private Register register = new Register();
    private Path path = Paths.get("PersonRegister.txt");


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
    public void btnRegister(javafx.event.ActionEvent actionEvent) {

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

        //Forsøker å lese personer fra tekstfil.
        try {
            ObservableList<Person> peopleList = (ObservableList<Person>) ReadPerson.load(path);
            System.out.println(PersonFormater.formatPeople(peopleList));
            TVTable.setItems(peopleList);
        } catch(IOException e){
            System.err.println(e.getMessage());
        }

        //Forsøker å skrive personer til TableView.




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