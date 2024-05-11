package asik2;

public class  check_Index  {
    //class that catch exceptions
    int index_check(int index,int length){
        if(index<0 || index>length){
            throw new RuntimeException("Out of length: "+length + ", Index: "+index);
        }
        else
            return index;
    }
}
