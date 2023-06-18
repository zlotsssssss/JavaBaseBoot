package wx.th.zlo.javabaseboot.pqrst.s.sort;



import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] a = {7,6,123,1,2,10};

        DivideConquer(a,0,5);
        //Merge(a,0,2,5);
        for (int i : a) {
            System.out.println(i);
        }
    }

    public static void DivideConquer(int[] a,int start,int end){
        if(start == end){
            return;
        }
        if(end -1 == start){
            if(a[start] > a[end]){
                int temp = a[start];
                a[start] = a[end];
                a[end] = temp;
            }
            return;
        }
        int div = (start+end) / 2;
        DivideConquer(a,start,div);
        DivideConquer(a,div+1,end);
        Merge(a,start,div,end);
    }

    //将2个有序的数组合并排序
    public static void Merge(int[] c,int start,int div,int end){
        int[] a = Arrays.copyOfRange(c,start,div+1);
        int[] b = Arrays.copyOfRange(c,div+1,end+1);
        int aLength = a.length;
        int bLength = b.length;
        int[] res = new int[aLength + bLength ];
       // if( aLength < bLength)  aLength =bLength;
        int a_index = 0,b_index =0,re_index=0;
        for(; re_index < res.length ; re_index++){
           if(a_index == aLength ){
               res[re_index] = b[b_index];
           }else if(b_index == bLength){
               res[re_index] = a[a_index];
           }else {
               if(a[a_index] < b[b_index]) {
                   res[re_index] = a[a_index];
                   a_index++;
               }else{
                   res[re_index] = b[b_index];
                   b_index++;
               }
           }
        }
        System.arraycopy(res,0,c,start,res.length);
        return ;
    }
}
