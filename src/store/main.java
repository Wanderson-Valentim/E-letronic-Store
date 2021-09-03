package store;

import java.util.ArrayList;

public class main {
	public static void main(String[] args) {
		/*Loja store = new Loja();
		int tamanho = store.produtos.size();
		System.out.println(tamanho);*/

		ArrayList<int[]> aro = new ArrayList<int[]>();
		int[] vec = new int[2];
		vec[0] = 456;
		vec[1] = 74;
		aro.add(vec);

		int[] v = aro.get(0);

		System.out.println(v[1]);
	}
}
