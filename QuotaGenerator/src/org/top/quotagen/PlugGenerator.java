package org.top.quotagen;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// Примитивная реализация интерфейса
public class PlugGenerator implements IGenerator {

    @Override
    public String getRandomQuota() {
        Random random = new Random();
        List<String> lines = new ArrayList<>();

        try {
            File quota = new File(System.getProperty("user.dir") + "/src/org/top/quotagen/quota.txt");
            BufferedReader br = new BufferedReader(new FileReader(quota));
            String line;

            while((line = br.readLine()) != null) {
                lines.add(line);
            }
            br.close();

        } catch (Exception e) {
            System.out.println("file exception");
        }
        return lines.get(random.nextInt(lines.size()));
    }
}
