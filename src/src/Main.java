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
public class Main {
    public static void main(String[] args) {
        Worker w1 = new Worker(1,"Иванов Иван Иваныч", "руководитель", 50, 100000,20,30,20);
        Worker w2 = new Worker(1,"Иванов Иван Иваныч2", "неруководитель", 40, 90000,10,8,8);
        Worker w3 = new Worker(1,"Иванов Иван Иваныч3", "неруководитель", 70, 80000,10,20,14);
        Worker w4 = new Worker(1,"Иванов Иван Иваныч4", "неруководитель", 55, 70000,10,15,10);
        Worker w5 = new Worker(1,"Иванов Иван Иваныч5", "неруководитель", 60, 60000,10,17,16);
        Worker w6 = new Worker(1,"Иванов Иван Иваныч6", "неруководитель", 20, 50000,10,10,15);
        Worker w7 = new Worker(1,"Иванов Иван Иваныч7", "неруководитель", 30, 40000,10,13,9);

        ArrayList<Worker> workers = new ArrayList<>();
        workers.add(w1);
        workers.add(w2);
        workers.add(w3);
        workers.add(w4);
        workers.add(w5);
        workers.add(w6);
        workers.add(w7);


    }
}
