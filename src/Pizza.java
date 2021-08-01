
public class Pizza {
	int index;
	int totalIngredients;
	String ingredients[];
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String res="Ingredients:" +  String.valueOf(totalIngredients) + " Pizza:" + String.valueOf(index);
		return res;
	}
}

