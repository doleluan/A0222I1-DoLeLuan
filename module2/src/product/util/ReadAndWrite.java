package product.util;

import product.models.Export;
import product.models.Import;
import product.models.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWrite {
    private static String PATH = "D:\\A0222I1-DoLeLuan\\module2\\src\\product\\data\\data.csv";

    public List<String> readFile(String path) {
        List<String> list = new ArrayList<>();
        try {
            File file = new File(path);
            if (!file.exists()) {
                file.createNewFile();
            }
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                if (!line.isEmpty()) {
                    list.add(line);
                }
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void writeToFile(String path, List<Product> products) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, false));
            for (int i = 0; i < products.size(); i++) {
                bufferedWriter.write(String.valueOf(products.get(i).getInfo()));
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Product> readProduct() {
        List<String> strings = readFile(PATH);
        List<Product> products = new ArrayList<>();
        for (String string : strings) {
            String[] tmp = string.split(",");
            if (tmp[0].equalsIgnoreCase("Export")) {
                products.add(new Export(tmp[0],Integer.parseInt(tmp[1]), tmp[2], tmp[3], Double.parseDouble(tmp[4]), tmp[5], Double.parseDouble(tmp[6]), tmp[7]));
            } else if (tmp[0].equalsIgnoreCase("Import")) {
                products.add(new Import(tmp[0],Integer.parseInt(tmp[1]), tmp[2], tmp[3], Double.parseDouble(tmp[4]), tmp[5], Double.parseDouble(tmp[6]), tmp[7], Float.parseFloat(tmp[8])));
            }
        }
        return products;
    }
}


