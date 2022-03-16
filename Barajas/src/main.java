import java.util.*;

public class main {

    public static void main(String[] args) {

        //creador de objetos - usamos el nombre de la clase Carta
        Carta carta = new Carta();

        //Usamos los valores del arraylist de la clase Carta
        int PALOS = carta.palo.length;
        int VALORES = carta.valor.length;

        //multiplicamos los palos y las 13 cartas para generar 52 cartas
        int N = PALOS * VALORES;

        //se usa un ciclo for que primero recorreo los valores
        // y luego los palos para generar nuestra baraja
        ArrayList<String> baraja = new ArrayList<String>();
        for (int i=0; i <VALORES; i++){
            for (int j = 0; j < PALOS; j++){
                baraja.add(carta.palo[j] + " " + carta.valor[i]);
            }
        }

        //el iterator ayuda a hacer bucles en colleciones tipo ArrayList
        //ayuda a mostrar en pantalla las cartas y todos sus elementos
        //para ello usamos el " / "
        Iterator<String> nombreIterator = baraja.iterator();
        while (nombreIterator.hasNext()){
            String elemento = nombreIterator.next();
            System.out.println(elemento + " / ");
        }

    //metodos que usaremos con las cartas
    //los metodos se generaran abajo
    shuffle(baraja); //barajear
    head(baraja); //Mostrar la carta al tope del deck -- quitar del resto del deck
    pick(baraja); //agarrar una carta al azar -- quitar del resto del deck
    hand(baraja); ////robar 5 cartas del deck
    }

    ///////////
    public static void shuffle(ArrayList baraja){
        ArrayList<String> valores = baraja;
        Collections.shuffle(valores);
        System.out.println("\nSe mezclo el deck");
        Iterator<String> nombreIterator2 = baraja.iterator();

        while (nombreIterator2.hasNext()){
            String elemento = nombreIterator2.next();
            System.out.println(elemento + " / ");
        }
    }
    ////////////
    //afarra la carta que está en la posición 0 del array - la quita con .remove
    public static void head(ArrayList baraja){
        System.out.println(baraja.get(0));
        baraja.remove(0);
        System.out.println("Aun quedan " + baraja.size() + " cartas en el deck \n");
    }

    //genera un numero aleatorio y toma la carta en esa posicion
    //despues remueve esa carta
    public static void  pick(ArrayList baraja){
        Random aleatorio = new Random();
        System.out.println(baraja.get(aleatorio.nextInt(baraja.size())));
        baraja.remove("Aun quedan " + baraja.size() + " cartas en el deck \n");
    }

    //remueve 5 cartas - 1 a la vez
    public static void hand(ArrayList baraja){
        for (int i=0; i<=4; i++){  //5 cartas
            System.out.println(baraja.get(i));
        }
        for (int i=0; i<=4; i++){
            baraja.remove(i);
        }
        System.out.println("Aun quedan " + baraja.size() + " cartas");
    }
}