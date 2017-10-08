package pl.sda.javawwa.Prowadzacy;

import java.util.ArrayList;
import java.util.List;

/**
 * Mozemy powiedziec watkowi by ten poczekal az skonczy sie inny watek. Czy
 * kolejnosc startowania watkow ma znaczenie?
 *
 * @author mj
 */
public class Join {

    static List<String> doZapisu = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
/*
        Thread a = new Thread(() -> {
			System.out.println("Watek A");
		});
		Thread b = new Thread(() -> {
			try {
				a.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Watek B");
		});
		Thread c = new Thread(() -> {
			try {
				a.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Watek C");
		});

		b.start();
		a.start();
		c.start();
*/

        LancuchWatkow lwa = new LancuchWatkowA();
        LancuchWatkow lwb = new LancuchWatkowB();
        LancuchWatkow lwc = new LancuchWatkowC();
        lwb.setWatekDoZjoinowania(lwa);
        lwc.setWatekDoZjoinowania(lwb);

        lwa.start();
        lwb.start();
        lwc.start();

//        lwc.join();
        Thread.sleep(5);
        // to jest tylko po to żeby kod z wątków a i b i c zdążył się wykonać
        // bez tego sout może się wykonać zanim w ogóle wątki cokolwiek dodadzą do listy
        System.out.println(doZapisu);
    }

}

class LancuchWatkow extends Thread {
    private Thread watekDoZjoinowania;
    private String napis;

    public LancuchWatkow(String napis) {
        this.napis = napis;
        //setDaemon(true);
    }

    public void run() {
        if (watekDoZjoinowania != null) {
            try {
                watekDoZjoinowania.join();
            } catch (InterruptedException e) {
            }
        }
        Join.doZapisu.add(napis);
    }

    public void setWatekDoZjoinowania(Thread watekDoZjoinowania) {
        this.watekDoZjoinowania = watekDoZjoinowania;
    }
}

class LancuchWatkowA extends LancuchWatkow {
    LancuchWatkowA() {
        super("A");
    }
}

class LancuchWatkowB extends LancuchWatkow {
    LancuchWatkowB() {
        super("B");
    }
}

class LancuchWatkowC extends LancuchWatkow {
    LancuchWatkowC() {
        super("C");
    }
}
