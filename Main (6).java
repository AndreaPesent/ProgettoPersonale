/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
import java.io.BufferedWriter;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
public class Main
{
	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		double MediaGenerale=0;
		int materia;
		int mediamateria;
		System.out.println("1- Matematica");
		System.out.println("2- Storia");
		System.out.println("3- Italiano");
		System.out.println("4- Informatica");
		System.out.println("5- Geografia");
		System.out.println("6- Fisica");
		System.out.println("7- Mostra media materia");
		System.out.println("8- Mostra media generale");
		System.out.println("0- Fine programma");
		do
		{
		    System.out.println("SCEGLI UNA MATERIA");
		    materia=in.nextInt();
		    if (materia!=0 && materia!=8 && materia!=7)
		    {
		        double voto=0;
    		    System.out.println("Inserisci il voto");
    		    voto=in.nextInt();
    		    fileMaterie(materia, voto);
		    }
		    if (materia==8)
		    {
		        Media();
		    }
		    if (materia==7)
		    {
		        System.out.println("DI QUALE MATERIA VUOI SAPERE LA MEDIA?");
		        System.out.println("1- Matematica");
		        System.out.println("2- Storia");
        		System.out.println("3- Italiano");
        		System.out.println("4- Informatica");
        		System.out.println("5- Geografia");
        		System.out.println("6- Fisica");
        		mediamateria=in.nextInt();
        		MediaMateria(mediamateria);
		    }
		} while (materia!=0);
	}
	private static void fileMaterie (int materia, double voto)
	{
        String votoM, mater="";
        votoM=String.valueOf(voto);
        mater=String.valueOf(materia);
        try 
        {
            
            File mat = new File("C:\\Users\\RobyMilena\\" + mater + ".txt");
            if (mat.exists())
            {
                BufferedWriter MT= new BufferedWriter(new FileWriter(mat, true));
                MT.append(votoM + "\n");
                MT.flush();
                MT.close();
            }
                
            else 
            {
                mat.createNewFile();
                FileWriter MT = new FileWriter(mat);
                MT.write(votoM + "\n");
                MT.flush();
                MT.close();
            }
        } catch (IOException e) 
        {
            e.printStackTrace();
        }
	}
	private static void Media ()
	{
	    String NomeFile="";
	    double Media=0;
	    int contatore=0;
	    for (int i=1;i<=6;i++)
	    {
	        NomeFile=String.valueOf(i);
	        try 
	        {
                File materia = new File("C:\\Users\\RobyMilena\\" + NomeFile + ".txt");
                Scanner LetturaMateria = new Scanner(materia);
                while (LetturaMateria.hasNextLine()) 
                {
                    String voto = LetturaMateria.nextLine();
                    Media=Media+Double.parseDouble(voto);
                    contatore++;
                }
                LetturaMateria.close();
            } 
            catch (FileNotFoundException e) 
            {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
	    }
	    Media=Media/contatore;
	    System.out.println(Media);
	}
	private static void MediaMateria (int mediamateria)
	{
	    String NomeFile="";
	    double Media=0;
	    int contatore=0;
	        NomeFile=String.valueOf(mediamateria);
	        try 
	        {
                File materia = new File("C:\\Users\\RobyMilena\\" + NomeFile + ".txt");
                Scanner LetturaMateria = new Scanner(materia);
                while (LetturaMateria.hasNextLine()) 
                {
                    String voto = LetturaMateria.nextLine();
                    Media=Media+Double.parseDouble(voto);
                    contatore++;
                }
                LetturaMateria.close();
            } 
            catch (FileNotFoundException e) 
            {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
	    Media=Media/contatore;
	    System.out.println(Media);
	}
}