package com.example.pr6;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import pr3.MedPolis;
import pr3.PropPolis;

import java.net.URL;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ResourceBundle;


public class HelloController implements Initializable {
    static String[] surnames = {"Lushin","Repin","Fedyakok","Obrazcov","Belkov","Berlykov","Burets","Vakilov","Vlasenko"};
    static String[] compNames = {"SoGaz","RosGos","VTB","SBER"};
    static String[] propType = {"Flat","Single-Family","Condomonium","Apartment","Co-Op"};
    ArrayList<PropPolis> polisArray = new ArrayList<>();
    LinkedList<MedPolis> polisArray1 = new LinkedList<>();
    int n=100000;

    @FXML
    public Label myLabel;
    @FXML
    public RadioButton ArrayListRadio;
    @FXML
    public RadioButton LinkedListRadio;
    @FXML
    public boolean alreadyInit = false;
    @FXML
    public ChoiceBox<String> choiceBox;
    private String[] options = {"CreateList","DeleteElement","Calculate"};
    ToggleGroup group = new ToggleGroup();

    private void createLinkedList(){
        long startCrTimeArrList = System.currentTimeMillis();
        for(int i=0;i<n;i++)
        {
            if(i<=n/2) polisArray1.add(new MedPolis((int)(Math.round(Math.random()*200000+100000)),
                    surnames[(int)Math.round(Math.random()*8)],
                    compNames[(int)Math.round(Math.random()*3)]));
        }
        long crTimeArrList = System.currentTimeMillis() - startCrTimeArrList;
        myLabel.setText("Create time: " + crTimeArrList);
    }
    private void deleteElemfromLinkedList(){
        String searchSurname = "Lushin";
        long startDeleteTimeArrList = System.currentTimeMillis();
        Iterator<MedPolis> polisIterator = polisArray1.iterator();
        while(polisIterator.hasNext()){
            MedPolis temp = polisIterator.next();
            if(temp.getHolderSurname().equals(searchSurname))
            {
                polisIterator.remove();
            }
        }
        long deleteTimeArrList = System.currentTimeMillis() - startDeleteTimeArrList;
        myLabel.setText("Delete time: " + deleteTimeArrList);
    }
    private void calculateLinkedList(){
        int qntSrchSurnames = 0;
        String searchSurname = "Lushin";
        long startCalcTimeArrList = System.currentTimeMillis();
        for (MedPolis el : polisArray1)
        {
            if (el.getHolderSurname().equals(searchSurname)) qntSrchSurnames++;
        }
        long calcTimeArrList = System.currentTimeMillis() - startCalcTimeArrList;
        myLabel.setText("Calc result: " + qntSrchSurnames + "\n" + "Calc time: " + calcTimeArrList);
    }
    private void createArrayList(){
        long startCrTimeArrList = System.currentTimeMillis();
        for(int i=0;i<n;i++)
        {
            polisArray.add(new PropPolis((int)(Math.round(Math.random()*200000+100000)),
                    surnames[(int)Math.round(Math.random()*8)],
                    propType[(int)Math.round(Math.random()*4)]));
        }
        long crTimeArrList = System.currentTimeMillis() - startCrTimeArrList;
        myLabel.setText("Create time: " + crTimeArrList);
    }
    private void calculateElemFromArrayList(){
        int qntSrchSurnames = 0;
        String searchSurname = "Lushin";
        long startCalcTimeArrList = System.currentTimeMillis();
        for (PropPolis el : polisArray)
        {
            if (el.getHolderSurname().equals(searchSurname)) qntSrchSurnames++;
        }
        long calcTimeArrList = System.currentTimeMillis() - startCalcTimeArrList;
        myLabel.setText("Calc result: " + qntSrchSurnames + "\n" + "Calc time: " + calcTimeArrList);
    }
    private void deleteArrayList(){
        String searchSurname = "Lushin";
        long startDeleteTimeArrList = System.currentTimeMillis();
        polisArray.removeIf(temp -> temp.getHolderSurname().equals(searchSurname));
        long deleteTimeArrList = System.currentTimeMillis() - startDeleteTimeArrList;
        myLabel.setText("Delete time: " + deleteTimeArrList);
    }

    public void calcButtonOn(ActionEvent e){
        if (ArrayListRadio.isSelected()){
            if (choiceBox.getValue().equals(options[0])){
                createArrayList();
            }
            else if (choiceBox.getValue().equals(options[1])){
                deleteArrayList();
            }
            else if (choiceBox.getValue().equals(options[2])){
                calculateElemFromArrayList();
            }
        }
        else if (LinkedListRadio.isSelected()){
            if (choiceBox.getValue().equals(options[0])){
                createLinkedList();
            }
            if (choiceBox.getValue().equals(options[1])){
                deleteElemfromLinkedList();
            }
            if (choiceBox.getValue().equals(options[2])){
                calculateLinkedList();
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        choiceBox.getItems().addAll(options);
    }
}