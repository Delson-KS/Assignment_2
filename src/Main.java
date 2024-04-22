class Main{
    public static void main(String[] args) {
        MyLinkedList<Integer> arr =new MyLinkedList<>();
          arr.add(1);
          arr.add(2);
          arr.add(3);
          arr.add(4);
          arr.add(5);
          arr.addFirst(0);
          arr.addLast(6);
          arr.removeFirst();
//        for(int i=0;i<ar.size();i++){
//            System.out.println(arr.get(i));
//        }
        System.out.println(arr.size());
        //System.out.println(arr.exists(2));
        for(int i =0;i<arr.size();i++){
            System.out.println(arr.get(i));
        }
    }
}