package metaheuristica;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

import org.jfree.ui.RefineryUtilities;

import swapOperator.Swap;
import swapOperator.TabuSearch;
import swapOperator.XYPlot;

public class Main {

	public static final String SEPARATOR=",";
	public static final String QUOTE="\"";
	
	public static void main(String[] args) {
		try {
			if(args[0].equalsIgnoreCase("-path")) { // si parte con -path asume que realizaras una prueba unitaria
				int cantidadSwappings = 2;
				String Fayudantia1 = "F64.txt";
				String Dayudantia1 = "D64.txt";
				String path = System.getProperty("user.dir")+"\\datos\\";
				for(String arg : args)
				{
					//System.out.println(arg);
				}
				
				
			}else if(args[0].equalsIgnoreCase("-dataset")){ //si parto con -dataset carga el dataste para hacer varias pruebas programadas
				BufferedReader br = null;
				try {
					//dejo un espacio para cargar el dataset
			        //br =new BufferedReader(new FileReader("dataset-SimulatedAnnealing.csv"));
			        br =new BufferedReader(new FileReader(args[1]));
			        String line = br.readLine();
			        //voy leyendo linea a linea
			        while (null!=line) {
			        	//separo la linea por el separador
			           String [] fields = line.split(SEPARATOR);
			           //remuevo basura del codigo
			           fields = removeTrailingQuotes(fields);
			           System.out.println(Arrays.toString(fields));
			           
			           line = br.readLine();
			        }
			        
			     } catch (Exception e) {
			        //...
			     } finally {
			        if (null!=br) {
			           br.close();
			        }
			     }
			}else if(args[0].equalsIgnoreCase("-help"))	{
				System.out.println("Ejemplo de sintaxis:");
				System.out.println("java -jar ayudantia1metaheuristicas.jar [carga desde cmd] [path] [txt matriz F] [txt matriz distancias] [cantidad de swappings] [nombre ejercicio]");
				System.out.println("java -jar ayudantia1metaheuristicas.jar -path C: F64.txt D64.txt 2 ejercicio1");
			}
		} catch (Exception e){
			e.printStackTrace();
		}
		System.out.println("Fin de la ejecucion");
	}
	
	private void tabuSeach(String[] args)
	{
		System.out.println("######## Tabu search ########");
		int duracionTabuList = 100;
		int iteraciones = 80;
		
		if ( args.length > 6)
			duracionTabuList = Integer.parseInt(args[6]);

		if ( args.length > 7)
			iteraciones = Integer.parseInt(args[7]);

		
		//ArrayList<Double> costos = TabuSearch.TabuSearch(solucionInicial, swap, duracionTabuList, iteraciones);
		ArrayList<Double> costos = TabuSearch.TabuSearch(args[0], 
				getSwap(args[0], args[0], Integer.parseInt(args[4])), 
				Integer.parseInt(args[4]), Integer.parseInt(args[4]));
		//plotting
		final XYPlot demo = new XYPlot("Gráfico optimización Tabu Search", "Costo", costos);
	    demo.pack();
	    RefineryUtilities.centerFrameOnScreen(demo);
	    demo.setVisible(true);
	}
	
	private Swap getSwap(String path, String datos, int cantidadSwappings)
	{
		//como estandarizamos los datos se puede hacer este truco y solo pedir los datos por parametros
		String Fayudantia1 = path+"F"+datos;
		String Dayudantia1 = path+"D"+datos;
		//abre los archivos da datos como matriz
		try
		{
			Stream<String> matrizF = Files.lines(Paths.get(path+Fayudantia1));
			Stream<String> matrizD = Files.lines(Paths.get(path+Dayudantia1));
			
			int[][] f = convertirString(matrizF);
			int[][] d = convertirString(matrizD);
			/*for(int[] i: m){
				for(int j: i){
					System.out.println(j);
				}
			}*/					
			
			Swap swap = new Swap(f, d);
			int[] solucionInicial = swap.generarSolcuionInicial(swap.getMatrizD());
			swap.toStringSolcuionInicial(solucionInicial);
			return swap;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	public static int[][] convertirString(Stream<String> filas){
		String[] fila = filas.toArray(String[]::new);
		int[][] matriz = new int[fila.length][fila.length];
		for(int i=0;i<fila.length;i++){
			String[] f = fila[i].split(" ");
			for(int j=0;j<f.length;j++){
				matriz[i][j]=Integer.parseInt(f[j]);
			}
		}
		return matriz;
	}
	
	private static String[] removeTrailingQuotes(String[] fields) {
	      String result[] = new String[fields.length];
	      for (int i=0;i<result.length;i++){
	         result[i] = fields[i].replaceAll("^"+QUOTE, "").replaceAll(QUOTE+"$", "");
	      }
	      return result;
	   }
}
