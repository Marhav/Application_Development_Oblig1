package org.openjfx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class PrimaryController implements Initializable {

    //Oppretter generelle attributter
    private String name, eMail, phoneNr;
    private int day, month, year;
    private Register register = new Register();
    private ObservableList<String> chkbxList = FXCollections.observableArrayList();
    private Path path = Paths.get("StartUpRegister.txt");

    ReadPersonTxt readTxt = new ReadPersonTxt();
    WritePersonTxt writeTxt = new WritePersonTxt();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Implementerer Choice Box
        chkbxList.removeAll(chkbxList);
        String chkbx1 = "Name";
        String chkbx2 = "Email";
        String chkbx3 = "Phone";
        String chkbx4 = "Day";
        String chkbx5 = "Month";
        String chkbx6 = "Year";
        chkbxList.addAll(chkbx1, chkbx2, chkbx3, chkbx4, chkbx5, chkbx6);
        chkbxSearch.getItems().addAll(chkbxList);
        //Kode for å laste inn register som var sist brukt.
        try {
            register.personRegister = (ObservableList<Person>) readTxt.load(path);
            TVTable.setItems(register.personRegister);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
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
    private void txtNameEdited(TableColumn.CellEditEvent<Person, String> event) {
        try{
            CheckStringInput.name(event.getNewValue());
            event.getRowValue().setName(event.getNewValue());
        } catch(InvalidStringException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Feil!");
            alert.setHeaderText("Ugyldig data!");
            alert.setContentText("Du må taste inn et gyldig navn!");
            alert.showAndWait();
            event.getRowValue().setName(event.getOldValue());
        }
        TVTable.refresh();
    }

    @FXML
    private void txtEMailEdited(TableColumn.CellEditEvent<Person, String> event) {
        try{
            CheckStringInput.eMail(event.getNewValue());
            event.getRowValue().seteMail(event.getNewValue());
        } catch(InvalidStringException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Feil!");
            alert.setHeaderText("Ugyldig data!");
            alert.setContentText("Du må taste inn et gyldig email!");
            alert.showAndWait();
            event.getRowValue().seteMail(event.getOldValue());
        }
        TVTable.refresh();
    }

    @FXML
    private void txtPhoneEdited(TableColumn.CellEditEvent<Person, String> event) {
        try{
            CheckStringInput.phoneNr(event.getNewValue());
            event.getRowValue().setPhoneNr(event.getNewValue());
        } catch(InvalidStringException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Feil!");
            alert.setHeaderText("Ugyldig data!");
            alert.setContentText("Du må taste inn et gyldig mobilnummer!");
            alert.showAndWait();
            event.getRowValue().setPhoneNr(event.getOldValue());
        }
        TVTable.refresh();
    }

    @FXML
    private void intDayEdited(TableColumn.CellEditEvent<Person, Integer> event) {
        //Kode for endringer direkte i tableView
        if (org.openjfx.IntegerStringConverter.conversionSuccessful) {
            if (CheckIntegerInput.dayBoolean(event.getNewValue())) {
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
        //Kode for endringer direkte i tableView
        if (org.openjfx.IntegerStringConverter.conversionSuccessful) {
            if (CheckIntegerInput.MonthBoolean(event.getNewValue())) {
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
        //Kode for endringer direkte i tableView
        if (org.openjfx.IntegerStringConverter.conversionSuccessful) {
            if (CheckIntegerInput.yearBoolean(event.getNewValue())) {
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

    //"C:\\Users\\Havnaas\\IdeaProjects\\Snake\\src\\AvvikOppgave\\RegisterFiler"

    @FXML
    void btnOpenFile(ActionEvent event) {
        //Kode for åpning av fil med filutforsker
        FileChooser openFile = new FileChooser();
        openFile.setTitle("Open Resource File");
        openFile.setInitialDirectory(new File(System.getProperty("user.dir")));
        openFile.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text File (.txt)", "*.txt"),
                new FileChooser.ExtensionFilter("Binary Java File (.jobj)", "*.jobj"));
        File selectedFile = openFile.showOpenDialog(new Stage());
        if (selectedFile != null) {
            ReadPerson opener = null;

            switch (FileExtension.get(selectedFile)) {
                case ".txt":
                    opener = new ReadPersonTxt();
                    break;
                case ".jobj":
                    opener = new ReadPersonJobj();
                    break;
                default:
                    System.err.println("Du kan bare åpne txt eller jobj filer.");
            }
            if (opener != null) {
                try {
                    register.personRegister = (ObservableList<Person>) opener.load(selectedFile.toPath());
                    TVTable.setItems(register.personRegister);
                    System.out.println("Registeret ble åpnet!");
                } catch (IOException e) {
                    System.err.println("Åpning av fil feilet. Grunn: " + e.getMessage());
                }
            }
        }
    }

    @FXML
    void btnSaveFile(javafx.event.ActionEvent event) {
        //Kode for lagring av fil med filutforsker
        FileChooser saveFile = new FileChooser();
        saveFile.setTitle("Open Resource File");
        saveFile.setInitialDirectory(new File("C:\\Users\\Havnaas\\IdeaProjects\\Snake\\src\\AvvikOppgave\\RegisterFiler"));
        saveFile.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text Files (.txt)", "*.txt"),
                new FileChooser.ExtensionFilter("Binary Java File (.jobj)", "*.jobj"));
        File selectedFile = saveFile.showSaveDialog(new Stage());
        if (selectedFile != null) {
            WritePerson saver = null;

            switch (FileExtension.get(selectedFile)) {
                case ".txt":
                    saver = new WritePersonTxt();
                    break;
                case ".jobj":
                    saver = new WritePersonJobj();
                    break;
                default:
                    System.err.println("Du kan bare lagre til enten txt eller jobj filer.");
            }
            if (saver != null) {
                try {
                    saver.writeFile(register.personRegister, selectedFile.toPath());
                    System.out.println("Registeret ble lagret!");
                } catch (IOException e) {
                    System.err.println("Lagring til fil feilet. Grunn: " + e.getMessage());
                }
            }
        }
    }

    @FXML
    void btnSearch(javafx.event.ActionEvent event) {
        //Kode for å søke i TableView, basert på choice box verdi.
        String chcbxValue = chkbxSearch.getValue();
        List<Person> list;
        try {
            switch (chcbxValue) {
                case "Name":
                    list = register.personRegister.stream().filter(i -> i.getName().toLowerCase().contains(txtSearch.getText().toLowerCase())).
                            collect(Collectors.toCollection(FXCollections::observableArrayList));
                    TVTable.setItems((ObservableList<Person>) list);
                    TVTable.refresh();
                    break;
                case "Email":
                    list = register.personRegister.stream().filter(i -> i.getEMail().toLowerCase().contains(txtSearch.getText().toLowerCase())).
                            collect(Collectors.toCollection(FXCollections::observableArrayList));
                    TVTable.setItems((ObservableList<Person>) list);
                    TVTable.refresh();
                    break;
                case "Phone":
                    list = register.personRegister.stream().filter(i -> i.getPhoneNr().toLowerCase().contains(txtSearch.getText().toLowerCase())).
                            collect(Collectors.toCollection(FXCollections::observableArrayList));
                    TVTable.setItems((ObservableList<Person>) list);
                    TVTable.refresh();
                    break;
                case "Day":
                    try {
                        int inSearch = Integer.parseInt(txtSearch.getText());
                        list = register.personRegister.stream().filter(i -> i.getDay() == inSearch).
                                collect(Collectors.toCollection(FXCollections::observableArrayList));
                        TVTable.setItems((ObservableList<Person>) list);
                        TVTable.refresh();
                    } catch (NumberFormatException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "Month":
                    try {
                        int inSearch = Integer.parseInt(txtSearch.getText());
                        list = register.personRegister.stream().filter(i -> i.getMonth() == inSearch).
                                collect(Collectors.toCollection(FXCollections::observableArrayList));
                        TVTable.setItems((ObservableList<Person>) list);
                        TVTable.refresh();
                    } catch (NumberFormatException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "Year":
                    try {
                        int inSearch = Integer.parseInt(txtSearch.getText());
                        list = register.personRegister.stream().filter(i -> i.getYear() == inSearch).
                                collect(Collectors.toCollection(FXCollections::observableArrayList));
                        TVTable.setItems((ObservableList<Person>) list);
                        TVTable.refresh();
                    } catch (NumberFormatException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    System.err.println("Choose type of search.");
            }
        } catch (NullPointerException e){
            lblErrChcbx.setText("Choose kategory for search.");
        }
    }

    @FXML
    public void btnRegister(javafx.event.ActionEvent event) {

        //Avvikshåndtering
        boolean successful = true;
        boolean dateError = false;
        //String Exception
        //Name
        try {
            name = CheckStringInput.name(txtName.getText());
            lblErrName.setText("");
        } catch (InvalidStringException e) {
            successful = false;
            lblErrName.setText(e.getMessage());
        }
        //Email
        try {
            eMail = CheckStringInput.eMail(txtEmail.getText());
            lblErrEmail.setText("");
        } catch (InvalidStringException e) {
            successful = false;
            lblErrEmail.setText(e.getMessage());
        }
        //Phone number
        try {
            phoneNr = CheckStringInput.phoneNr(txtPhoneNr.getText());
            lblErrPhoneNr.setText("");
        } catch (InvalidStringException e) {
            successful = false;
            lblErrPhoneNr.setText(e.getMessage());
        }


        //Integer Exception
        //Day
        try {
            int inDay = Integer.parseInt(txtDay.getText());
            day = CheckIntegerInput.day(inDay);
        } catch (InvalidDateException e) {
            dateError = true;
            System.err.println(e.getMessage());
        }
        //Month
        try {
            int inMonth = Integer.parseInt(txtMonth.getText());
            month = CheckIntegerInput.month(inMonth);
        } catch (InvalidDateException e) {
            dateError = true;
            System.err.println(e.getMessage());
        }
        //Year
        try {
            int inYear = Integer.parseInt(txtYear.getText());
            year = CheckIntegerInput.year(inYear);
        } catch (InvalidDateException e) {
            dateError = true;
            System.err.println(e.getMessage());
        }
        // Oppretter feilmelding for dato.
        if (dateError) {
            lblErrDate.setText("Invalid birthdate.");
            successful = false;
        } else {
            lblErrDate.setText("");
        }

        //Filbehandling
        // Oppretter person og legger inn i registeret.
        Person enPerson = new Person(name, eMail, phoneNr, day, month, year);
        if (successful) {
            register.registrerPerson(enPerson);
        }

        //Forsøker å skrive fra personRegister til startUp tekstfil.
        try {
            writeTxt.writeFile(register.personRegister, path);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        //TableView
        //Forsøker å lese personer fra startUp tekstfil til TableView.
        try {
            register.personRegister = (ObservableList<Person>) readTxt.load(path);
            System.out.println(PersonFormater.formatPeople(register.personRegister));
            TVTable.setItems(register.personRegister);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        //Kode for å gjøre endringer direkte i TableView
        TVDay.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        TVMonth.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        TVYear.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
    }
}