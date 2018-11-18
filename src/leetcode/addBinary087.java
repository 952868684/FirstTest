package leetcode;
public static void main (String [] args){
	addBinary a = new addBinary();
}
public class addBinary {

 	public String addBinary(String a, String b) {
 		
        int aLength = a.length();
        int bLength = b.length();
        ArrayList<Integer> alist = new ArrayList<Integer>();
        ArrayList<Integer> blist = new ArrayList<Integer>();
        //通过两个arraylist来存储a和b字符串的每一位  这儿采用的是倒叙存储  这样方便按位进行计算
        String result = "";
        for(int i = 0; i < aLength; i++){
            alist.add(0,Integer.parseInt(a.substring(i,i+1)));
        }
        
        for(int j = 0; j < bLength; j++){
            blist.add(0,Integer.parseInt(b.substring(j,j+1)));
        }
        
        //记住进位
        int k = 0;
        int pluseNum = 0;
        //两两相加   按二进制的计算方式计算
        while(k < aLength && k < bLength){
            int a1 = alist.get(k);
            int b1 = blist.get(k);
            
            int sum = a1 + b1 + pluseNum;
            if(sum >= 2){
                sum = sum % 2;
                result = String.valueOf(sum)+result;
                pluseNum = 1;
            }else{
            	result = String.valueOf(sum)+result;
                pluseNum = 0;
            }
            k++;
        }
        
        //对于a剩余的部分   依次计算
        if(k < aLength){
            int i = k;
            while(i < aLength){
                int a2 = alist.get(i);
                int sum = a2 + pluseNum;
                if(sum >= 2){
                    sum = sum % 2;
                    result = String.valueOf(sum)+result;
                    pluseNum = 1;
                }else{
                	result = String.valueOf(sum)+result;
                    pluseNum = 0;
                }
                i++;
                
            }
        }
        
        //对于b剩余的部分  依次计算
        if(k < bLength){
            int i = k;
            while(i < bLength){
                int b3 = blist.get(i);
                int sum = b3 + pluseNum;
                if(sum >= 2){
                    sum = sum % 2;
                    result = String.valueOf(sum)+result;
                    pluseNum = 1;
                }else{
                	result = String.valueOf(sum)+result;
                    pluseNum = 0;
                }
                i++;
            }
        }
        
        //别忘记最后的进位
        if(pluseNum == 1){
            result = String.valueOf(pluseNum)+result;
        }
        
        return result;
    }
}