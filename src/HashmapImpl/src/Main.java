public class Main {
    public static void main(String[] args) {
        MyHashMap<Integer,String> map = new MyHashMap<Integer,String>(7);
        map.put(1,"A");
        map.put(2,"B");
        map.put(3,"C");
        map.put(4,"D");
        map.put(5,"E");
        map.put(6,"F");
        map.put(7,"G");
        map.put(8,"H");
        map.put(9,"I");
        map.put(10,"J");

        String value = map.get(0);
        System.out.println(value);
    }
}