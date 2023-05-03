import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class IvPlanet {
    public static void main(String[] args) {
        String fname = "input.txt";
        try {
            Scanner sc = new Scanner(new File(fname));
            int kolvoLevels = sc.nextInt();
            PlanetLevel[] levels = new PlanetLevel[kolvoLevels+1];
            for (int i = 1; i <= kolvoLevels; i++) {
                levels[i] = new PlanetLevel();
                int kPlanets = sc.nextInt();
                sc.nextLine();//������� �� ���� ������ �����, ��� ��� ������ ���� �������� �������
                for (int j = 1; j <= kPlanets; j++) {
                    Planet planet = new Planet(i+"."+j);
                    String planetStr = sc.nextLine();
                    levels[i].planets.add(planet);

                }
                if (sc.hasNext())
                    sc.nextLine();  //���������� ������ �� *
            }
            levels[0]= new PlanetLevel();
            levels[0].planets.add(new Planet("0.1"));
            for (int i = 0; i < kolvoLevels ; i++) {
                printPlanets(levels[i]);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
    public static void printPlanets(PlanetLevel p){
        for (Planet ints: p.planets) {
                System.out.println(ints);
            }
        }
    }

class Planet{
    String name;

    public Planet(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Planet{" +
                name +
                '}';
    }
}

class Tunnel{
    Planet from, to;
    int cost;
}

class PlanetLevel{
    ArrayList<Planet> planets=new ArrayList<>();

    @Override
    public String toString() {
        return "PlanetLevel{" +
                "planets=" + planets +
                '}';
    }
}

class Path{
    ArrayList<Tunnel> tunnels=new ArrayList<>();
    public void add(Tunnel t)
    {
        tunnels.add(t);
    }

    public int getCost()
    {
        int sum=0;
        for (Tunnel t: tunnels ) {
            sum = sum + t.cost;
        }
        return sum;
    }
}