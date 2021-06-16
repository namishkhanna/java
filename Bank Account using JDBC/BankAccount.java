import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class BankAccount {
	
	public static void getDataCount(Connection con) throws SQLException {
		Statement st = con.createStatement();

		ResultSet rs = st.executeQuery("select count(*) from bankaccount");

		while(rs.next())
		{
			System.out.println("Total Number of Accounts in Bank: " + rs.getInt(1));
		}
		
		rs.close();
	}
	
	public static void getAllData(Connection con) throws SQLException {
		Statement st = con.createStatement();

		ResultSet rs = st.executeQuery("select * from bankaccount");

		System.out.println("AccNo.  Name    Balance  Age");
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+"    "+rs.getString(2)+"   "+rs.getInt(3)+"    "+rs.getInt(4));
		}

		rs.close();
	}
	
	public static void getParticularData(Connection con, int paccno) throws SQLException {
		PreparedStatement pst = con.prepareStatement("select * from bankaccount where accountnumber=?");
		
		pst.setInt(1, paccno);
		
		ResultSet rs = pst.executeQuery();
		
		System.out.println("AccNo.  Name    Balance  Age");
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+"    "+rs.getString(2)+"   "+rs.getInt(3)+"    "+rs.getInt(4));
		}
		
		rs.close();
		pst.clearParameters();
	}
	
	public static void getNameBalance(Connection con) throws SQLException {
		Statement st = con.createStatement();

		ResultSet rs = st.executeQuery("select name,balance from bankaccount");

		System.out.println("Name    Balance");
		while(rs.next())
		{
			System.out.println(rs.getString(1)+"   "+rs.getInt(2));
		}

		rs.close();
	}
	
	public static void addAccount(Connection con, int anum, String name, int bal, int age) throws SQLException {

		PreparedStatement pst= con.prepareStatement("Insert into bankaccount values(?,?,?,?)");
		
		pst.setInt(1, anum);
		pst.setString(2, name);
		pst.setInt(3, bal);
		pst.setInt(4, age);
		
		int p = pst.executeUpdate();		
		System.out.println(p + " Account Added Successfully ");
		
		pst.clearParameters();
	}
	
	public static void depositAmount(Connection con, int depanum, int depamount) throws SQLException {

		CallableStatement stmt = con.prepareCall("{call depositamount(?,?)}");
		
		stmt.setInt(1, depanum);
		stmt.setInt(2, depamount);
		stmt.execute();  
		
		System.out.println(depamount + " Deposited Succefully to Account No.: " + depanum);
	}
	
	public static void withdrawAmount(Connection con, int wanum, int wamount) throws SQLException {

		CallableStatement stmt = con.prepareCall("{call withdrawamount(?,?)}");
		
		stmt.setInt(1, wanum);
		stmt.setInt(2, wamount);
		stmt.execute();  
		
		System.out.println(wamount + " Withdrawn Succefully from Account No.: " + wanum);
	}
	
	public static void removeAccount(Connection con, int rnum) throws SQLException {

		PreparedStatement pst= con.prepareStatement("delete from bankaccount where accountnumber=?");
		
		pst.setInt(1, rnum);
		pst.executeUpdate();		
		
		System.out.println(rnum + " Removed Successfully ");
		
		pst.clearParameters();
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		Connection con = DriverManager.getConnection(url, "sql_username","sql_password");
		System.out.println("Connected successfully .... ");
		
		Scanner myObj = new Scanner(System.in);
		int inp;
		boolean loop = true;
		
		while(loop) {
			System.out.println("\n-----------------------------------------------------------------------");
			System.out.println("\n**************** Java Bank ****************");
			System.out.println("Enter 1: Total no. of Account Holders");
			System.out.println("Enter 2: All Account Holders Details");
			System.out.println("Enter 3: Particular Account Holder Details");
			System.out.println("Enter 4: Name and Balance of All Account Holders");
			System.out.println("Enter 5: Add New Account Holder");
			System.out.println("Enter 6: Deposit Amount");
			System.out.println("Enter 7: Withdraw Amount");
			System.out.println("Enter 8: Remove Account Holder");
			System.out.println("Enter 0 to Exit");
			System.out.println("Enter your Choice: ");
			inp = myObj.nextInt();
			System.out.println("");
			
			switch(inp) {
				case 1:
					getDataCount(con);
					break;
					
				case 2:
					getAllData(con);
					break;
					
				case 3:
					System.out.println("\nEnter Account Number: ");
					int paccno = myObj.nextInt();
					getParticularData(con,paccno);
					break;
					
				case 4:
					getNameBalance(con);
					break;
					
				case 5:
					System.out.println("\nTo add Data please Fill Following Details...");
					System.out.println("Enter Account Number: ");
					int anum = myObj.nextInt();
					myObj.nextLine();
					
					System.out.println("Enter Name: ");
					String name = myObj.nextLine();
					
					System.out.println("Enter Amount to Deposit: ");
					int bal = myObj.nextInt();
					
					System.out.println("Enter Age: ");
					int age = myObj.nextInt();
					
					addAccount(con, anum, name, bal, age);
					break;
				
				case 6:
					System.out.println("Enter Account Number: ");
					int depanum = myObj.nextInt();
					
					System.out.println("Enter Amount to Deposit: ");
					int depamount = myObj.nextInt();
					
					depositAmount(con, depanum, depamount);
					break;
				
				case 7:
					System.out.println("Enter Account Number: ");
					int wanum = myObj.nextInt();
					
					System.out.println("Enter Amount to Withdraw: ");
					int wamount = myObj.nextInt();
					
					withdrawAmount(con, wanum, wamount);
					break;
				
				case 8:
					System.out.println("Enter Account Number to Remove: ");
					int ranum = myObj.nextInt();
					
					removeAccount(con, ranum);
					break;
					
				default:
					loop = false;
			}
		}
		myObj.close();
	}
}
