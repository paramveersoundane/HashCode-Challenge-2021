import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;



public class Pizzeria {
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
	
	static void distrubuteToTeam3(ArrayList<String> pizzas[], int team3 ) {
		int n = pizzas.length;
		for(int i=0;i<n-2;i++) {
			
			for(int j=i+1;j<n-1;j++) {
				for(int k=j+1;k<n;k++) {
					HashSet<String> set=new HashSet<String>();
					for(String ingredient: pizzas[i]) {
						set.add(ingredient);
					}
					for(String ingredient: pizzas[j]) {
						set.add(ingredient);
					}
					for(String ingredient: pizzas[k]) {
						set.add(ingredient);
					}
					System.out.println(pizzas[i] + " "  + pizzas[j] + " " + pizzas[k]);
					System.out.println(set.size());
					System.out.println("------------------------------------------");
				}
			}
			
		}
	}

	public static void main(String[] args) {
		File inputFile1 =  new File("resources/a_example");
		File inputFile2=new File("resources/c_many_ingredients.in");
		int team2 = 0, team3 = 0, team4 = 0, totalPizza = 0;
		Scanner scan = null;
		try {
			scan=new Scanner(inputFile2);
			totalPizza=scan.nextInt();
			team2=scan.nextInt();
			team3=scan.nextInt();
			team4=scan.nextInt();
		} catch (FileNotFoundException e) {
			System.err.println("File not found: " + inputFile2);
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
			for(int j=0;j<pizzas[i].totalIngredients;j++) {
				pizzas[i].ingredients[j]=scan.next();
			}
			
		}
		System.out.println(requiredPizzas);
		//distrubuteToTeam2(pizzas, team2);
		//distrubuteToTeam3(pizzas, team3);
		//System.out.println(pizzas);
		System.out.println("Ended");
		

	}

}
