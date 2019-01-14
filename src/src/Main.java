//15
//имеется в виду отдел кадров некоторого предприятия, выпуск некий вид продукц
//сотруд имеет индекс фио должн возраст оклад стаж работы продолжит отпуска
//руководит имеет рейтинг популярности у сотрудникоа
//исполнитель имеет процент брака при изготовлении продукц
//действия ок: 1) тех у кого стаж р более 25 лет премируют увеличением отпуска на 5 дней
//2) первых 5 чел с наибольшим процентом брака штрафуют уменьшением оклада на 10 процентов
//3)поступает еще 1 чел вводом. заносят все данные на него. включают в списки.если чел старше 60 лет или моложе 25,то
// выбрасывают искл (слишком старый/слишком молодой)
//4) увольняют (отправл на пенсию сотр) старше 60 лет

// задание принял


import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

class Worker
{
    int index;
    String fio;
    String doljn;
    int vozrast;
    double oklad;
    int staj;
    int otpusk;
    int ratingorbrak;
    public Worker(int in, String f, String d,int voz, double ok, int st, int otp, int rat)
    {
        index = in;
        fio = f;
        doljn = d;
        vozrast = voz;
        oklad = ok;
        staj = st;
        otpusk = otp;
        ratingorbrak = rat;
    }
    public void Display()
    {
        System.out.println("index: "+index);
        System.out.println("fio: "+fio);
        System.out.println("doljn: "+doljn);
        System.out.println("vozrast: "+vozrast);
        System.out.println("oklad: "+oklad);
        System.out.println("staj: "+staj);
        System.out.println("otpusk: "+otpusk);
        if (doljn.equals("руководитель"))
            System.out.println("rating: "+ratingorbrak);
        else
            System.out.println("brak: "+ratingorbrak);
    }
}

class ComparatorBrak implements Comparator<Worker> {  // компаратор для того чтобы сортировать брак по убыванию

    public int compare(Worker a, Worker b){

        if (a.ratingorbrak>b.ratingorbrak)    // тут получается если брак чувака а больше брака чувака б, то при сортировки чувак а должен идти раньше чувака б
            return -1;
        if (a.ratingorbrak<b.ratingorbrak)    // тут чувак а должен идти позже чувака б
            return 1;
        return 0;   // если браки одинаковые то без разницы кто раньше кто позже
    }
}
public class Main {
    public static void Display(ArrayList<Worker> workers)
    {
        for (int i = 0; i<workers.size(); i++) {
            workers.get(i).Display();
            System.out.println();
        }
    }
    public static void main(String[] args) throws MyException {
        Worker w1 = new Worker(1, "Иванов Иван Иваныч", "руководитель", 50, 100000, 20, 30, 20);
        Worker w2 = new Worker(2, "Иванов Иван Иваныч2", "исполнитель", 40, 90000, 10, 8, 8);
        Worker w3 = new Worker(3, "Иванов Иван Иваныч3", "исполнитель", 70, 80000, 26, 20, 14);
        Worker w4 = new Worker(4, "Иванов Иван Иваныч4", "исполнитель", 55, 70000, 27, 15, 10);
        Worker w5 = new Worker(5, "Иванов Иван Иваныч5", "исполнитель", 61, 60000, 3, 17, 16);
        Worker w6 = new Worker(6, "Иванов Иван Иваныч6", "исполнитель", 20, 50000, 1, 10, 15);
        Worker w7 = new Worker(7, "Иванов Иван Иваныч7", "исполнитель", 30, 40000, 15, 13, 9);

        ArrayList<Worker> workers = new ArrayList<>();
        workers.add(w1);
        workers.add(w2);
        workers.add(w3);
        workers.add(w4);
        workers.add(w5);
        workers.add(w6);
        workers.add(w7);

        Display(workers);

        // 1) тех у кого стаж р более 25 лет премируют увеличением отпуска на 5 дней
        for (int i = 0; i < workers.size(); i++)
            if (workers.get(i).staj > 25)
                workers.get(i).otpusk += 5;
        Display(workers);

        //2) первых 5 чел с наибольшим процентом брака штрафуют уменьшением оклада на 10 процентов

        ArrayList<Worker> firstfive = new ArrayList<>();
        for (int i = 0; i < workers.size(); i++)
            if (workers.get(i).doljn.equals("исполнитель"))
                firstfive.add(workers.get(i));

        ComparatorBrak cmp = new ComparatorBrak();
        firstfive.sort(cmp);
        for (int i = 0; i < workers.size(); i++)
            for (int j = 0; j < 5; j++) {
                if (firstfive.get(j).equals(workers.get(i))) {
                    workers.get(i).oklad *= 0.9;
                    break;
                }
            }
        Display(workers);

        //3)поступает еще 1 чел вводом. заносят все данные на него. включают в списки.если чел старше 60 лет или моложе 25,то
        // выбрасывают искл (слишком старый/слишком молодой)

        Scanner sc = new Scanner(System.in);
        int index = sc.nextInt();
        String fio = sc.next();
        String doljn = sc.next();
        int vozrast = sc.nextInt();
        double oklad = sc.nextDouble();
        int staj = sc.nextInt();
        int otpusk = sc.nextInt();
        int ratingorbrak = sc.nextInt();

        Worker w = new Worker(index, fio, doljn, vozrast, oklad, staj, otpusk, ratingorbrak);
        workers.add(w);
        if (vozrast < 25 || vozrast > 60)
            throw new MyException(vozrast);
        Display(workers);
        //4) увольняют (отправл на пенсию сотр) старше 60 лет

        for (int i = 0; i < workers.size(); i++)
            if (workers.get(i).vozrast > 60) {
                workers.remove(i);
                i--;
            }
        Display(workers);
    }
}

class MyException extends Exception // класс со своим исключением
{
    public MyException(int age)
    {
        if (age<25)
            System.out.println("Сотрудник слишком молод");
        if (age>60)
            System.out.println("Сотрудник слишком стар");
    }
}
