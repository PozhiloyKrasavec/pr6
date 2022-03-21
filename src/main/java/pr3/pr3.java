package pr3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class pr3 {
    static String[] surnames = {"Lushin","Repin","Fedyakok","Obrazcov","Belkov","Berlykov","Burets","Vakilov","Vlasenko"};
    static String[] compNames = {"SoGaz","RosGos","VTB","SBER"};
    static String[] propType = {"Flat","Single-Family","Condomonium","Apartment","Co-Op"};
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 100000;
        ArrayList<PropPolis> polisArray = new ArrayList<>();
        System.out.println("Menu: 1 - create List, 2 - search element, 3 - delete element, 4 - calculate, 5 - exit ");
        int menuCommand = scanner.nextInt();
        while(menuCommand!=5){
            switch (menuCommand){
                case 1:{
                    long startCrTimeArrList = System.currentTimeMillis();
                    for(int i=0;i<n;i++)
                    {
                        polisArray.add(new PropPolis((int)(Math.round(Math.random()*200000+100000)),
                                surnames[(int)Math.round(Math.random()*8)],
                                propType[(int)Math.round(Math.random()*4)]));
                    }
                    long crTimeArrList = System.currentTimeMillis() - startCrTimeArrList;
                    System.out.println("List create time: " + crTimeArrList);
                    break;
                }
                case 2:{
                    System.out.println("Enter a searching surname");
                    scanner.nextLine();
                    String searchSurname = scanner.nextLine();
                    long startSearchTimeArrList = System.currentTimeMillis();
                    for (PropPolis el : polisArray)
                    {
                       if (el.getHolderSurname().equals(searchSurname))
                           System.out.println("Find:\t" + el.getHolderSurname()+"\t" + el.getPropType());
                    }
                    long searchTimeArrList = System.currentTimeMillis() - startSearchTimeArrList;
                    System.out.println("Search time: " + searchTimeArrList);
                    break;
                }
                case 3:{
                    System.out.println("Enter a searching surname");
                    scanner.nextLine();
                    String searchSurname = scanner.nextLine();
                    long startDeleteTimeArrList = System.currentTimeMillis();
                    Iterator<PropPolis> polisIterator = polisArray.iterator();
                    while(polisIterator.hasNext()){
                        PropPolis temp = polisIterator.next();
                        if(temp.getHolderSurname().equals(searchSurname))
                        {
                            System.out.println("Delete:\t" + temp.getHolderSurname() + "\t" + temp.getPropType());
                            polisIterator.remove();
                        }
                    }
                    long deleteTimeArrList = System.currentTimeMillis() - startDeleteTimeArrList;
                    System.out.println("Delete time: " + deleteTimeArrList);
                    break;
                }
                case 4:{
                    System.out.println("Enter a searching surname");
                    int qntSrchSurnames = 0;
                    scanner.nextLine();
                    String searchSurname = scanner.nextLine();
                    long startCalcTimeArrList = System.currentTimeMillis();
                    for (PropPolis el : polisArray)
                    {
                        if (el.getHolderSurname().equals(searchSurname)) qntSrchSurnames++;
                    }
                    long calcTimeArrList = System.currentTimeMillis() - startCalcTimeArrList;
                    System.out.println("Calc result: " + qntSrchSurnames);
                    System.out.println("Calc time: " + calcTimeArrList);
                    break;
                }
            }
            System.out.println("Menu: 1 - create List, 2 - search element, 3 - delete element, 4 - calculate, 5 - exit ");
            menuCommand = scanner.nextInt();
        }
    }
}
