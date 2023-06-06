package huerto;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class HuertoHelper {
	
	public static HuertoUrbano createHuertoExamen() {
		
		List<String> allNames = Arrays.asList(new String[]{"Tomate","Lechuga","Cebolla","Zanahoria","Albahaca","Perejil","Puerro","Ajo","Sandia","Melon","Guisante","Coliflor",
		"Nabo","Alcachofa","Pepino","Calabacin","Habas","Judias","Maiz","Arroz","Fresa","Trigo","Patatas"});
		
		float tam = 5000;
		int parcelas = 50;
		
		HuertoUrbano huerto = new HuertoUrbano(tam);
		
		float tamParcela = tam / parcelas;
		
		for(int i=0;i<parcelas;i++) {
			Parcela p = new Parcela(tamParcela,generateCliente());
			
			int amount = ThreadLocalRandom.current().nextInt(0, allNames.size());
			Collections.shuffle(allNames);
			List<String> plantas = allNames.subList(0, amount+1);
			
			for(String planta : plantas) {
				Cultivo c = new Cultivo(planta,randomWaterNeeds(),randomInt(3, 30));
				p.addCultivo(c);
			}
			
			huerto.addParcela(p);
		}
		
		return huerto;
	}
	
	public static Cliente generateCliente() {
		return new Cliente((int) (600000000 + Math.random()*100000000));
	}
	
	public static Agua randomWaterNeeds() {
		double p = Math.random();
		
		if(p<0.33f)
			return Agua.baja;
		if(p<0.66f)
			return Agua.media;
		return Agua.alta;
	}
	
	public static int randomInt(int Min,int Max) {
		return Min + (int)(Math.random() * ((Max - Min) + 1));
	}
}
