import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class SortingDemo {

    public static int count = 0;
    public static List<Integer> input = new ArrayList<Integer>();

    public static void main(String[] args) {
        boolean flag = false;

        while (!flag)
        {
            System.out.println("Masukkan angka: (pisahkan angka dengan spasi)" );
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String inputLine = "";
            try{
                inputLine = br.readLine();
            }catch (IOException e)
            {
                e.printStackTrace();
            }

            String[] inputinString = inputLine.trim().split("\\s+");

            try{
                for (int i = 0; i<inputinString.length; i++)
                {
                    input.add(Integer.parseInt(inputinString[i]));
                }
                flag = true;
            }catch (NumberFormatException ex){
                System.out.println("ERROR !!: Masukkan harus berupa angka" );
            }
        }



        System.out.println("Hasil sorting: " );

        if (input.size()>1) {
            for (int i = 0; i<input.size(); i++)
            {
                if(i == 0)
                {
                    if (input.get(i) > input.get(i + 1))
                    {
                        Collections.swap(input, i, i+1);
                        count++;
                        print(input.get(i), input.get(i+1), input);
                    }
                }
                if (i > 0 && i <input.size()-1)
                {
                    if (input.get(i) > input.get(i+1))
                    {
                        Collections.swap(input, i, i+1);
                        count++;
                        print(input.get(i), input.get(i+1), input);
                        if (input.get(i) < input.get(i-1))
                        {
                            reverseCheck(i);
                        }
                    }
                }
                if (i == input.size()-1)
                {
                    if (input.get(i) < input.get(i-1))
                    {
                        reverseCheck(i);
                    }
                }
            }
        }
        else
        {
            System.out.println("Deret angka hanya berisi 1 angka yaitu:");
            System.out.println("[ " + input.get(0) +" ]");
        }

        System.out.println("Jumlah swap:" + count);
    }

    public static void reverseCheck(int pos)
    {
        for (int i = pos; i > 0; i--)
        {
            if (input.get(i) < input.get(i - 1))
            {
                Collections.swap(input, i, i-1);
                count++;
                print(input.get(i-1), input.get(i), input);
            }
        }
    }

    public static void print(int min, int max, List<Integer> list)
    {
        System.out.print(count + ". [" + min + "," + max + "] -> " );
        for(int i = 0; i< list.size(); i++) {
            System.out.print(list.get(i) + " "); //Same here
        }
        System.out.println("");
    }
}
