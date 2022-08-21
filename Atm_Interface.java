//Vaishnavi Shankar Shinde
//Java programming
//Task-3:ATM Interface

import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Atm_Interface{
	 
	String password="Vaish@123";
    String act_no="123456abc";
    float balance=1000f;
    int trans=0;
    String transHis="";
    String userID="VaishnaviS";   //UserName   
    DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
	LocalDateTime now =LocalDateTime.now();

    Scanner sc=new Scanner(System.in);

    public boolean login(){
        boolean isLogin=false;
        while(!isLogin){
            System.out.println("\nEnter username : ");
            String user=sc.nextLine();
            if (user.equals(userID)){
                System.out.println("Enter password : ");
                String pd=sc.nextLine();
                while(!isLogin){
                    if(pd.equals(password)){
                        System.out.println("Login Successfully.....");
                        isLogin=true;
                    }
                    else{
                        System.out.println("Invalid login!!!!!!!!");
                        break;
                    }
                }
            }
            else{
                System.out.println("Username not found...");
            }
        }
        return isLogin;
    }
    
    public void deposit(){
        System.out.println("\nEnter Amount to be deposited : ");
        float dMoney=sc.nextFloat();     //get deposite amount from User
        try{
            if(dMoney<=100000f){
                balance+=dMoney;
                trans+=1;
                System.out.println("Successfully deposited Rs. "+dMoney+" at "+dtf.format(now));
                String str="Rs "+dMoney+" deposited at "+dtf.format(now)+" .\n";
                transHis=transHis.concat(str);
            }
            else{
                System.out.println("Sorry!Not capable to deposit amount more than 100000.00");
            }
        }
        catch(Exception e){
        }
    }
    
    public void withdraw(){
        System.out.println("\nEnter Amount to be withdrawn : ");
        float wd_money=sc.nextFloat();
        try{
            if (wd_money<=balance){
            	balance-=wd_money;
                trans+=1;
                System.out.println("Successfully withdrawn Rs. "+wd_money+" at "+dtf.format(now));
                System.out.println("Please collect your money...");
                String str="Rs "+wd_money+" withdrawn at "+dtf.format(now)+" .\n";
                transHis=transHis.concat(str);
            }
            else{
                System.out.println("Sorry! Insufficient Balance...");
            }
        }
        catch(Exception e){
        }
    }
    
    public void transferAmount(){
    	Scanner in=new Scanner(System.in);
        System.out.println("\nEnter the username to transfer amount: ");
        String user_name=in.nextLine();
        System.out.println("Enter the amount to transfer :");
        float transamount=sc.nextFloat();
        try{
            if (transamount<=balance){
            	balance-=transamount;
                trans+=1;
                System.out.println("Successfully transferred Rs. "+transamount+" at "+dtf.format(now));
                String str="Rs "+transamount+" transferred to "+user_name+" account at "+dtf.format(now)+" .\n";
                transHis=transHis.concat(str);
            }
            else{
                System.out.println("Can not transfer money.Insufficient amount to transfer!");
            }
        }   
        catch(Exception e){
        }
    }
    public void transactionHistory(){
        if(trans==0){
            System.out.println("\nNo Transactions");
        }
        else{
            System.out.println("\n"+transHis);
        }
    }
    
    public void checkBalance(){
        System.out.println("\nYour Balance is : "+balance);
    }
	
    public static void main(String args[]){
        System.out.println("************Welcome to ATM************");
        
        Atm_Interface Atm=new Atm_Interface();
            
                System.out.print("\n\nChoose any one option 1 or 2:");
                System.out.print("\n1.LOGIN\n2.EXIT\n");
                System.out.print("\nEnter here :");
                Scanner s1=new Scanner(System.in);
                int ch=s1.nextInt();
                if (ch==1){
                    if(Atm.login()){
                        boolean isFin=false;
                        while(!isFin){
                            System.out.println("\nSelect any option : ");
                            System.out.println("\n1.CHECK BALANCE\n2.DEPOSIT\n3.WITHDRAW\n4.TRANSFER\n5.TRANSACTION HISTORY\n6.CANCEL");
                            System.out.println("Enter Your Choice :");
                            int choice=s1.nextInt();
                            switch(choice){
                                case 1 : Atm.checkBalance();
                                         break;
                                case 2 : Atm.deposit();
                                         break;
                                case 3 : Atm.withdraw();
                                         break;
                                case 4 : Atm.transferAmount();
                                         break;
                                case 5 : Atm.transactionHistory();
                                         break;
                                case 6 : isFin=true;
                                         break;
                                default: System.out.println("Invalid Option...");
                            }
                        }
                    }
                }
                else{
                    
                    System.out.print("Please Collect Your Card. Thank you...");
                    System.exit(0);
                }
                
                System.out.print("Please Collect Your Card. Thank you...");
                System.exit(0);
    }
}