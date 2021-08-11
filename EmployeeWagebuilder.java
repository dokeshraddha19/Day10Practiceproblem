import java.util.*;
class computeEmployeeWage {
		private static final int IS_ABSENT = 0;
		private static final int IS_PART_TIME = 1;
		private static final int IS_FULL_TIME = 2;
		private static final int fullDayHr=8;
		
		private static String company;
		private static  int WAGE_PER_HOUR;
		private static int MAX_HR_IN_MONTH;
		private static int NUM_OF_WORKING_DAYS;
		private static int empWage;
		private static int entry;
		public static HashMap<Integer, Integer> companyWage = new HashMap<Integer, Integer>();
	        public static ArrayList<Integer> wagePerCompany = new ArrayList <Integer>();
		public static ArrayList<Integer> Company1 = new ArrayList <Integer>();
	      	public static ArrayList<Integer> Company2 = new ArrayList <Integer>();
	        public static ArrayList<Integer> CompanyOne = new ArrayList <Integer>();
		public static ArrayList<Integer> CompanyTwo = new ArrayList <Integer>();
		  public static HashMap<String, Integer> companyMonthlyWage = new HashMap<>();
		@SuppressWarnings("static-access")
		computeEmployeeWage(String company,int WAGE_PER_HOUR,int MAX_HR_IN_MONTH,int NUM_OF_WORKING_DAYS)
		 {
			  this.company=company;
			  this.WAGE_PER_HOUR=WAGE_PER_HOUR;
			  this.MAX_HR_IN_MONTH=MAX_HR_IN_MONTH;
			  this.NUM_OF_WORKING_DAYS=NUM_OF_WORKING_DAYS;
		 }
		  public String getCompany1()
		  {
			  return this.company;
		  }
		  public String getCompany2() 
		  {
			return this.company;
		  }

		  public static int employeeDailyWage() 
			{
				empWage = fullDayHr * WAGE_PER_HOUR;
				return empWage;
			}
		  public static int monthlyWage()
		  {
			 int empHrs=0;
			 int empWage=0;
			 int totalWorkingHrs = 0;
			 int totalWorkingDays = 0;
			 int totalWage=0;
		while(totalWorkingHrs <= MAX_HR_IN_MONTH && totalWorkingDays <= NUM_OF_WORKING_DAYS)
		{
		
			totalWorkingDays++;
			int empCheck = (int)Math.floor(Math.random() * 10)%3;
			switch (empCheck)
			{
				case 0:
					empHrs=0;
					break;
				case 1:
					empHrs=fullDayHr/2;
					break;
				case 2:
					empHrs=fullDayHr;
					break;
			}

			totalWorkingHrs+=empHrs;
			empWage=empHrs*WAGE_PER_HOUR;
			if(company=="DMart")
				CompanyOne.add(empWage);
			else
				CompanyTwo.add(empWage);
			totalWage+=empWage;
		}
		
		return totalWage;

	}
		  public static void dailyWageAndMonthlyWage() 
			{
				companyWage.put(employeeDailyWage(), monthlyWage());
				entry++;
			}

			public static void printWage() 
			{
				for (int i: companyWage.keySet())
					System.out.println("Daily Wage:"+i+" Total Wage:"+companyWage.get(i));
			}
	public static void printCompanyWage() 
			{
				System.out.println(CompanyOne);
				System.out.println(CompanyTwo);
			}
			public static void putTotalWage() 
			{
				wagePerCompany.add(monthlyWage());
				int a=monthlyWage();
				companyMonthlyWage.put(company, a);
				companyWage.put(employeeDailyWage(), a);
				entry++;
			}

			 
			public static void getTotalWage(String company) 
			{
				System.out.println(wagePerCompany);
				System.out.println(company+" : "+companyMonthlyWage.get(company));
			}
}

public class EmployeeWagebuilder {

	public static void main(String[] args) {
		computeEmployeeWage company1 = new computeEmployeeWage("DMart", 20, 100, 25);
		company1.dailyWageAndMonthlyWage();
		company1.printWage();
		computeEmployeeWage companyOne = new computeEmployeeWage("DMart", 20, 100, 25);
		companyOne.putTotalWage();
		companyOne.printWage();
		companyOne.printCompanyWage();
		companyOne.getTotalWage("DMart");
		computeEmployeeWage company2 = new computeEmployeeWage("Reliance", 15, 120, 30);
		company2.dailyWageAndMonthlyWage();
		company2.printWage();
		computeEmployeeWage companyTwo = new computeEmployeeWage("Reliance", 15, 120, 30);
		companyTwo.putTotalWage();
		companyTwo.printWage();
		companyTwo.printCompanyWage();
		companyTwo.getTotalWage("Reliance");
		
	}

} 
