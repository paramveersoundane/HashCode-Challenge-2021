import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;



public class Pizzeria {
	static boolean isNotAvailable[];
	static int pizzaAvailable;
	 /*
	static void distrubuteToTeam2(ArrayList<String> pizzas[], int team2 ) {
		int n = pizzas.length;
		for(int i=0;i<n-1;i++) {
			
			for(int j=i+1;j<n;j++) {
				HashSet<String> set=new HashSet<String>();
				for(String ingredient: pizzas[i]) {
					set.add(ingredient);
				}
				for(String ingredient: pizzas[j]) {
					set.add(ingredient);
				}
//				System.out.println(pizzas[i] + " "  + pizzas[j]);
//				System.out.println(set.size());
//				System.out.println("------------------------------------------");
			}
			
		}
	}
	static void distrubute(ArrayList<String> pizzas[], int team2 ) {
		int n = pizzas.length;
		for(int i=0;i<n-1;i++) {
			
			for(int j=i+1;j<n;j++) {
				HashSet<String> set=new HashSet<String>();
				for(String ingredient: pizzas[i]) {
					set.add(ingredient);
				}
				for(String ingredient: pizzas[j]) {
					set.add(ingredient);
				}
//				System.out.println(pizzas[i] + " "  + pizzas[j]);
//				System.out.println(set.size());
//				System.out.println("------------------------------------------");
			}
			
		}
	}
	*/
	static long max(long a, long b) {
		return a>b?a:b;
	}
	static long distrubuteToTeamOf2(Pizza pizzas[], int team2 ) throws FileNotFoundException  {
		int n = pizzas.length;
		int i=n-1,j=n-2;
		long score=0;
		PrintWriter writer = null;
		try {
			 writer=new PrintWriter("resources/pizza_distribution_to_TeamOf2.txt");
			 writer.println("Score: " + score + " , Pizza Available: " + pizzaAvailable + " , no. of Teams is " + team2);
			 while(team2>0 && i>0 && j>0) {
				 //Check if out of Stock
				 if(pizzaAvailable<=0) {
					 break;
				 }
				 //handling exceptions
				 if(i==j) {
					 j--;
					 continue;
				 }
				 //check if Available
				 if(isNotAvailable[j]) {
					 j--;
					 continue;
				 }else if(isNotAvailable[i]) {
					 i--;
					 continue;
				 }
				 
					HashSet<String> set=new HashSet<String>();
					for(String res: pizzas[i].ingredients) {
						set.add(res);
					}
					for(String res: pizzas[j].ingredients) {
						set.add(res);
					}
					
					//Deliver the pizza
					isNotAvailable[i]=true;pizzaAvailable--;
					isNotAvailable[j]=true;pizzaAvailable--;
					writer.println(2 + " " + pizzas[i].index + " " + pizzas[j].index + " " + set.size());
					int temp = set.size();
				
					
					score = temp*temp + score;
					team2--;
					i--;j--;
				}
		} catch (FileNotFoundException e) {
			System.err.println("File Not Found");
		}
		writer.print("Score: " + score + " , Pizza Available: " + pizzaAvailable);
		
		writer.close();
		return score;
	}
	static long distrubuteToTeamOf3(Pizza pizzas[], int team3 ) throws FileNotFoundException  {
		int n = pizzas.length;
		int i=n-1,j=n-2,k=n-3;
		long score=0;
		PrintWriter writer = null;
		try {
			 writer=new PrintWriter("resources/pizza_distribution_to_TeamOf3.txt");
			 writer.println("Score: " + score + " , Pizza Available: " + pizzaAvailable + " , no. of Teams is " + team3);
			 while(team3>0 && i>0 && j>0 && k>0) {
				 //check if out of stock
				 if(pizzaAvailable<=0) {
					 break;
				 }
				 if(i==j) {
					 j--;
					 continue;
				 }else if(j==k) {
					 k--;
					 continue;
				 }else if(k==i) {
					 k--;
					 continue;
				 }
				 //check for availability
				 if( isNotAvailable[j]) {
					 j--;
					 continue;
				 }else if( isNotAvailable[k]) {
					 k--;
					 continue;
				 }else if(isNotAvailable[i]) {
					 i--;
					 continue;
				 }
				 //Calculate distinct ingredients
					HashSet<String> set=new HashSet<String>();
					for(String res: pizzas[i].ingredients) {
						set.add(res);
					}
					for(String res: pizzas[j].ingredients) {
						set.add(res);
					}
					for(String res: pizzas[k].ingredients) {
						set.add(res);
					}
					//Deliver the pizza
					isNotAvailable[i]=true;pizzaAvailable--;
					isNotAvailable[j]=true;pizzaAvailable--;
					isNotAvailable[k]=true;pizzaAvailable--;
					team3--;
					
					writer.println(3 + " " + pizzas[i].index + " " + pizzas[j].index + " " +  pizzas[k].index + " " + set.size());
					
					//Calculate Score
					int temp = set.size();
					score = temp*temp + score;
					
					i--;j--;k--;
				}
		} catch (FileNotFoundException e) {
			System.err.println("File Not Found");
		}
		writer.print("Score: " + score + " , Pizza Available: " + pizzaAvailable);
		writer.close();
		return score;
	}
	static long distrubuteToTeamOf4(Pizza pizzas[], int team4 ) throws FileNotFoundException  {
		int n = pizzas.length;
		int i=n-1,j=n-2,k=n-3,l=n-4;
		long score=0;
		PrintWriter writer = null;
		try {
			 writer=new PrintWriter("resources/pizza_distribution_to_TeamOf4.txt");
			 writer.println("Score: " + score + " , Pizza Available: " + pizzaAvailable + " , no. of Teams is " + team4);
			 while(team4>0 && i>0 && j>0 && k>0 && l>0) {
				 //for out of stock
				 if(pizzaAvailable<=0) {
					 break;
				 }
				 //check for equality
				 if(i==j) {
					 j--;
					 continue;
				 }else if(j==k || i==k) {
					 k--;
					 continue;
				 }else if(l==k || l==i || l==j) {
					 l--;
					 continue;
				 }
				 //check availability
				 if( isNotAvailable[j]) {
					 j--;
					 continue;
				 }else if( isNotAvailable[k]) {
					 k--;
					 continue;
				 }else if(isNotAvailable[l]) {
					 l--;
					 continue;
				 }else if(isNotAvailable[i]) {
					 i--;
					 continue;
				 }
				 
					HashSet<String> set=new HashSet<String>();
					for(String res: pizzas[i].ingredients) {
						set.add(res);
					}
					for(String res: pizzas[j].ingredients) {
						set.add(res);
					}
					for(String res: pizzas[k].ingredients) {
						set.add(res);
					}
					for(String res: pizzas[l].ingredients) {
						set.add(res);
					}
					//Deliver the pizzas
					isNotAvailable[i]=true;pizzaAvailable--;
					isNotAvailable[j]=true;pizzaAvailable--;
					isNotAvailable[k]=true;pizzaAvailable--;
					isNotAvailable[l]=true;pizzaAvailable--;
					team4--;
					//logging the info
					writer.println(4 + " " + pizzas[i].index + " " + pizzas[j].index + " " +  pizzas[k].index + " "+ pizzas[l].index + " " + set.size());
					//calculating score
					int temp = set.size();
				    score = temp*temp + score;
					
					i--;j--;k--;l--;
				}
		} catch (FileNotFoundException e) {
			System.err.println("File Not Found");
		}
		writer.print("Score: " + score + " , Pizza Available: " + pizzaAvailable);
		writer.close();
		return score;
	}
	
	static void printAr(boolean[] arr) {
		for(boolean i: arr) {
			System.out.print(i + " ");
		}
	}

	public static void main(String[] args) {
		File inputFile1 =  new File("resources/a_example.in");
		File inputFile3 =   new File("resources/c_many_ingredients.in");
		File inputFile2 =   new File("resources/b_little_bit_of_everything.in");
		File inputFile4 =   new File("resources/d_many_pizzas.in");
		File inputFile5 =   new File("resources/e_many_teams.in");
		File inputFile=inputFile4;
		int team2 = 0, team3 = 0, team4 = 0, totalPizza = 0;
		Scanner scan = null;
		PrintWriter writer=null;
		try {
			scan=new Scanner(inputFile);
			writer=new PrintWriter("resources/result.txt");
			totalPizza=scan.nextInt();
			pizzaAvailable=totalPizza;
			isNotAvailable=new boolean[totalPizza];
			team2=scan.nextInt();
			team3=scan.nextInt();
			team4=scan.nextInt();
		} catch (FileNotFoundException e) {
			System.err.println("File not found: " + inputFile);
		}
		System.out.println(totalPizza + " " + team2 + " " + team3 + " " + team4);
		int requiredPizzas=2*team2 + 3*team3 + 4*team4;
		/*
		ArrayList<String> pizzas[] = new ArrayList[totalPizza];
		for(int i=0;i<totalPizza;i++) {
			int ingredients =scan.nextInt();
			pizzas[i]=new ArrayList<String>();
			for(int j=0; j<ingredients;j++) {
				pizzas[i].add(scan.next());
				
			}
			System.out.println(pizzas[i]);
		}
		*/
		Pizza pizzas[]=new Pizza[totalPizza];
		for(int i=0;i<totalPizza;i++) {
			pizzas[i]=new Pizza();
			pizzas[i].index=i;
			pizzas[i].totalIngredients=scan.nextInt();
			String temp[]=new String[pizzas[i].totalIngredients];
			for(int j=0;j<pizzas[i].totalIngredients;j++) {
				temp[j]=scan.next();
			}
			pizzas[i].ingredients=temp;
			
		}
		Arrays.sort(pizzas, new Comparator<Pizza>() {
			public int compare(Pizza p1, Pizza p2) {
				return p1.totalIngredients -p2.totalIngredients;
			}
		});
		int i=0;
		for (Pizza pizza : pizzas) {
			System.out.println(pizza + " " + i++);
			writer.println(pizza + " " + i++);
			
		}
		System.out.println(totalPizza + " " + team2 + " " + team3 + " " + team4);
		System.out.println("Required Ingredients: " + requiredPizzas);
		writer.println("Required Ingredients: " + requiredPizzas);
		try {
			
			long totalscore1=   distrubuteToTeamOf4(pizzas, team4) + distrubuteToTeamOf3(pizzas, team3)+distrubuteToTeamOf2(pizzas, team2);
			isNotAvailable=new boolean[totalPizza]; pizzaAvailable=totalPizza;
			long totalscore2=   distrubuteToTeamOf2(pizzas, team2) + distrubuteToTeamOf3(pizzas, team3)+distrubuteToTeamOf4(pizzas, team4);
			isNotAvailable=new boolean[totalPizza]; pizzaAvailable=totalPizza;
			long totalscore3=   distrubuteToTeamOf2(pizzas, team2) + distrubuteToTeamOf4(pizzas, team4)+distrubuteToTeamOf3(pizzas, team3);
			isNotAvailable=new boolean[totalPizza]; pizzaAvailable=totalPizza;
			long totalscore4=   distrubuteToTeamOf4(pizzas, team4) +distrubuteToTeamOf2(pizzas, team2) + distrubuteToTeamOf3(pizzas, team3);
			isNotAvailable=new boolean[totalPizza]; pizzaAvailable=totalPizza;
			long totalscore5=   distrubuteToTeamOf3(pizzas, team3)+distrubuteToTeamOf2(pizzas, team2)+distrubuteToTeamOf4(pizzas, team4);
			isNotAvailable=new boolean[totalPizza]; pizzaAvailable=totalPizza;
			long totalscore6=   distrubuteToTeamOf3(pizzas, team3) + distrubuteToTeamOf4(pizzas, team4)+distrubuteToTeamOf2(pizzas, team2);
			
			writer.println("Distribution 1 score: " + totalscore1+", "+
					   "Distribution 2 score: " + totalscore2 +", "+
					   "Distribution 3 score: " + totalscore3 +", "+
					   "Distribution 4 score: " + totalscore4 +", "+
					   "Distribution 5 score: " + totalscore5 +", "+
					   "Distribution 6 score: " + totalscore6 );
			totalscore1=max(totalscore1,max(totalscore2, max(totalscore3,max(totalscore4,max(totalscore5,totalscore6)))));
			writer.println("Total Score for: "+ inputFile+ " is " + totalscore1);
		} catch (Exception e) {
			System.err.println("Error");
		}
		scan.close();
		writer.close();

	}

}
