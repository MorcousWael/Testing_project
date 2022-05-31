package controllers;

import classes.Items;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import classes.Transactions;
import classes.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class HelloController implements Initializable {


    public Label HelloLabel;
    public TextField amountTr;
    public TextField cdN;
    @FXML
    private TableView<Transactions> TransactionTable;
    @FXML
    private TableColumn<Transactions, Integer> Tnumm;

    @FXML
    private TableColumn<Transactions, String> User1Col;

    @FXML
    private TableColumn<Transactions, String> Type;

    @FXML
    private TableColumn<Transactions, String> User2Col;
    @FXML
    private TableColumn<Transactions, Integer> Amount;


    private Stage stage;
    private Scene scene;
    private Parent root;
    public static   User x;
    private List<Transactions> table=new ArrayList<>() ;
    //copy
    public void TransactionTableView(ObservableList<Transactions> table) {
        TransactionTable.getItems().clear();
        Tnumm.setCellValueFactory(new PropertyValueFactory<Transactions,Integer>("Tnum"));
        User1Col.setCellValueFactory(new PropertyValueFactory<Transactions,String>("firstName"));
        Type.setCellValueFactory(new PropertyValueFactory<Transactions,String>("Type"));
        User2Col.setCellValueFactory(new PropertyValueFactory<Transactions,String>("secondName"));
        Amount.setCellValueFactory(new PropertyValueFactory<Transactions,Integer>("amount"));
        TransactionTable.setItems(table);
    }
    public void switchToBuyItems(ActionEvent event) throws IOException {

        long startTime3 = System.currentTimeMillis();

        root = FXMLLoader.load(getClass().getResource("../fxml_fill/BuyItemsPage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        long stopTime3 = System.currentTimeMillis();
        long reactiontTime3 = stopTime3 - startTime3;
        System.out.println("The load time of switching to Buy Items is " + reactiontTime3 + " ms");

    }
    public void switchToTransfer(ActionEvent event) throws IOException {

        long startTime4 = System.currentTimeMillis();

        Parent root = FXMLLoader.load(getClass().getResource("../fxml_fill/TransferPage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        long stopTime4 = System.currentTimeMillis();
        long reactiontTime4 = stopTime4 - startTime4;
        System.out.println("The load time of switching to Transfer is " + reactiontTime4 + " ms");
    }
    public void switchToPayBills(ActionEvent event) throws IOException {

        long startTime5 = System.currentTimeMillis();

        Parent root = FXMLLoader.load(getClass().getResource("../fxml_fill/PayBillPage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        long stopTime5 = System.currentTimeMillis();
        long reactiontTime5 = stopTime5 - startTime5;
        System.out.println("The load time of switching to PayBills is " + reactiontTime5 + " ms");
    }
    public void initialize (URL url, ResourceBundle resourceBundle)  {
        try {
            Transactions Y=new Transactions();
            Y.setFirstName(x.getName());
            TransactionTableView(FXCollections.observableList(Y.ShowRecords()));
        }
        catch (Exception e) {
            System.out.println(" ");
        }
    }
    public void switchToStatement(ActionEvent event) throws IOException {

        long startTime6 = System.currentTimeMillis();

        Parent root = FXMLLoader.load(getClass().getResource("../fxml_fill/StatementPage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        long stopTime6 = System.currentTimeMillis();
        long reactiontTime6 = stopTime6 - startTime6;
        System.out.println("The load time of switching to Statement is " + reactiontTime6 + " ms");



    }
    public void switchToMainPage(ActionEvent event) throws IOException {
        long startTime7 = System.currentTimeMillis();

        Parent root = FXMLLoader.load(getClass().getResource("../fxml_fill/MainPage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        long stopTime7 = System.currentTimeMillis();
        long reactiontTime7 = stopTime7 - startTime7;
        System.out.println("The load time of switching to Home Page is " + reactiontTime7 + " ms");
    }

        public void Buymac(ActionEvent a) {
            long startTime7 = System.currentTimeMillis();
            try {
            int amount= Items.getPrice("Mackbook");
            if (x.getBalance() <amount) throw new ArithmeticException();
            else {
                Transactions.TransferBank(x,amount);
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Congratulations");
                alert.setContentText("Item bought successfully");
                alert.show();
                long stopTime7 = System.currentTimeMillis();
                long reactiontTime7 = stopTime7 - startTime7;
                System.out.println("The load time of Buying mac button is " + reactiontTime7 + " ms");
            }
        }
        catch (ArithmeticException | SQLException al) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Insufficient Funds");
            alert.setContentText("Check Balance");
            alert.show();
        }
    }
        public void Buyiphone(ActionEvent a){
            long startTime7 = System.currentTimeMillis();

            try {
                int amount= Items.getPrice("Iphone");
                if (x.getBalance() <amount) throw new ArithmeticException();
                else {
                    Transactions.TransferBank(x,amount);
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Congratulations");
                    alert.setContentText("Item bought successfully");
                    alert.show();
                    long stopTime7 = System.currentTimeMillis();
                    long reactiontTime7 = stopTime7 - startTime7;
                    System.out.println("The load time of Buying iphone button is " + reactiontTime7 + " ms");
                }
            }
            catch (ArithmeticException | SQLException al) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Insufficient Funds");
                alert.setContentText("Check Balance");
                alert.show();
            }
        }
        public void BuyPS5(ActionEvent a){
            long startTime7 = System.currentTimeMillis();
            try {
                int amount= Items.getPrice("Ps5");
                if (x.getBalance() <amount) throw new ArithmeticException();
                else {
                    Transactions.TransferBank(x,amount);
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Congratulations");
                    alert.setContentText("Item bought successfully");
                    alert.show();
                    long stopTime7 = System.currentTimeMillis();
                    long reactiontTime7 = stopTime7 - startTime7;
                    System.out.println("The load time of Buying PS5 button is " + reactiontTime7 + " ms");

                }
            }
            catch (ArithmeticException | SQLException al) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Insufficient Funds");
                alert.setContentText("Check Balance");
                alert.show();
            }

    }
        public void BuyTv(ActionEvent a){
            long startTime7 = System.currentTimeMillis();
            try {
            int amount= Items.getPrice("Apple Tv");
            if (x.getBalance() <amount) throw new ArithmeticException();
            else {
                Transactions.TransferBank(x,amount);
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Congratulations");
                alert.setContentText("Item bought successfully");
                alert.show();
                long stopTime7 = System.currentTimeMillis();
                long reactiontTime7 = stopTime7 - startTime7;
                System.out.println("The load time of Buying TV button is " + reactiontTime7 + " ms");
            }
        }
        catch (ArithmeticException | SQLException al) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Insufficient Funds");
            alert.setContentText("Check Balance");
            alert.show();
        }
    }

        public int gRand(){
        Random rand = new Random();
        int n = rand.nextInt(1000);
        return n;
    }
        public void PayLoans(ActionEvent a){
            long startTime8 = System.currentTimeMillis();

            int am=gRand();
                try
        {if (x.getBalance() <am) throw new ArithmeticException();
        else {
            Transactions.TransferBill(x,am,"pay Loan");
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("pay");
            alert.setContentText("please pay "+ am+"EGP");
            alert.show();
            long stopTime8 = System.currentTimeMillis();
            long reactiontTime8 = stopTime8 - startTime8;
            System.out.println("The load time of Paying Loans is " + reactiontTime8 + " ms");
        }
        }
        catch (ArithmeticException | SQLException al) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("insufficient fund");
            alert.setContentText("to Pay "+am+" EGP");
            alert.show();

            long stopTime8 = System.currentTimeMillis();
            long reactiontTime8 = stopTime8 - startTime8;
            System.out.println("The load time of Paying Loans if there are insufficient fund is " + reactiontTime8 + " ms");
        }
    }
        public void PayGas(ActionEvent a){
            long startTime9 = System.currentTimeMillis();
            int am=gRand();
            try
            {if (x.getBalance() <am) throw new ArithmeticException();
            else {
                Transactions.TransferBill(x,am,"pay Gas");
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("pay");
                alert.setContentText("please pay "+ am+"EGP");
                alert.show();
                long stopTime9 = System.currentTimeMillis();
                long reactiontTime9 = stopTime9 - startTime9;
                System.out.println("The load time of Paying Gas is " + reactiontTime9 + " ms");
            }
            }
            catch (ArithmeticException | SQLException al) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("insufficient fund");
                alert.setContentText("to Pay "+am+" EGP");
                alert.show();
            }
    }
        public void PayTrans(ActionEvent a){
            long startTime9 = System.currentTimeMillis();
            int am=gRand();
            try
            {if (x.getBalance() <am) throw new ArithmeticException();
            else {
                Transactions.TransferBill(x,am,"pay Transportations");
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("pay");
                alert.setContentText("please pay "+ am+"EGP");
                alert.show();
                long stopTime9 = System.currentTimeMillis();
                long reactiontTime9 = stopTime9 - startTime9;
                System.out.println("The load time of Paying Transportation is " + reactiontTime9 + " ms");
            }
            }
            catch (ArithmeticException | SQLException al) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("insufficient fund");
                alert.setContentText("to Pay "+am+" EGP");
                alert.show();
            }
    }
        public void PayWater(ActionEvent a){
            long startTime9 = System.currentTimeMillis();
            int am=gRand();
            try
            {if (x.getBalance() <am) throw new ArithmeticException();
            else {
                Transactions.TransferBill(x,am,"pay Water");
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("pay");
                alert.setContentText("please pay "+ am+"EGP");
                alert.show();
                long stopTime9 = System.currentTimeMillis();
                long reactiontTime9 = stopTime9 - startTime9;
                System.out.println("The load time of Paying Water is " + reactiontTime9 + " ms");
            }
            }
            catch (ArithmeticException | SQLException al) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("insufficient fund");
                alert.setContentText("to Pay "+am+" EGP");
                alert.show();
            }
}
        public void PayElectric(ActionEvent a){
            long startTime9 = System.currentTimeMillis();
            int am=gRand();
        try
        {if (x.getBalance() <am) throw new ArithmeticException();
        else {
            Transactions.TransferBill(x,am,"pay Electricity");
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("pay");
            alert.setContentText("please pay "+ am+"EGP");
            alert.show();
            long stopTime9 = System.currentTimeMillis();
            long reactiontTime9 = stopTime9 - startTime9;
            System.out.println("The load time of Paying Electricity is " + reactiontTime9 + " ms");
        }
        }
        catch (ArithmeticException | SQLException al) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("insufficient fund");
            alert.setContentText("to Pay "+am+" EGP");
            alert.show();
        }
    }
        public void transferConfirm(ActionEvent a){
            try{
                User y =new User();
                y.EnterCardNumber(cdN.getText());
                int z=Integer.valueOf(amountTr.getText());
                Transactions.Transfer(x,y,z);
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("amount transfered Successfully");
                alert.setContentText("paid amount = "+amountTr.getText()+" EGP");
                alert.show();
            }
            catch (Exception E){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("insufficient fund");
                alert.setContentText("to Pay "+amountTr.getText()+" EGP");
                alert.show();
            }
        }
}