import java.util.Scanner;

public class Main3 {
    public static void main(String[] args){
        Scanner in =new Scanner(System.in);
        String[] max=new String[5];
        String[] min=new String[5];
        int k=0;
        while (in.hasNext()){
            min[k]=in.next();
            max[k]=in.next();
            k++;
        }
        String result = null,result1 = null;
        for (int i = 0; i < k; i++) {
                char[] arr = min[i].toCharArray();
                char[] arr1 = max[i].toCharArray();
                int length = arr.length;
                int length1 = arr1.length;
                if (49 < (int) arr[0] && 54 > (int) arr[0]) {
                    arr[0] = '6';
                    arr[length - 1] = '9';
                    for (int j = 1; j < length / 2; j++) {
                        arr[j] = '0';
                        arr[length - 1 - j] = '0';
                    }
                    if (length % 2 == 1) {
                        arr[length / 2] = '0';
                    }
                }
                if (49 < (int) arr1[0] && 54 > (int) arr1[0]) {
                    arr1[0] = '1';
                    arr1[length1 - 1] = '1';
                    for (int j = 1; j < length1 / 2; j++) {
                        arr1[j] = '9';
                        arr1[length1 - 1 - j] = '6';
                    }
                    if (length1 % 2 == 1) {
                        arr1[length1 / 2] = '8';
                    }
                }
                if ((int) arr[0] == '7') {
                    arr[0] = '8';
                    arr[length - 1] = '8';
                    for (int j = 1; j < length / 2; j++) {
                        arr[j] = '0';
                        arr[length - 1 - j] = '0';
                    }
                    if (length % 2 == 1) {
                        arr[length / 2] = '0';
                    }
                }
                if ((int) arr1[0] == '7') {
                    arr1[0] = '6';
                    arr1[length - 1] = '9';
                    for (int j = 1; j < length1 / 2; j++) {
                        arr1[j] = '9';
                        arr1[length1 - 1 - j] = '6';
                    }
                    if (length1 % 2 == 1) {
                        arr1[length1 / 2] = '8';
                    }
                }

                if (arr[0] == '1') {
                    arr[length - 1] = '1';
                }
                if (arr1[0] == '1') {
                    arr1[length1 - 1] = '1';
                }
                if (arr[0] == '6') {
                    arr[length - 1] = '9';
                }
                if (arr1[0] == '6') {
                    arr1[length1 - 1] = '9';
                }
                if (arr[0] == '8') {
                    arr[length - 1] = '8';
                }
                if (arr1[0] == '8') {
                    arr1[length1 - 1] = '8';
                }
                if (arr[0] == '9') {
                    arr[length - 1] = '6';
                }
                if (arr1[0] == '9') {
                    arr1[length1 - 1] = '6';
                }
                for (int j = 1; j < length / 2; j++) {
                    if (arr[j] == '0') {
                        arr[length - 1 - j] = '0';
                    }
                    if (arr[j] == '1') {
                        arr[length - 1 - j] = '1';
                    }
                    if (arr[j] == '6') {
                        arr[length - 1 - j] = '9';
                    }
                    if (arr[j] == '8') {
                        arr[length - 1 - j] = '8';
                    }
                    if (arr[j] == '9') {
                        arr[length - 1 - j] = '6';
                    }
                    if (arr[j] == '7') {
                        arr[j] = '8';
                        arr[length - 1 - j] = '8';
                        for (int l = j + 1; l < length / 2; l++) {
                            arr[l] = '0';
                            arr[length - 1 - l] = '0';
                        }
                        if (length % 2 == 1) {
                            arr[length / 2] = '0';
                        }
                    }
                    if (49 < (int) arr[j] && (int) arr[j] < 54) {
                        arr[j] = '6';
                        arr[length - 1 - j] = '9';
                        for (int l = j + 1; l < length / 2; l++) {
                            arr[l] = '0';
                            arr[length - 1 - l] = '0';
                        }
                        if (length % 2 == 1) {
                            arr[length / 2] = '0';
                        }
                    }
                }
                for (int j = 1; j < length1 / 2; j++) {
                    if (arr1[j] == '0') {
                        arr1[length1 - 1 - j] = '0';
                    }
                    if (arr1[j] == '1') {
                        arr1[length1 - 1 - j] = '1';
                    }
                    if (arr1[j] == '6') {
                        arr1[length1 - 1 - j] = '9';
                    }
                    if (arr1[j] == '8') {
                        arr1[length1 - 1 - j] = '8';
                    }
                    if (arr1[j] == '9') {
                        arr1[length1 - 1 - j] = '6';
                    }
                    if (arr1[j] == '7') {
                        arr1[j] = '6';
                        arr1[length1 - 1 - j] = '9';
                        for (int l = j + 1; l < length1 / 2; l++) {
                            arr1[l] = '9';
                            arr1[length1 - l - 1] = '6';
                        }
                        if (length1 % 2 == 1) {
                            arr1[length1 / 2] = '8';
                        }
                    }
                    if (49 < (int) arr1[j] && (int) arr1[j] < 54) {
                        arr1[j] = '1';
                        arr1[length1 - 1 - j] = '1';
                        for (int l = j + 1; l < length1 / 2; l++) {
                            arr1[l] = '9';
                            arr1[length1 - 1 - l] = '6';
                        }
                        if (length1 % 2 == 1) {
                            arr1[length1 / 2] = '8';
                        }
                    }
                }
                result = String.valueOf(arr);
                result1 = String.copyValueOf(arr1);
                if (length % 2 == 1) {
                    if ((int) arr[length / 2] > 49) {
                        arr[length / 2] = '8';
                    }
                    result = String.valueOf(arr);
                }
                if (length1 % 2 == 1) {
                    if ((int) arr1[length1 / 2] > 56) {
                        arr1[length1 / 2] = '8';
                    }
                    if (49 < (int) arr1[length1 / 2] && (int) arr1[length1 / 2] < 56) {
                        arr1[length1 / 2] = '1';
                    }
                    result1 = String.valueOf(arr1);
                }
                if (Long.parseLong(result) < Long.parseLong(min[i])) {
                    for (long j = Long.parseLong(min[i]); j < Long.parseLong(max[i]); j++) {
                        int x = 0;
                        String answer = String.valueOf(j);
                        for (int l = 0; l < answer.length() / 2; l++) {
                            char c = answer.charAt(answer.length() - 1 - l);
                            if ((answer.charAt(l) == 48 && c == 48) || (answer.charAt(l) == 54 && c == 57) ||
                                    (answer.charAt(l) == 57 && c == 54) || (answer.charAt(l) == 49 && c == 49)
                                    || (answer.charAt(l) == 56 && c == 56)) {
                                x++;
                            }
                        }
                        if (x == answer.length() / 2) {
                            if (answer.length() % 2 == 0) {
                                result = answer;
                                break;
                            }
                            if (answer.charAt(answer.length() / 2) == '0' || answer.charAt(answer.length() / 2) == '1' || answer.charAt(answer.length() / 2) == '8') {
                                result = answer;
                                break;
                            }
                        }
                    }
                }
                if (Long.parseLong(result1) > Long.parseLong(max[i])) {

                    for (long j = Long.parseLong(max[i]); j > Long.parseLong(min[i]); j--) {
                        int x = 0;
                        String answer = String.valueOf(j);
                        for (int l = 0; l < answer.length() / 2; l++) {
                            char c = answer.charAt(answer.length() - 1 - l);
                            if ((answer.charAt(l) == 48 && c == 48) || (answer.charAt(l) == 54 && c == 57) ||
                                    (answer.charAt(l) == 57 && c == 54) || (answer.charAt(l) == 49 && c == 49)
                                    || (answer.charAt(l) == 56 && c == 56)) {
                                x++;
                            }
                        }
                        if (x == answer.length() / 2) {
                            if (answer.length() % 2 == 0) {
                                result1 = answer;
                                break;
                            }
                            if (answer.charAt(answer.length() / 2) == '0' || answer.charAt(answer.length() / 2) == '1' || answer.charAt(answer.length() / 2) == '8') {
                                result1 = answer;
                                break;
                            }
                        }
                    }
                }
            if (min[i].length() == 1) {
                if (Long.parseLong(min[i])==0) {
                    result = "0";
                }
                if(Long.parseLong(min[i])==1){
                    result="1";
                }
                if(min[i].equals("9")){
                    result="11";
                }
                if(1<Long.parseLong(min[i])&&Long.parseLong(min[i])<=8){
                    result = "8";
                }
            }
            if (Long.parseLong(max[i]) >= 1 && Long.parseLong(max[i]) < 8) {
                result1 = "1";
            }
            if (Long.parseLong(max[i]) >= 8 && Long.parseLong(max[i]) < 11) {
                result1 = "8";
            }
            if(max[i].equals("0")){
                result1 = "0";
            }
            System.out.println(result + " " + result1);
        }


    }
}
