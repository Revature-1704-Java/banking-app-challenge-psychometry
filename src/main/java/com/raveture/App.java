package com.raveture;
import java.util.HashMap;
import java.util.Scanner;
public class App 
{
    static enum command{
        Add, Deposit, Withdraw, Quit
    }
    static HashMap<Integer, User> bank = new HashMap<>();
    public static void main( String[] args )
    {
        Scanner sc=new Scanner(System.in);
        boolean end=false;
        while(!end){
            System.out.println("ConsoleBank" );
            if(bank.size()==0){
                System.out.println("would you join as a new user? y/n");
                String userChoice=sc.nextLine();
                while(userChoice!="y" && userChoice!="x"){
                    System.out.println("invalid command, please enter y or n");
                    userChoice=sc.nextLine();
                }
                end=userChoice.equals("n");
                if(userChoice.equals("y")){
                    User newUser = createUser(sc);
                    bank.put(newUser.getId(), newUser);
                    System.out.println("Welcome to ConsoleBank, "+newUser.getName()+". ");
                    System.out.println("Remember your User Id: "+ newUser.getId());
                }
            }
            System.out.println("Enter your User Id: ");
            int userChoice=sc.nextInt();
            User usr= bank.get(userChoice);
            System.out.println("Welcome " + usr.getName()+"!");
            System.out.println("What would you like to do?");
            for(command c: command.values()){
                System.out.print(c +" ");
            }
            System.out.println();

            String cmd=sc.nextLine();

            switch (command.valueOf(cmd)) {
                case Add:
                    openNewAccount(usr);
                    break;
                case Deposit:
                    depositCash(usr,sc);
                    break;
                case Withdraw:
                    withdrawCash(usr,sc);
                    break;
                case Quit:
                    end=true;
                    break;
                default:
                    break;
            }
            
        }
        System.out.println("Thank you for using ConsoleBank");
    }
    public static void withdrawCash(User usr, Scanner sc) {
        if(usr.getNumAccounts()==0){
            System.out.println("You do not have an account.");
        }else{
            System.out.println("Enter the account id for your withdraw");
            int id=sc.nextInt();
            System.out.println("Enter the amount you'd like to withdraw:");
            int amount=sc.nextInt();
            usr.getAccount(id).addTransaction(new Transaction(-amount));
            System.out.println("You now have "+ usr.getAccount(id).getBalance()+" in account: "+ id); 
        }
	}
	public static void depositCash(User usr, Scanner sc) {
        if(usr.getNumAccounts()==0){
            System.out.println("You do not have an account.");
        }else{
            System.out.println("Enter the account id for your deposit");
            int id=sc.nextInt();
            System.out.println("Enter the amount you'd like to deposit:");
            int amount=sc.nextInt();
            usr.getAccount(id).addTransaction(new Transaction(amount));
            System.out.println("You now have "+ usr.getAccount(id).getBalance()+" in account: "+ id); 
        }
	}
	public static void openNewAccount(User usr) {
        int accountId=usr.addAccount();
        System.out.println("you created a new account, id:"+ accountId);
	}
	public static User createUser(Scanner sc) {
        System.out.println("please enter your name: ");
        String name=sc.nextLine();
        return new User(name);
    }
}
