package com.goforit.homework;

/**
 * Created by junqingfjq on 15/11/22.
 */
public class BinarySearch implements Search {

    @Override
    public int searchInt(int[] array, int des) {
        if (array.length <=0 ){
            return -1;
        }

        int highPos=array.length-1;
        int lowPos=0;
        while (lowPos<=highPos){
            int middle=(highPos+lowPos)/2;
            if( des == array[middle] ){
                return middle;
            }else if(des<array[middle]){
                highPos=middle-1;
            }else {
                lowPos=middle+1;
            }
        }
        return -1;
    }



    public static void main(String [] argvs){

        int [] array=new int[] {1,3,4,6,11,55,65,120};
        Search search=new BinarySearch();

        System.err.println(search.searchInt(array,1));

    }
}
