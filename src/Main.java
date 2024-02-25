import java.util.InputMismatchException;
import java.util.Scanner;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
//        List q = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
//        String name = scanner.nextLine();
//        System.out.println(name);
////
//        // Adds elements {0, 1, 2, 3, 4} to
//        // the queue
//        for (int i = 0; i < 5; i++)
//            q.add(i);
//
//        // Display contents of the queue.
//        System.out.println("Elements of queue "
//                + q);
//
//        // To remove the head of queue.
//        int removedele = q.remove(2);
//        System.out.println("removed element-"
//                + removedele);
//
//        System.out.println(q);


//        Sample<Integer> sam = new Sample<>();
//        sam.setX(76);
//        sam.setY(12);
//        System.out.println(sam.getX());


//        IntStream.rangeClosed(0, 5)
//                .forEach(System.out::println);

//
//        IntStream.iterate(0, i -> i < 40    , i -> i + 3)
//                .takeWhile(i -> i <= 20)
//                .forEach(System.out::println);

//        String myString = "HeLlo, World!";

//        User user = new User();
//        User user1  = new User();
//        Integer[] x = new Integer[4];
//        x[0] = 1;
//        Set<Integer> mySet = new HashSet<Integer>();
//        mySet.add(1);
//        mySet.add(2);
//        mySet.add(3);
//        mySet.add(4);
//        List <Integer> numList = new ArrayList<Integer>(mySet);
//        for(Object element : numList){
//            System.out.print(element + "  ");
//        }
//
//        user.x = 1;
//        user1.x=1;
//        System.out.println(user.equals(user1));

//        FuncInterface fobj = (int x)->{System.out.println(2*x);System.out.println(2*x);};
//        fobj.abstractFun(5);
//        fobj.normalFun();

//        Logger logger = Logger.getLogger("MyApplicationLogger");
//        Consumer<String> log = logger::config;
//        Consumer<String> print = System.out::println;
//
//        Consumer<String> printAndLog = log.andThen(print);
//        printAndLog.accept("naveen");

//        List<Integer> listOfNumbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24);
//        listOfNumbers.parallelStream().forEach(number ->
//                System.out.println(number + " " + Thread.currentThread().getName())
//        );
//
//        listOfNumbers.stream().parallel().forEach(x -> System.out.println("value of x is "+x+ " " + Thread.currentThread().getName()));
//
//
//        List<Integer> newary = listOfNumbers.stream().filter(x -> {
//            if(x%2==0){
//                return true;
//            }
//            return false;
//
//        }).filter(a -> a % 4 == 0).toList();
//
//        for (Integer x : newary) {
//            System.out.println(x);
//        }
//
//
//        int[] ary = {1, 2, 3, 4, 0, 11, 12, 13, 14, 18, 19, 20, 21, 23, 24};
//        String chString
//                = Stream.of(ary)
//                .map(arr -> new String(Arrays.toString(arr)))
//                .collect(Collectors.joining());
//        System.out.println(chString);
//
//        List<Integer> avg= List.of(1, 2, 3, 4, 0, 11, 12, 13, 14, 18, 19, 20, 21, 23, 24);


//        String s = "abc-de3-2fg";
//        s.chars().filter(Character::isLetter).map((x) -> {
//                    if (Character.isLowerCase(x)){
//                        return String.valueOf(x).toUpperCase().charAt(0);
//                    }else{
//                        return String.valueOf(x).toLowerCase().charAt(0);
//                    }
//        } ).forEach(System.out::println);
//                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
//                .toString();
//        System.out.println(s1);

//        String sentence = "The World Is Beautifull.";
//
//
//        Stream.of(Arrays.stream(sentence.split(""))).forEach(x->System.out.println(x.getClass()));
//        String sentence = "The World Is Beautifull.";

//        String reversedCase = new StringBuilder(sentence)
//                .chars()
//                .mapToObj(c -> Character.isUpperCase(c) ? Character.toLowerCase(c) : Character.toUpperCase(c))
//                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
//                .reverse()
//                .toString();
//
//        System.out.println(reversedCase);

//        String newStr = sentence.chars().mapToObj(x->(char)x).map(c -> Character.isUpperCase(c) ? Character.toLowerCase(c) : Character.toUpperCase(c))
//                .toList().toString().replace(", ", "").replace("[","").replace("]","");
//
//        System.out.println(newStr);

//        int str;
//        try {
//            str = scanner.nextInt();
//            System.out.println(str);
//        } catch (NullPointerException e) {
//            System.out.println(e);
//        } catch (InputMismatchException e) {
//            System.out.println("itrs");
//        }
//sample();

//        try {
//            fun();
//        }
//        catch (NullPointerException e) {
//            System.out.println(e.getMessage());
//        }
    }
    static boolean sample() {
        System.out.print("Type a number:");
        try {
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            System.out.println(n);
            return true;
        } catch (Exception e) {
            return sample();
        }
    }

    static void fun() {
            throw new NullPointerException("demo");
//        try {
//        } catch (NullPointerException e) {
//            System.out.println("Caught inside fun().");
//            throw e; // rethrowing the exception
//        }

    }

    static void sample1(int... x){
        System.out.println(x[0]);
    }

}