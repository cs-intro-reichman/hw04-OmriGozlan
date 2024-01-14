public class StringOps {
    ////////////////////////////////////////////////////////////
    //////                                               ///////
    //////              Reminder:                        ///////
    //////        allowed methods                        ///////
    //////                                               ///////
    //////        1.charAt(int index)                    ///////
    //////        2.length()                             ///////
    //////        3.substring(int start)                 ///////
    //////        4.substring(int start,int ends)        ///////
    //////        5.indexOf(String str)                  ///////
    //////                                               ///////
    //////        The rest are not allowed !             ///////
    //////        if you want to use a different         ///////
    //////        method, and you can implement          ///////
    //////        it using material from the course      ///////
    //////        you need to implement a version of     ///////
    //////        the function by yourself.              ///////
    //////                                               ///////
    //////        see example for substring              ///////
    //////        in Recitation 3 question 5             ///////
    //////                                               ///////
    ////////////////////////////////////////////////////////////
    public static void main(String[] args) {
        System.out.println(capVowelsLowRest("Hello World"));
        System.out.println(capVowelsLowRest("One two tHRee world"));
        System.out.println(capVowelsLowRest("vowels are fun"));
        System.out.println(capVowelsLowRest("intro"));
        System.out.println(capVowelsLowRest("yellow"));
        System.out.println(camelCase("Hello World"));
        System.out.println(camelCase("HELLO   world"));
        System.out.println(camelCase(" two    wordS"));
        System.out.println(camelCase("world"));
        System.out.println(camelCase( "Intro to coMPUter sCIEncE "));
        PrintArr(allIndexOf("Hello world",'l'));
        PrintArr(allIndexOf("Hello worLd",'l'));
        PrintArr(allIndexOf("Hello world",' '));





    }

    public static String capVowelsLowRest (String string) {
        int n = string.length();
        String ans = "";
        for(int i =0 ; i<n ; i++){
            char c = string.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
              c = (char) (c-32);
              ans+=c;
            } else if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
                ans +=c;
            } else if('A'<= c && c <= 'Z'){
                c = (char) (c+32);
                ans+=c;
            } else {
             ans +=c;
            }
            }
        return ans;
    }


    public static String camelCase (String string) {
        string = lowercase(string);
        string = removeSpaces(string);
        return string;
    }

    public static int[] allIndexOf (String string, char chr) {
        int N = 0;
        for(int i =0 ; i< string.length(); i++){
            if(string.charAt(i) == chr){
                 N++;
            }
        }
        int [] ans = new int[N];
        int currentIndex = -1;
        for(int i=0 ; i< ans.length; i++) {
            for (int j = 0; j < string.length(); j++) {
                if (string.charAt(j) == chr && j > currentIndex){
                    ans[i] = j;
                    currentIndex = j;
                    break;
                }

            }
        }
        return ans;
    }

    public static String removeSpaces(String str) {
        str = str + " ";
        int prev = 0;
        int curr = 0;
        String temp = "";
        int check = 0;

        while (curr < str.length()) {

            if (str.charAt(curr) == ' ') {
                if (prev == curr) {
                    str = str.substring(curr + 1);
                    curr = 0;
                    continue;
                }
                if (prev != curr) {
                    check++;
                    if (check >= 2 && str.charAt(prev)>=96 && str.charAt(prev)<=122) {
                        temp = temp + (char) (str.charAt(prev) - 32);
                        temp = temp + str.substring(prev + 1, curr);
                        str = str.substring(curr + 1);
                        curr = 0;
                        continue;
                    }
                    temp = temp + str.substring(prev, curr);
                    str = str.substring(curr + 1);
                    curr = 0;

                    continue;
                }

            }
            curr++;

        }
        return temp;
     }

    public static String lowercase(String str) {
        String newStr = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= 65 && str.charAt(i) <= 90) {
                newStr = newStr + (char) (str.charAt(i) + 32);
            } else {
                newStr = newStr + str.charAt(i);
            }
        }
        return newStr;
     }

     public static void PrintArr(int [] arr) {
         for (int i = 0; i <arr.length ; i++) {
             System.out.println(arr[i]);
         }
     }
}



