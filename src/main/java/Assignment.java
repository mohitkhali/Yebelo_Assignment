import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Scanner;
import java.util.UUID;

public class Assignment {
    public static void main(String[]args) throws JsonProcessingException {
        String st;
        String input;

        HashMap<String, String> saveKey = new HashMap<>();
        HashMap<String, Integer> saveCount = new HashMap<>();

        System.out.println("run java url database");
        Scanner sc = new Scanner(System.in);
        while (true) {

            input = sc.next();

            if (input.equals("storeurl")) {
                st = sc.nextLine();
                String uniqueID = UUID.randomUUID().toString();
                saveKey.put(st, uniqueID);
                if (saveCount.containsKey(st)) {
                    saveCount.put(st, saveCount.get(st) + 1);

                } else {
                    saveCount.put(st, 0);
                }
                System.out.println("successfully stored the url");

            }


            else if (input.equals("get")) {
                st = sc.nextLine();
                if (saveCount.containsKey(st)) {
                    saveCount.put(st, saveCount.get(st) + 1);

                } else {
                    saveCount.put(st, 0);
                }
                System.out.println(saveKey.get(st));



            }


            else if(input.equals("count")){
                st=sc.nextLine();
                System.out.println(saveCount.get(st));
            }


            else if(input.equals("list")){
                ObjectMapper mapper = new ObjectMapper();
                String  list
                        = mapper.writeValueAsString(saveKey);
                System.out.println(list);
            }

            else if (input.equals("exit")) {
                System.exit(1);
            }
            else{

              System.out.println("Error! pleas check your command");
              System.out.println("Error Again");

            }


        }
    }
}
