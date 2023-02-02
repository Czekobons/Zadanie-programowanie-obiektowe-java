public class Main {
    public static void main(String[] args) {
        Animal dog = new Animal("Terrier", 5.0);
        dog.feed();
        for(int i=0;i<4;i++) {
            dog.takeForWalk();
        }
        dog.feed();
        dog.takeForWalk();
    }
}