import java.math.BigInteger;

class Main
{

    public static void main(String[] args)
    {
        Primes primeNum = new Primes();

        String message = TextReader.ReadText("messages/Input.txt");


        int g = primeNum.GetPrimeNumber();
        int p = primeNum.GetPrimeNumber();


        Abonent alice = new Abonent("Alice", g, p, message);
        Abonent bob = new Abonent("Bob", g, p);


        BigInteger keyAlice = alice.GetKey(bob.public_M);
        BigInteger keyBob = bob.GetKey(alice.public_M);

        System.out.println("Конечный ключ Алисы: " + keyAlice + " Конечный ключ Боба: " + keyBob);

        String encrypteMessage = alice.SendMessage(keyAlice);

        TextReader.WriteText("messages/Encrypted.txt", encrypteMessage);

        String decryptedMessage = bob.GetMessage(encrypteMessage, keyBob);

        TextReader.WriteText("messages/Decrypted.txt", decryptedMessage);
    }
}